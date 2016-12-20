package ua.codegym.serializer;

import ua.codegym.serializer.shape.Shape;
import java.io.OutputStream;

public interface Serializer {
    void serialize(Object shape, OutputStream os);
    Class getType();
}