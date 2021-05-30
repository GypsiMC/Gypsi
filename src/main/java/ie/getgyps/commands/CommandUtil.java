package ie.getgyps.commands;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandUtil {
    public static void reply(CommandContext<CommandSource> cmdsrc, String reply) {
        cmdsrc.getSource().sendFeedback(new TranslationTextComponent(reply), true);
    }
}
