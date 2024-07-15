package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CountBytesTest {

    private static final long BYTE_COUNT = 342190;
    private static final String TEST_FILE_PATH = "src/test/java/org/example/test-file.txt";

    @Test
    void whenFileDoesNotExist_thenThrowFileNotFoundException() {
        FileProcess fileProcess = new FileProcess();
        String wrongPath = "src/test/resources/does_not_exist.txt";
        File file = new File(wrongPath);
        assertThrows(FileNotFoundException.class, () -> fileProcess.countBytes(file));
    }

    @Test
    void whenFileExists_thenReturnByteCount() throws FileNotFoundException {
        FileProcess fileProcess = new FileProcess();
        File file = new File(TEST_FILE_PATH);
        long count = fileProcess.countBytes(file);
        assertEquals(BYTE_COUNT, count);
    }

}