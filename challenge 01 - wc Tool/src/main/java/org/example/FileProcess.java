package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcess {

    /**
     * Reads a file from the given path.
     *
     * @param path the path of the file to read
     * @return the File object representing the file
     * @throws FileNotFoundException if the file does not exist
     */
    public File readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if(!file.exists())
            throw new FileNotFoundException();
        return file;
    }
}
