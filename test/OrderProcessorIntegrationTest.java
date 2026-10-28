
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import project.api.InventoryService;
import project.api.OrderProcessor;

import java.util.HashMap;

public class OrderProcessorIntegrationTest {

    @Test
    public void testOrderProcessorWithRealInventory() {

        InMemoryInventoryService inventory = new InMemoryInventoryService();

        inventory.addItem("Iphones", 10);

        OrderProcessor processor = new OrderProcessor(inventory);

        processor.processOrder("Iphones", 5);

        assertEquals(5, inventory.getQuantity("Iphones"));
    }
}

class InMemoryInventoryService implements InventoryService {

    private HashMap<String, Integer> inventory = new HashMap<>();

    public void addItem(String id, int amount) {
        inventory.put(id, amount);
    }

    public int getQuantity(String id) {
        return inventory.getOrDefault(id, 0);
    }

    @Override
    public boolean isInStock(String id, int amount) {
        if (getQuantity(id) >= amount) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reserveItem(String id, int amount) {
        if (isInStock(id, amount)) {
            int currentQuantity = getQuantity(id);

            inventory.put(id, currentQuantity - amount);
        }
    }
}
