package edu.hm.jaumann.data;

import java.util.HashMap;
import java.util.Map;


public class Data {
    private static Data ourInstance = new Data();
    private final Map<String, ConfigurationPrototype> protos;
    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        protos = new HashMap<>();
    }


    public ConfigurationPrototype getProtos(final String name) {
        return protos.get(name);
    }
    public void addPrototye(final String name, final ConfigurationPrototype protos)
    {
           this.protos.put(name, protos);
    }
}

