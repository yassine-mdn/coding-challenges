package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;

@Command(name = "jc", mixinStandardHelpOptions = true, version = "jc 1.0",
        description = "counts the number for lines, words, characters ")
public class Jc implements Callable<Result> {
    public static void main(String[] args) {
        var cmd = new CommandLine(new Jc());
        cmd.execute(args);
        Result result = cmd.getExecutionResult();
        if (result != null) {
            System.out.println(result);
        }
    }

    public Jc() {
    }


    @Option(names = {"-c"}, description = "-c for counting bytes")
    private boolean isCountBytes;

    @Option(names = {"-l"}, description = "-l for counting lines")
    private boolean isCountLines;

    @Option(names = {"-w"}, description = "-l for counting words")
    private boolean isCountWords;

    @Option(names = {"-m"} , description = "-m for counting characters")
    private boolean isCountChars;

    @Parameters(index = "0", description = "The file to calculate for.")
    private File file;

    @Override
    public Result call() throws Exception {
        if (!this.file.exists()) {
            throw new FileNotFoundException("File "+this.file.getAbsolutePath()+" does not exist");
        }
        return new Wc(this.file).calculate(this.isCountBytes, this.isCountLines, this.isCountWords, this.isCountChars);
    }
}
