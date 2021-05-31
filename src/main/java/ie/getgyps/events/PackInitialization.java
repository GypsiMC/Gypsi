package ie.getgyps.events;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PackInitialization {
    private static void writeToFile(String filename, String data) {
        try {
            BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename));
            bufwriter.write(data);//writes the edited string buffer to the new file
            bufwriter.close();//closes the file

        } catch (Exception e) {//if an exception occurs
            System.err.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }
    public static void resourcePackBase(String name, String desc, String modid) {
        File rpPathMI = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\models\\item\\");
        File rpPathMB = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\models\\block\\");
        File rpPathBS = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\blockstates\\");
        File rpPathTI = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\textures\\item\\");
        File rpPathTB = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\textures\\block\\");
        File rpPathLa = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\lang\\");
        File rpPathMCM = new File(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\assets\\"+modid+"\\pack.mcmeta");
        if(rpPathMI.mkdirs() && rpPathTI.mkdirs() && rpPathMB.mkdirs() && rpPathBS.mkdirs() && rpPathTB.mkdirs() && rpPathLa.mkdirs()) {
            try {
                if(rpPathMCM.createNewFile()) {
                    writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+name+"\\pack.mcmeta", "{\"pack\":{\"pack_format\":6,\"description\":\""+desc+"\"}}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void resourcePackItemData(List<String> paths, List<String> itemnames, String modid, String packname, String packdesc, boolean generateBase) {
        if(generateBase) {
            resourcePackBase(packname, packdesc, modid);
        }
        for(int i=0; i<paths.size(); i++) {
            writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\models\\item\\"+itemnames.get(i)+".json", "{\"parent\": \"item/generated\",\"textures\": {\"layer0\": \""+modid+":item/"+itemnames.get(i)+"\"}}");
            try {
                new File(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\textures\\item\\"+itemnames.get(i)+".png").createNewFile();
                Files.copy(Paths.get(System.getProperty("user.dir")+"\\mods\\resources\\"+modid+"\\"+paths.get(i)),
                        Paths.get(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\textures\\item\\"+itemnames.get(i)+".png"),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void resourcePackBlockData(List<String> paths, List<String> blocknames, String modid, String packname, String packdesc, boolean generateBase) {
        if(generateBase) {
            resourcePackBase(packname, packdesc, modid);
        }

        for(int i=0; i<paths.size(); i++) {
            writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\models\\item\\"+blocknames.get(i)+".json", "{\"parent\": \""+modid+":block/"+blocknames.get(i)+"\"}");
            writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\models\\block\\"+blocknames.get(i)+".json","{\"parent\": \"block/cube_all\",\"textures\": {\"all\": \""+modid+":block/"+blocknames.get(i)+"\"}}");
            writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\blockstates\\"+blocknames.get(i)+".json", "{\"variants\": {\"\": [{ \"model\": \""+modid+":block/"+blocknames.get(i)+"\"}]}}");
            System.out.println(Paths.get(System.getProperty("user.dir")+"\\mods\\resources\\"+modid+"\\"+paths.get(i)));
            try {
                new File(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\textures\\block\\").mkdirs();
                new File(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\textures\\block\\"+blocknames.get(i)+".png").createNewFile();
                Files.copy(Paths.get(System.getProperty("user.dir")+"\\mods\\resources\\"+modid+"\\"+paths.get(i)),
                        Paths.get(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\textures\\block\\"+blocknames.get(i)+".png"),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public static void resourcePackLanguageData(List<String> types, List<String> givenames, List<String> langnames, String modid, String packname, String packdesc, String lang, boolean generateBase) {
        if(generateBase) {
            resourcePackBase(packname, packdesc, modid);
        }
        String dataString = "{";
        for(int i=0; i<types.size(); i++) {
            if(i==0) {
                dataString+="\""+types.get(i)+"."+modid+"."+givenames.get(i)+"\":\""+langnames.get(i)+"\"";
            } else {
                dataString+=",\""+types.get(i)+"."+modid+"."+givenames.get(i)+"\":\""+langnames.get(i)+"\"";
            }
        }
        dataString+="}";
        writeToFile(System.getProperty("user.dir")+"\\resourcepacks\\"+packname+"\\assets\\"+modid+"\\lang\\"+lang+".json", dataString);
    }
}
