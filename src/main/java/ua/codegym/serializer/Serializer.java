package ua.codegym.serializer;

import java.io.OutputStream;

public interface Serializer {
    void serialize(Object shape, OutputStream os);
    Class getType();
}