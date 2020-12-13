package ie.getgyps.obtainables;

import ie.getgyps.obtainables.block.SimpleBlock;
import ie.getgyps.obtainables.item.SimpleItem;
import ie.getgyps.registry.GypsiRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class SimpleBlockItem {
    static BlockItem blockItem;
    static Block block;

    public SimpleBlockItem(Block blockIn) {
        block = blockIn;
        blockItem = new BlockItem(blockIn, new Item.Properties());
    }
    public SimpleBlockItem(SimpleBlock blockIn) {
        block = blockIn.result();
        blockItem = new BlockItem(blockIn.result(), new Item.Properties());
    }
    public BlockItem result() {
        return blockItem;
    }
    public SimpleBlockItem fromBlockItem(BlockItem blockItemIn) {
        blockItem = blockItemIn;
        return this;
    }
    public SimpleBlockItem register(String modid, String itemName) {
        return this.fromBlockItem(GypsiRegistry.register(modid+":"+itemName, this, block));
    }
}
