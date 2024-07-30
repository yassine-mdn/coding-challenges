package org.example;

public class Result {

    private String fileName;

    private long countBytes;
    private long countLines;
    private long countWords;
    private long countChars;

    public Result() {
        this.countBytes = -1;
        this.countLines = -1;
        this.countWords = -1;
        this.countChars = -1;
    }

    public Result(String fileName) {
        this.fileName = fileName;
        this.countBytes = -1;
        this.countLines = -1;
        this.countWords = -1;
        this.countChars = -1;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        if (countLines >= 0) {
            builder.append("\t").append(this.countLines);
        }
        if (countWords >= 0) {
            builder.append("\t").append(this.countWords);
        }
        if (countChars >= 0) {
            builder.append("\t").append(this.countChars);
        }
        builder.append(" ").append(this.fileName);
        return builder.toString();
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getCountBytes() {
        return countBytes;
    }

    public void setCountBytes(long countBytes) {
        this.countBytes = countBytes;
    }

    public long getCountChars() {
        return countChars;
    }

    public void setCountChars(long countChars) {
        this.countChars = countChars;
    }

    public long getCountLines() {
        return countLines;
    }

    public void setCountLines(long countLines) {
        this.countLines = countLines;
    }

    public long getCountWords() {
        return countWords;
    }

    public void setCountWords(long countWords) {
        this.countWords = countWords;
    }
}