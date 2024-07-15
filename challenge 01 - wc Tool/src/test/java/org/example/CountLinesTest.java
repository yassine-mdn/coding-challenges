package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CountLinesTest {

    private static final long LINE_COUNT = 7145;
    private static final String TEST_FILE_PATH = "src/test/java/org/example/test-file.txt";

    @Test
    public void whenFileDoesNotExist_thenThrowFileNotFoundException() {
        FileProcess fileProcess = new FileProcess();
        String wrongPath = "src/test/resources/does_not_exist.txt";
        File file = new File(wrongPath);
        assertThrows(FileNotFoundException.class, () -> fileProcess.countLines(file));
    }

    @Test
    public void whenFileExists_thenNoExceptions() {
        FileProcess fileProcess = new FileProcess();
        File file = new File(TEST_FILE_PATH);
        assertDoesNotThrow(() -> fileProcess.countLines(file));
    }

   @Test
    public void whenFileExists_thenReturnLineCount() throws IOException {
       FileProcess fileProcess = new FileProcess();
       File file = fileProcess.readFile(TEST_FILE_PATH);
       long count = fileProcess.countLines(file);
       assertEquals(LINE_COUNT, count);

   }
}
