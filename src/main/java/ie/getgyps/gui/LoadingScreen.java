package ie.getgyps.gui;

import net.minecraft.client.gui.ResourceLoadProgressGui;
import net.minecraft.util.ColorHelper;

public class LoadingScreen {
    public static void bg(int red, int green, int blue) {
        ResourceLoadProgressGui.field_238627_b_ = ColorHelper.PackedColor.packColor(255, 0, 255, 0); // ORIGINAL: 239, 50, 61
    }
}
