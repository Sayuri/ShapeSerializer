package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class SquareXmlHandler extends Serializer {


    public void serialize(Object shape, OutputStream os) {
        final Square square = (Square) shape;
        safePrint(os, "<square x=\""+square.getX()+"\" y=\""+square.getY()+"\" side=\""+square.getSide()+"\"></square>");
    }

    public Class getType() {
        return Square.class;
    }
}