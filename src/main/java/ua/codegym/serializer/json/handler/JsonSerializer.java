package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer extends Serializer {
    private static final Map<Class, Serializer> serializers = new HashMap<>();

    static {
        register(new SquareJsonHandler());
        register(new CircleJsonHandler());
        register(new GroupJsonHandler());
    }

    private static void register(Serializer handler) {
        serializers.put(handler.getType(), handler);
    }

    public void serialize(Object shape, OutputStream os) {
        final Serializer handler = serializers.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(shape.getClass()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("We don't support this class"));

        handler.serialize(shape, os);
    }

    public Class getType() {
        throw new IllegalStateException("Don't call me");
    }
}
