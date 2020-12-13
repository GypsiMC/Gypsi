package ie.getgyps;

import ie.getgyps.gui.LoadingScreen;
import ie.getgyps.obtainables.SimpleBlockItem;
import ie.getgyps.obtainables.block.SimpleBlock;
import ie.getgyps.obtainables.item.SimpleItem;

public class Main {
    public static void init() {
        SimpleItem sitem = new SimpleItem().register("modabc", "itemdef");
        SimpleBlock sblock = new SimpleBlock().register("modabc", "blockdef");
        SimpleBlockItem sblockitem = new SimpleBlockItem(sblock).register("modabc", "blockdef");
        LoadingScreen.bg(255, 165,0);
    }
}
