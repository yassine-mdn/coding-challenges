package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


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
        if (!file.exists())
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
        if (!file.exists())
            throw new FileNotFoundException();

        return file.length();
    }


    /**
     * Counts the number of lines in the lines file.
     *
     * @param file the file to count bytes from
     * @return the number of lines in the file
     * @throws FileNotFoundException if the file is null or doesn't exist
     */
    public long countLines(File file) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());

        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        return lines;
    }

    /**
     * Counts the number of words in the given file.
     *
     * @param file the file to count words from
     * @return the number of words in the file
     * @throws FileNotFoundException if the file is null or doesn't exist
     */
    public long countWords(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }

        long words = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // remove empty lines
                if (line.trim().isEmpty())
                    continue;
                String[] lineWords = line.trim().split("\\s+");
                words += lineWords.length;
            }
        }
        return words;
    }

    public long countChars(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }
        byte[] byteArray = Files.readAllBytes(Path.of(file.getAbsolutePath()));
        return byteArray.length;
    }

}
