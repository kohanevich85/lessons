package lessons.lucene.example_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileOpener {
    private String fileToIndex = "";

    public FileOpener(String fileToIndex) {
        this.fileToIndex = fileToIndex;
    }

    public InputStreamReader getFileForReading(){
        InputStreamReader iStreamReader = null;
        try {
            iStreamReader = new InputStreamReader(new FileInputStream(new File(fileToIndex)), "UTF-8");
        } catch (Exception e){
            System.out.println(" Yo - something went wrong trying to set up the file to read: " +  e.getClass() + " :: " + e.getMessage());
        }
        return iStreamReader;
    }
}
