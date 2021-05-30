package ie.getgyps.registry;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import ie.getgyps.obtainables.SimpleBlockItem;
import ie.getgyps.obtainables.block.SimpleBlock;
import ie.getgyps.obtainables.item.SimpleItem;
import net.minecraft.block.Block;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class GypsiRegistry {
    private static final CommandDispatcher<CommandSource> dispatcher = new CommandDispatcher<>();
    private static final Commands commands = new Commands(Commands.EnvironmentType.ALL);
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
    public static LiteralCommandNode<CommandSource> register(String name, int perm, Command<CommandSource> cmd) {
        return commands.getDispatcher().register(Commands.literal(name).requires((p_198727_0_) ->
                p_198727_0_.hasPermissionLevel(perm)).executes(cmd));
    }
}
