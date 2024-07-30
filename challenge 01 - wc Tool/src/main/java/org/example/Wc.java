package org.example;

import java.io.File;
import java.io.IOException;

public class Wc {

    private final File file;

    public Wc(File file) {
        this.file = file;
    }

    public Result calculate(boolean isCountBytes, boolean isCountLines, boolean isCountWords, boolean isCountChars) throws IOException {
        Result result = new Result(this.file.getName());
        FileProcess fp = new FileProcess();

        if (!isCountBytes && !isCountLines && !isCountWords && !isCountChars) {
            isCountBytes = true;
            isCountLines = true;
            isCountWords = true;
            isCountChars = true;
        }


        if (isCountBytes)
            result.setCountBytes(fp.countBytes(this.file));
        if (isCountLines)
            result.setCountLines(fp.countLines(this.file));
        if (isCountWords)
            result.setCountWords(fp.countWords(this.file));
        if (isCountChars)
            result.setCountChars(fp.countChars(this.file));
        return result;
    }
}
