public class Asset {

    private String  assetId;
    private String  assetName;
    private boolean available;
    private int     securityLevel;

    public Asset(String assetId, String assetName, boolean available, int securityLevel) {
        this.assetId       = assetId;
        this.assetName     = assetName;
        this.available     = available;
        this.securityLevel = securityLevel;
    }

    public String  getAssetId()       { return assetId; }
    public String  getAssetName()     { return assetName; }
    public boolean isAvailable()      { return available; }
    public int     getSecurityLevel() { return securityLevel; }

    public void setAvailable(boolean available) { this.available = available; }

    public void checkAvailabilityPolicy() throws IllegalStateException {
        if (!available) {
            throw new IllegalStateException(
                "Asset [" + assetId + " - " + assetName + "] is currently unavailable."
            );
        }
    }

    public void checkSecurityPolicy(String uid) throws SecurityException {
        if (securityLevel == 3 && !uid.startsWith("KRG")) {
            throw new SecurityException(
                "Asset [" + assetId + "] has security level 3. " +
                "Access restricted to KRG-prefix UIDs. Denied for UID: " + uid
            );
        }
    }

    @Override
    public String toString() {
        return "Asset{id='" + assetId + "', name='" + assetName +
               "', available=" + available + ", secLevel=" + securityLevel + "}";
    }
}
