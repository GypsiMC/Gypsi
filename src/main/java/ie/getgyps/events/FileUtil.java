package ie.getgyps.events;

import java.io.File;
import java.io.FileFilter;

public class FileUtil {
    public static File[] lsdir(File directoryPath) {
        FileFilter textFilefilter = new FileFilter() {
            public boolean accept(File file) {
                boolean isFile = file.isFile();
                if (isFile) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        //List of all the text files
        File filesList[] = directoryPath.listFiles(textFilefilter);
        return filesList;
    }
    public static File[] lsfile(File directoryPath) {
        FileFilter textFilefilter = new FileFilter() {
            public boolean accept(File file) {
                boolean isFile = file.isFile();
                if (isFile) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        //List of all the text files
        File filesList[] = directoryPath.listFiles(textFilefilter);
        return filesList;
    }
}
