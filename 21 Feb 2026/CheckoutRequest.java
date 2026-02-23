public class CheckoutRequest {

    private String uid;
    private String assetId;
    private int    hoursRequested;

    public CheckoutRequest(String uid, String assetId, int hoursRequested) {
        this.uid            = uid;
        this.assetId        = assetId;
        this.hoursRequested = hoursRequested;
    }

    public String getUid()            { return uid; }
    public String getAssetId()        { return assetId; }
    public int    getHoursRequested() { return hoursRequested; }

    public void setHoursRequested(int hoursRequested) {
        this.hoursRequested = hoursRequested;
    }

    @Override
    public String toString() {
        return "CheckoutRequest{uid='" + uid + "', assetId='" + assetId +
               "', hours=" + hoursRequested + "}";
    }
}
