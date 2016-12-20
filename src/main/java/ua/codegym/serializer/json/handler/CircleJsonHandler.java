package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;

import java.io.IOException;
import java.io.OutputStream;

public class CircleJsonHandler implements Serializer{
    public void serialize(Object shape, OutputStream os) {
        final Circle circle = (Circle) shape;
        try {
            os.write(("{\n\"shape\":\"circle\",\n\"x\":"+circle.getX()+",\n\"y\":"+circle.getY()+",\n\"radius\":"+circle.getRadius()+"\n}").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getType() {
        return Circle.class;
    }
}
