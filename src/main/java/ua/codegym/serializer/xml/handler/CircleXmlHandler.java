package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;

import java.io.IOException;
import java.io.OutputStream;


public class CircleXmlHandler implements Serializer {

    public void serialize(Object shape, OutputStream os) {
        final Circle circle = (Circle) shape;
        try {
            os.write(("<circle x=\""+circle.getX()+"\" y=\""+circle.getY()+"\" radius=\""+circle.getRadius()+"\"></circle>").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getType() {
        return Circle.class;
    }
}
