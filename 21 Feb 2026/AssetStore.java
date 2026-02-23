import java.util.HashMap;

public class AssetStore {

    private HashMap<String, Asset> store = new HashMap<>();

    public void addAsset(Asset asset) {
        store.put(asset.getAssetId(), asset);
    }

    public Asset findAsset(String assetId) throws NullPointerException {
        Asset asset = store.get(assetId);
        if (asset == null) {
            throw new NullPointerException("Asset not found: " + assetId);
        }
        return asset;
    }

    public void markBorrowed(Asset a) throws IllegalStateException {
        if (!a.isAvailable()) {
            throw new IllegalStateException(
                "Asset already borrowed: " + a.getAssetId() + " - " + a.getAssetName()
            );
        }
        a.setAvailable(false);
    }

    public HashMap<String, Asset> getAll() {
        return store;
    }
}
