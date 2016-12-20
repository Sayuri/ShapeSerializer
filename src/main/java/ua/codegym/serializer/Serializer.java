package ua.codegym.serializer;

import java.io.IOException;
import java.io.OutputStream;

public abstract class Serializer {
    public abstract void serialize(Object shape, OutputStream os);
    public abstract Class getType();

    protected void safePrint(OutputStream outputStream, String text) {
        try {
            outputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}