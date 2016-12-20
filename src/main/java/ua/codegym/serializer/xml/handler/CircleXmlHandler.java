package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;

import java.io.IOException;
import java.io.OutputStream;


public class CircleXmlHandler extends Serializer {

    public void serialize(Object shape, OutputStream os) {
        final Circle circle = (Circle) shape;
        safePrint(os, "<circle x=\""+circle.getX()+"\" y=\""+circle.getY()+"\" radius=\""+circle.getRadius()+"\"></circle>");
    }

    public Class getType() {
        return Circle.class;
    }
}
