/**
 * Created by a539504 on 05/08/2016.
 */
public class StockItem {
    private String itemName;
    private int price;

    protected int getPrice() {
        return price;
    }


    private StockItem() {
    }

    private StockItem(String fruit, Integer value) {
        itemName = fruit;
        price = value;
    }

    public static StockItem create() {
        return new StockItem();
    }

    public static StockItem create(String fruit, int value) {
        return new StockItem(fruit, value);
    }
}
