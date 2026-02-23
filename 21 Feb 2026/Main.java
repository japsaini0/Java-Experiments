import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String, Student> students = new HashMap<>();
        students.put("KRG10785", new Student("KRG10785", "JAP",  0, 0));
        students.put("KRG20345", new Student("KRG20345", "Priya Nair",   50, 1));
        students.put("KRG20456", new Student("KRG20456", "Rahul Singh",   0, 2));
        students.put("STD99001", new Student("STD99001", "Vikram Das",    0, 0));

        AssetStore store = new AssetStore();
        store.addAsset(new Asset("LAB-101", "HDMI Cable",        true,  1));
        store.addAsset(new Asset("LAB-202", "Arduino Kit",       true,  2));
        store.addAsset(new Asset("LAB-303", "Oscilloscope",      false, 1));
        store.addAsset(new Asset("LAB-404", "Spectrum Analyzer", true,  3));

        CheckoutService service = new CheckoutService(students, store);

        CheckoutRequest[] requests = {
            new CheckoutRequest("KRG20281", "LAB-101", 4),
            new CheckoutRequest("KRG20281", "LAB-202", 9),
            new CheckoutRequest("KRG20345", "LAB-202", 2),
            new CheckoutRequest("KRG20456", "LAB-303", 1),
            new CheckoutRequest("STD99001", "LAB-404", 2),
            new CheckoutRequest("KRG20281", "LAB-202", 6),
        };

        String[] labels = {
            "Case 1 - Expected: SUCCESS (cable-policy fires)",
            "Case 2 - Expected: IllegalArgumentException  (hours = 9)",
            "Case 3 - Expected: IllegalStateException     (pending fine)",
            "Case 4 - Expected: IllegalStateException     (borrow limit)",
            "Case 5 - Expected: SecurityException         (restricted asset)",
            "Case 6 - Expected: SUCCESS + max-duration warning",
        };

        for (int i = 0; i < requests.length; i++) {
            CheckoutRequest req = requests[i];

            System.out.println();
            System.out.println("======================================================");
            System.out.println("  " + labels[i]);
            System.out.println("  UID=" + req.getUid() +
                               "  Asset=" + req.getAssetId() +
                               "  Hours=" + req.getHoursRequested());
            System.out.println("======================================================");

            try {
                String receipt = service.checkout(req);
                System.out.println("  [SUCCESS] Receipt: " + receipt);

            } catch (IllegalArgumentException e) {
                System.out.println("  [CAUGHT] IllegalArgumentException: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (NullPointerException e) {
                System.out.println("  [CAUGHT] NullPointerException: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (SecurityException e) {
                System.out.println("  [CAUGHT] SecurityException: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (IllegalStateException e) {
                System.out.println("  [CAUGHT] IllegalStateException: " + e.getMessage());
                AuditLogger.logError(e);

            } finally {
                AuditLogger.log(
                    "Audit: attempt finished for UID=" + req.getUid() +
                    ", asset=" + req.getAssetId()
                );
            }
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("  All checkout attempts processed. Session complete.");
        System.out.println("======================================================");
    }
}
