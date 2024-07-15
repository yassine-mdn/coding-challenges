package org.example;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

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

    /**
     * Counts the number of bytes in the given file.
     *
     * @param file the file to count bytes from
     * @return the number of bytes in the file
     * @throws FileNotFoundException if the file is null or doesn't exist
     */
    public long countBytes(File file) throws FileNotFoundException {
        if (ifFileExists(file))
            throw new FileNotFoundException();

        return file.length();
    }


    public long countLines(File file) throws IOException {
        if (ifFileExists(file))
            throw new FileNotFoundException();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        return lines;
    }

    private boolean ifFileExists(File file) {
        return file == null || !file.exists();
    }
}
