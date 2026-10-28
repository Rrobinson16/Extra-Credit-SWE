
package project.api;
    
public class OrderProcessor {

    private InventoryService inventoryService;

    public OrderProcessor(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

 public boolean processOrder(String itemId, int quantity) {

    if (inventoryService.isInStock(itemId, quantity)) {
        inventoryService.reserveItem(itemId, quantity);
        return true;
    } else {
        return false;
    }
 }
}