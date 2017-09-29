package ru.artem.other;
import java.io.*;

import static ru.artem.other.ErrorBallTrue.errorFind;

public class Catalog {

    public static void filesWorker(File entry) throws IOException {
        errorFind(entry);
    }

    public static void filesFolder(String folder) throws IOException {
        File file = new File(folder);
        File[] folderEntries = file.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                filesFolder(entry.toString());
                continue;
            } else {
                errorFind(entry);
            }
        }
    }
}
