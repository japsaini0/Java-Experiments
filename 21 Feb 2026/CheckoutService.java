import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CheckoutService {

    private HashMap<String, Student> studentStore;
    private AssetStore assetStore;

    public CheckoutService(HashMap<String, Student> studentStore, AssetStore assetStore) {
        this.studentStore = studentStore;
        this.assetStore   = assetStore;
    }

    public String checkout(CheckoutRequest req)
            throws IllegalArgumentException, IllegalStateException,
                   SecurityException, NullPointerException {

        ValidationUtil.validateUid(req.getUid());
        ValidationUtil.validateAssetId(req.getAssetId());
        ValidationUtil.validateHours(req.getHoursRequested());

        Student student = studentStore.get(req.getUid());
        if (student == null) {
            throw new NullPointerException("Student not found in system: " + req.getUid());
        }
        Asset asset = assetStore.findAsset(req.getAssetId());

        student.checkFinePolicy();
        student.checkBorrowLimitPolicy();

        asset.checkAvailabilityPolicy();
        asset.checkSecurityPolicy(req.getUid());

        int hours = req.getHoursRequested();

        if (asset.getAssetName().contains("Cable") && hours > 3) {
            req.setHoursRequested(3);
            System.out.println(
                "  [POLICY] Policy applied: Cables can be issued max 3 hours. Updated to 3."
            );
        }

        if (req.getHoursRequested() == 6) {
            System.out.println(
                "  [WARNING] Note: Max duration selected. Return strictly on time."
            );
        }

        assetStore.markBorrowed(asset);
        student.setCurrentBorrowCount(student.getCurrentBorrowCount() + 1);

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return "TXN-" + date + "-" + req.getAssetId() + "-" + req.getUid();
    }
}
