package ie.getgyps.events;

import com.google.common.collect.Lists;
import ie.getgyps.mods.Mod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClientModInitialization {

    private static final List<Mod> mods = Lists.newArrayList();

    public static void addMod(final Mod mod) {
        if(!mods.contains(mod)) {
            mods.add(mod);
        }
    }

    public static File[] availableMods(final File modPath) {
        return modPath.listFiles((dir, filename) -> filename.endsWith(".jar"));
    }

    public static void loadModFromJar(final File file) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {

        final JarFile jarFile = new JarFile(file);

        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = { new URL("jar:file:" + file.getPath() +"!/") };
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }

            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            Class c = cl.loadClass("ie.getgyps."+className);

            try {
                c.getMethods()[0].invoke(null,null);
            } catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            if(c.isAssignableFrom(Mod.class)) {
                addMod((Mod) c.newInstance());
            }
        }
    }

    public static void init() {
        File modPath = new File(System.getProperty("user.dir")+"\\mods");
        modPath.mkdir();

        for(File jarFile : availableMods(modPath)) {
            try {
                loadModFromJar(jarFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Mod getMod(Mod mod) {
        if(mods.contains(mod)) {
            int a = mods.indexOf(mod);
            try {
                return mods.get(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
