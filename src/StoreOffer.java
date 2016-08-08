/**
 * Created by a539504 on 05/08/2016.
 */
public class StoreOffer {
    String storeItem;

    private int itemsInOffer;
    private int itemsPaidFor;
    private int itemsBoughtSoFar = 0;

    public StoreOffer(int itemsInOffer, int itemsPaidFor) {
        this.itemsInOffer = itemsInOffer;
        this.itemsPaidFor = itemsPaidFor;
    }

    private StoreOffer() {
    }
    public static StoreOffer create() {
        return new StoreOffer();
    }

    public static StoreOffer create(int itemsInOffer, int itemsPaidFor) {
        return new StoreOffer(itemsInOffer, itemsPaidFor);
    }

    public boolean isItemFree() {
        boolean itemIsFree;
        // Was previous item on or over the offer limit
        int itemCount = itemsBoughtSoFar % itemsInOffer;

        itemIsFree = itemCount >= itemsPaidFor;

        itemsBoughtSoFar++;
        return itemIsFree;
    }
}
