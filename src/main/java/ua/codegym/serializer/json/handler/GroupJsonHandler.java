package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.SerializerFactory;
import ua.codegym.serializer.shape.Group;

import java.io.OutputStream;

public class GroupJsonHandler extends Serializer {

    public void serialize(Object shape, OutputStream os) {
        final Serializer json = SerializerFactory.newJsonSerializer();
        final Group group = (Group) shape;

        safePrint(os, "{\n\"group\":");
        group.getShapes().forEach(shape1 -> json.serialize(shape1, os));
        safePrint(os, "\n}");
    }

    public Class getType() {
        return Group.class;
    }
}
