package ru.spbu.arts.java.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("D:\\dir1");
        FilesCollector fc = new FilesCollector();
        Files.walkFileTree(filePath, fc);
    }
}
