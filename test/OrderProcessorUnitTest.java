
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import project.api.InventoryService;
import project.api.OrderProcessor;

public class OrderProcessorUnitTest {

    @Test
    public void testProcessOrder_InStock() {

        InventoryService inventory = mock(InventoryService.class);

        when(inventory.isInStock("Iphones", 10))
            .thenReturn(true);

        OrderProcessor processor = new OrderProcessor(inventory);

        boolean result = processor.processOrder("Iphones", 10);

        assertTrue(result);
    }

    @Test
    public void testProcessOrder_OutOfStock() {

        InventoryService inventory = mock(InventoryService.class);

        when(inventory.isInStock("Iphones", 5))
            .thenReturn(false);

        OrderProcessor processor = new OrderProcessor(inventory);

        boolean result = processor.processOrder("Iphones", 5);

        assertFalse(result);
    }
}
