import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by a539504 on 05/08/2016.
 */
public class StoreOfferTest {
    @Test
    public void testOffer(){
        StoreOffer offer = StoreOffer.create(3, 2);

        assertFalse ("1st Item not free", offer.isItemFree());
        assertFalse ("2nd Item not free", offer.isItemFree());
        assertTrue ("3rd Item free", offer.isItemFree());
        assertFalse ("4th Item not free", offer.isItemFree());
        assertFalse ("5th Item not free", offer.isItemFree());
        assertTrue ("6th Item free", offer.isItemFree());
    }
}
