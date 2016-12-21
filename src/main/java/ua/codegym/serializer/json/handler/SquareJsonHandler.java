package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Square;

import java.io.OutputStream;

public class SquareJsonHandler extends Serializer{

    public void serialize(Object shape, OutputStream os) {
        final Square square = (Square) shape;
        safePrint(os, "{\n\"shape\":\"square\",\n\"x\":"+square.getX()+",\n\"y\":"+square.getY()+",\n\"side\":"+square.getSide()+"\n}");
    }

    public Class getType() {
        return Square.class;
    }
}
