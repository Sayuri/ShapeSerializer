package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.SerializerFactory;
import ua.codegym.serializer.shape.Group;

import java.io.IOException;
import java.io.OutputStream;

public class GroupJsonHandler implements Serializer {

    public void serialize(Object shape, OutputStream os) {
        Serializer json = SerializerFactory.newJsonSerializer();
        final Group group = (Group) shape;

        try {
            os.write(("{\n\"group\":").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        group.getShapes().forEach(shape1 -> json.serialize(shape1, os));

        try {
            os.write(("\n}").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getType() {
        return Group.class;
    }
}
