package ua.codegym.serializer.json.handler;


import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class SquareJsonHandler implements Serializer{

    public void serialize(Object shape, OutputStream os) {
        final Square square = (Square) shape;
        try {
            os.write(("{\n\"shape\":\"square\",\n\"x\":"+square.getX()+",\n\"y\":"+square.getY()+",\n\"side\":"+square.getSide()+"\n}").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Class getType() {
        return Square.class;
    }
}
