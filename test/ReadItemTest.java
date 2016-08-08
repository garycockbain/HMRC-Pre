/**
 * Created by a539504 on 04/08/2016.
 */

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReadItemTest {
    Store store;
    @Before
    public void initialize() {
        store = new Store();
        store.addStockItem("Apple", 60);
        store.addStockItem("Orange", 25);
    }
    @Test
    public void testCreateStockList() {

        try {
            assertEquals(60, store.getPrice("Apple").intValue());
            assertEquals(25, store.getPrice("Orange").intValue());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testBuyItems() {
        try {
            String[] shoppingList = {"Apple", "Orange", "Apple"};
            List<StockItem> items = store.buyItems(shoppingList);
            assertEquals(3, items.size());
            assertEquals(60, items.get(0).getPrice());
            assertEquals(25, items.get(1).getPrice());
            assertEquals(60, items.get(2).getPrice());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testInvalidItem() {
        try {
            String[] shoppingList = {"Banana"};
            List<StockItem> items = store.buyItems(shoppingList);
            fail("");
        } catch (Exception e){
        }
    }

    @Test
    public void testCalculatePrice() throws Exception {
        String[] shoppingList = {"Apple", "Apple", "Orange", "Apple"};
        List<StockItem> items = store.buyItems(shoppingList);

        Integer totalPrice = store.checkoutItems(items);
        assertEquals(205, totalPrice.intValue());
    }

    @Test
    public void testCalculatePriceWithOffer() throws Exception {
        store.addStoreOffer("Apple", 2, 1);
        store.addStoreOffer("Orange", 3, 2);

        String[] shoppingList = {"Apple", "Orange", "Orange"};
        List<StockItem> items = store.buyItems(shoppingList);

        Integer totalPrice = store.checkoutItems(items);
        assertEquals(110, totalPrice.intValue());
    }

    @Test
    public void testCalculatePriceWithOfferOnOfferCount() throws Exception {
        store.addStoreOffer("Apple", 2, 1);
        store.addStoreOffer("Orange", 3, 2);

        String[] shoppingList = {"Apple", "Apple", "Orange", "Orange", "Orange"};
        List<StockItem> items = store.buyItems(shoppingList);

        Integer totalPrice = store.checkoutItems(items);
        // Extra items free
        assertEquals(110, totalPrice.intValue());
    }


    @Test
    public void testCalculatePriceWithOfferOverOfferAmount() throws Exception {
        store.addStoreOffer("Apple", 2, 1);
        store.addStoreOffer("Orange", 3, 2);

        String[] shoppingList = {"Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange"};
        List<StockItem> items = store.buyItems(shoppingList);

        Integer totalPrice = store.checkoutItems(items);
        // 1 item free
        assertEquals(195, totalPrice.intValue());
    }
}
