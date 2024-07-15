package org.example;



import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;


public class ReadFileTest {
    
    
    @Test
    public void whenFileDoesNotExist_thenThrowFileNotFoundException() {
        FileProcess fileProcess = new FileProcess();
        String path = "src/test/resources/does_not_exist.txt";
        assertThrows(FileNotFoundException.class, () -> fileProcess.readFile(path));
    }
    
    @Test
    public void whenFileExists_thenNoExceptions() {
        FileProcess fileProcess = new FileProcess();
        String path = "test-file.txt";
        assertDoesNotThrow(() -> fileProcess.readFile(path));
    }

   @Test
    public void whenFileExists_thenReturnFile() throws FileNotFoundException {
       FileProcess fileProcess = new FileProcess();
       String path = "test-file.txt";
       File file = fileProcess.readFile(path);
       assertInstanceOf(File.class, file);
   }

}