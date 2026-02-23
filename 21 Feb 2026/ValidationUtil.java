public class ValidationUtil {

    private ValidationUtil() {}

    public static void validateUid(String uid) throws IllegalArgumentException {
        if (uid == null || uid.trim().isEmpty()) {
            throw new IllegalArgumentException("UID cannot be null or empty.");
        }
        if (uid.contains(" ")) {
            throw new IllegalArgumentException(
                "Invalid UID '" + uid + "': must not contain spaces."
            );
        }
        if (uid.length() < 8 || uid.length() > 12) {
            throw new IllegalArgumentException(
                "Invalid UID '" + uid + "': length must be 8-12 characters (got " + uid.length() + ")."
            );
        }
    }

    public static void validateAssetId(String assetId) throws IllegalArgumentException {
        if (assetId == null || assetId.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset ID cannot be null or empty.");
        }
        if (!assetId.startsWith("LAB-")) {
            throw new IllegalArgumentException(
                "Invalid Asset ID '" + assetId + "': must start with 'LAB-'."
            );
        }
        String suffix = assetId.substring(4);
        if (suffix.isEmpty() || !suffix.matches("\\d+")) {
            throw new IllegalArgumentException(
                "Invalid Asset ID '" + assetId + "': the part after 'LAB-' must be digits only."
            );
        }
    }

    public static void validateHours(int hrs) throws IllegalArgumentException {
        if (hrs < 1 || hrs > 6) {
            throw new IllegalArgumentException(
                "Invalid hours: " + hrs + ". Allowed range is 1-6."
            );
        }
    }
}
