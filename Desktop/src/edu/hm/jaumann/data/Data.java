package edu.hm.jaumann.data;

import edu.hm.jaumann.data.basic.Research;

import java.util.HashMap;
import java.util.Map;


public class Data {
    private static Data ourInstance = new Data();
    private final Map<String, ConfigurationPrototype> protos;
    private final Map<String, Research> researches;
    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        protos = new HashMap<>();
        researches = new HashMap<>();
    }


    public ConfigurationPrototype getProtos(final String name) {
        return protos.get(name);
    }
    public void addPrototye(final String name, final ConfigurationPrototype protos)
    {
           this.protos.put(name, protos);
    }
    public Research getResearch(final String name) {
        return researches.get(name);
    }
    public void addResearch(final String name, final Research research)
    {
        researches.put(name, research);
    }

}

