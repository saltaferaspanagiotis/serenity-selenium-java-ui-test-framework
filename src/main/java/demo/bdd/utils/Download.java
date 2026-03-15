package demo.bdd.utils;

import java.io.File;

public class Download {
    public static File getFileFromLocation(String filePath, String fileName) {
        File dir = new File(filePath);

        for (File file : dir.listFiles()) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }

        return null;
    }
}
