package ie.getgyps.obtainables.item;

import ie.getgyps.registry.GypsiRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class SimpleItem {
    static Item item = new Item(new Item.Properties());
    public SimpleItem fromItem(Item itemIn) {
        item = itemIn;
        return this;
    }
    public Item result() {
        return item;
    }
    public SimpleItem register(String modid, String itemName) {
        return this.fromItem(GypsiRegistry.register(modid+":"+itemName, this));
    }
}
