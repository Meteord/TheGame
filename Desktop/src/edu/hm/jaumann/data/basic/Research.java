package edu.hm.jaumann.data.basic;

import edu.hm.jaumann.data.ConfigurationPrototype;
import edu.hm.jaumann.data.PriecingBundle;

import java.util.Map;

public class Research {
    /**
     * Erforschungszeit.
     */
    private final int researchTime;
    /**
     * Nutzen der Erforschung.
     */
    private final ConfigurationPrototype protos;
    /**
     * Name des Zielobjekts der Erforschung.
     */
    private final String destination;
    /**
     * Name der Erforschung.
     */
    private final String name;
    /**
     * Kosten der Erforschung.
     */
    private final PriecingBundle prize;

    public Research(int researchTime, ConfigurationPrototype protos, String destination, String name, PriecingBundle prize) {
        this.researchTime = researchTime;
        this.protos = protos;
        this.destination = destination;
        this.name = name;
        this.prize = prize;
    }

    public ConfigurationPrototype getProtos() {
        return protos;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public int getResearchTime() {

        return researchTime;
    }

    public PriecingBundle getPrize() {
        return prize;
    }
}
