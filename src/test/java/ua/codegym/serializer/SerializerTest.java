package ua.codegym.serializer;

import org.junit.Test;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class SerializerTest {

  @Test
  public void verifyThatSingleSquareIsWritingCorrectly() {
    // given  
    Shape shape = new Square(1,2,10);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();
    
    // when
    xml.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<square x=\"1\" y=\"2\" side=\"10\"></square>", output);
  }

  @Test
  public void verifyThatGroupedShapeWritingCorrectly() {
    // given
    Group group = new Group();
    group.add(new Square(0,1, 2));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    // when
    xml.serialize(group, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<group><square x=\"0\" y=\"1\" side=\"2\"></square></group>", output);
  }

  @Test
  public void verifyThatSingleSquareIsWritingCorrectlyToJson() {
    // given
    Shape shape = new Square(1,2,10);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\n\"shape\":\"square\",\n\"x\":1,\n\"y\":2,\n\"side\":10\n}", output);
  }

  @Test
  public void verifyThatSingleCircleIsWritingCorrectlyToJson() {
    // given
    Shape shape = new Circle(4,5,20);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\n\"shape\":\"circle\",\n\"x\":4,\n\"y\":5,\n\"radius\":20\n}", output);
  }

  @Test
  public void verifyThatGroupedShapeWritingCorrectlyToJson() {
    // given
    Group group = new Group();
    group.add(new Square(0,1,2));
    Group group1 = new Group();
    group1.add(new Circle(44,55,66));
    group.add(group1);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    // when
    json.serialize(group, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("{\n\"group\":{\n\"shape\":\"square\",\n\"x\":0,\n\"y\":1,\n\"side\":2\n}{\n\"group\":{\n\"shape\":\"circle\",\n\"x\":44,\n\"y\":55,\n\"radius\":66\n}\n}\n}", output);
  }
}
