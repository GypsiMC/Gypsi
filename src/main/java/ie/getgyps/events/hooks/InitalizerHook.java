package ie.getgyps.events.hooks;

import java.util.List;
public interface InitalizerHook {
    String name = "";
    String modid = "";
    String description = "";
    String version = "";
    String authors = "";
    boolean api = false;
    boolean _APPEAR_ON_LOAD = true;
}
