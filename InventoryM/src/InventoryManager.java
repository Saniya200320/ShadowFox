import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<InventoryItem> items;

    public InventoryManager() {
        items = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public boolean updateItem(String id, InventoryItem updatedItem) {
        for (InventoryItem item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                items.add(updatedItem);
                return true;
            }
        }
        return false;
    }

    public boolean deleteItem(String id) {
        return items.removeIf(item -> item.getId().equals(id));
    }

    public List<InventoryItem> getAllItems() {
        return items;
    }
}
