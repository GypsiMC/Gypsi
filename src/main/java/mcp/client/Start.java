package mcp.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import ie.getgyps.events.ClientModInitialization;
import net.minecraft.client.main.Main;

public class Start
{
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, IOException {
        /*
         * start minecraft game application
         * --version is just used as 'launched version' in snoop data and is required
         * Working directory is used as gameDir if not provided
         */
        String assets = System.getenv().containsKey("assetDirectory") ? System.getenv("assetDirectory") : "assets";
        Main.main(concat(new String[]{"--version", "mcp", "--accessToken","0","--username","aaa","--assetsDir", assets, "--assetIndex", "1.16", "--userProperties", "{}"}, args));
    }

    public static <T> T[] concat(T[] first, T[] second)
    {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
