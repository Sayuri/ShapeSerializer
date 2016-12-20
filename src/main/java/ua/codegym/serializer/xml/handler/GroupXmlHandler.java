package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.SerializerFactory;
import ua.codegym.serializer.shape.Group;

import java.io.IOException;
import java.io.OutputStream;

public class GroupXmlHandler implements Serializer{

    public void serialize(Object shape, OutputStream os) {
        Serializer xml = SerializerFactory.newXmlSerializer();
        final Group group = (Group) shape;

        try {
            os.write(("<group>").getBytes());
            group.getShapes().forEach(shape1 -> xml.serialize(shape1, os));
            os.write(("</group>").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getType() {
        return Group.class;
    }
}

