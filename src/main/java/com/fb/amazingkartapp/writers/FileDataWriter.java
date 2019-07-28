package com.fb.amazingkartapp.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDataWriter implements DataWriter {
    public void write(Object content) {
        writeToJsonFormat(content);
    }

    private void writeToJsonFormat(Object content) {

        try(final OutputStream os = Files.newOutputStream(Paths.get("./output.json"))) {
            //Do something with os
            os.write(((String)content).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
