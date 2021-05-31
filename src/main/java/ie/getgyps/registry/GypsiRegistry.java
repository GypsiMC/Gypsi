package ie.getgyps.registry;

import com.google.common.collect.Lists;
import com.mojang.brigadier.Command;
import ie.getgyps.obtainables.SimpleBlockItem;
import ie.getgyps.obtainables.block.SimpleBlock;
import ie.getgyps.obtainables.item.SimpleItem;
import net.minecraft.block.Block;
import net.minecraft.command.CommandSource;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class GypsiRegistry {
    public static List<Command<CommandSource>> cmdsrclist = Lists.newArrayList();
    public static List<String> namelist = Lists.newArrayList();
    public static List<Integer> permlist = Lists.newArrayList();
    public static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }
    public static Block register(String key, SimpleBlock blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn.result());
    }
    public static Item register(String key, Item itemIn) {
        return Registry.register(Registry.ITEM, key, itemIn);
    }
    public static Item register(String key, SimpleItem itemIn) {
        return Registry.register(Registry.ITEM, key, itemIn.result());
    }
    public static BlockItem register(String key, BlockItem blockItemIn) {
        return Registry.register(Registry.ITEM, key, blockItemIn);
    }
    public static BlockItem register(String key, SimpleBlockItem blockItemIn, SimpleBlock block) {
        return Registry.register(Registry.ITEM, key, blockItemIn.result());
    }
    public static BlockItem register(String key, SimpleBlockItem blockItemIn, Block block) {
        return Registry.register(Registry.ITEM, key, blockItemIn.result());
    }
    public static void register(String name, int perm, Command<CommandSource> cmd) {
        cmdsrclist.add(cmd);
        namelist.add(name);
        permlist.add(perm);
    }
}
