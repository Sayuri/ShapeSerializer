package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.SerializerFactory;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class GroupXmlHandler extends Serializer {

    public void serialize(Object shape, OutputStream os) {
        final Serializer xml = SerializerFactory.newXmlSerializer();
        final Group group = (Group) shape;

        safePrint(os,"<group>");
        group.getShapes().forEach(shape1 -> xml.serialize(shape1, os));
        safePrint(os, "</group>");
    }

    public Class getType() {
        return Group.class;
    }
}

