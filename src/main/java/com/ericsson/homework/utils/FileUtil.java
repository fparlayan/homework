package com.ericsson.homework.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class FileUtil {

    public static String readFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        return IOUtils.toString(fis, StandardCharsets.UTF_8);
    }

    public static void writeFile(String filePath, String data) throws IOException {
        PrintWriter writer = new PrintWriter(filePath);
        writer.write(data);
        writer.close();
    }
}
