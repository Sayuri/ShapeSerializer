package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;

import java.io.OutputStream;

public class CircleJsonHandler extends Serializer {
    public void serialize(Object shape, OutputStream os) {
        final Circle circle = (Circle) shape;
        safePrint(os,"{\n\"shape\":\"circle\",\n\"x\":"+circle.getX()+",\n\"y\":"+circle.getY()+",\n\"radius\":"+circle.getRadius()+"\n}");
    }

    public Class getType() {
        return Circle.class;
    }
}
