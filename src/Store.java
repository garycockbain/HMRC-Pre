import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a539504 on 05/08/2016.
 */
public class Store {
    Map<String, StockItem> stockList = new HashMap<String, StockItem>();

    public Store() {
    }

    public void addStockItem(String fruit, int value) {

        StockItem item = StockItem.create(fruit, value);
        stockList.put(fruit, item);
    }


    public Integer getPrice(String itemName) throws Exception {
        StockItem item = stockList.get(itemName);
        if (item == null) {
            throw new Exception(itemName + " not in stock");
        }
        return(item.getPrice());
    }

    List<StockItem> buyItems(String[] itemNames) throws Exception {
        List<StockItem> items = new ArrayList<>();
        for (String itemName : itemNames) {
            StockItem item = stockList.get(itemName);
            if (item == null)
                throw new Exception(itemName + " not in stock");
            items.add(item);
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
