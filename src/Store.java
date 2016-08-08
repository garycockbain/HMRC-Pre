import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a539504 on 05/08/2016.
 */
public class Store {
    private HashMap <String, StockItem> stockList;
    private HashMap<String, StoreOffer> storeOffers;

    public Store() {
        stockList = new HashMap<String, StockItem>();
        storeOffers = new HashMap<String, StoreOffer>();
    }

    public void addStockItem(String itemName, int value) {

        StockItem stockItem = StockItem.create(itemName, value);
        stockList.put(itemName, stockItem);
    }

    public void addStoreOffer(String itemName, int item, int value) {

        StoreOffer storeOffer = StoreOffer.create(item, value);
        storeOffers.put(itemName, storeOffer);
    }


    public Integer getPrice(String itemName) throws Exception {
        StockItem item = stockList.get(itemName);
        if (item == null) {
            throw new Exception(itemName + " not in stock");
        }
        return(item.getPrice());
    }

    public List<StockItem> buyItems(String[] itemNames) throws Exception {
        List<StockItem> items = new ArrayList<>();
        for (String itemName : itemNames) {
            StockItem item = stockList.get(itemName);
            if (item == null) {
                throw new Exception(itemName + " not in stock");
            }

            StoreOffer offer = storeOffers.get(itemName);
            if ((offer == null) || (!offer.isItemFree())){
                items.add(item);
            }
        }
        return items;
    }

     Integer checkoutItems(List<StockItem> items) {
         Integer totalPrice = 0;
        for (StockItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
