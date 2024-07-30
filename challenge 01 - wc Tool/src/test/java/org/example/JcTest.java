package org.example;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;


import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class JcTest {

    private static final String TEST_FILE_PATH = "src/test/java/org/example/test-file.txt";

    @Test
    void TestTextFileCountChars() throws URISyntaxException {

        File file = Paths.get(TEST_FILE_PATH).toFile();
        String absolutePath = file.getAbsolutePath();

        String[] args = { "-c", absolutePath };

        var classUnderTest = new Jc();
        var cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        assertEquals(-1, result.getCountLines(), "line count is 0");
        assertEquals(-1, result.getCountWords(), "word count is 0");
        assertEquals(342190, result.getCountBytes(), "byte count is 342190");
    }

    @Test
    void TestTextFileCountLines() throws URISyntaxException {

        File file = Paths.get(TEST_FILE_PATH).toFile();
        String absolutePath = file.getAbsolutePath();

        String[] args = { "-l", absolutePath };

        var classUnderTest = new Jc();
        var cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        assertEquals(7145, result.getCountLines(), "line count is 7145");
        assertEquals(-1, result.getCountWords(), "word count is 0");
        assertEquals(-1, result.getCountBytes(), "byte count is 0");
    }

    @Test
    void TestTextFileCountWords() throws URISyntaxException {

        File file = Paths.get(TEST_FILE_PATH).toFile();

        String absolutePath = file.getAbsolutePath();

        String[] args = { "-w", absolutePath };

        var classUnderTest = new Jc();
        var cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        assertEquals(-1, result.getCountLines(), "line count is 0");
        assertEquals(58164, result.getCountWords(), "word count is 58164");
        assertEquals(-1, result.getCountBytes(), "byte count is 0");
    }


    @Test
    void TestTextFileCountNone() throws URISyntaxException {

        File file = Paths.get(TEST_FILE_PATH).toFile();

        String absolutePath = file.getAbsolutePath();

        String[] args = { absolutePath };

        var classUnderTest = new Jc();
        var cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        assertEquals(7145, result.getCountLines(), "line count is 7145");
        assertEquals(58164, result.getCountWords(), "word count is 58164");
        assertEquals(342190, result.getCountBytes(), "byte count is 342190");
    }

    @Test
    void TestTextFileCountAll() throws URISyntaxException {

        File file = Paths.get(TEST_FILE_PATH).toFile();

        String absolutePath = file.getAbsolutePath();

        String[] args = { "-l", "-w", "-c", absolutePath };

        var classUnderTest = new Jc();
        var cmd = new CommandLine(classUnderTest);
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        assertEquals(7145, result.getCountLines(), "line count is 7145");
        assertEquals(58164, result.getCountWords(), "word count is 58164");
        assertEquals(342190, result.getCountBytes(), "byte count is 342190");
    }
}
