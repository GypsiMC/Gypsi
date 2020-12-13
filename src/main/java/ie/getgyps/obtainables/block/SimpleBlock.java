package ie.getgyps.obtainables.block;

import ie.getgyps.obtainables.item.SimpleItem;
import ie.getgyps.registry.GypsiRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class SimpleBlock {
    static Block block = new Block(Block.Properties.create(Material.WOOL));
    public SimpleBlock fromBlock(Block blockIn) {
        block = blockIn;
        return this;
    }
    public Block result() {
        return block;
    }
    public SimpleBlock register(String modid, String blockName) {
        return fromBlock(GypsiRegistry.register(modid+":"+blockName, block));
    }
}
