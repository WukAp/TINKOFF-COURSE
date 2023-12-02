package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class ArrowsAccess {

    public void getPrintWriter(String path, String text) {
        File file = new File(path);
        try (OutputStream outputStream = new FileOutputStream(file);
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                 bufferedOutputStream,
                 StandardCharsets.UTF_8.newEncoder()
             );
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
