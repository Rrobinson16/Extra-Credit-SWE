
package project.api;

public interface InventoryService {

    boolean isInStock(String itemId, int quantity);

    void reserveItem(String itemId, int quantity);
}
