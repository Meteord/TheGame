package edu.hm.jaumann.data;

import edu.hm.jaumann.data.basic.Timer;
import edu.hm.jaumann.data.basic.Unit;

import java.util.HashMap;
import java.util.Map;

public class Player {
    /**
     * die Ressourcen des Spielers.
     */
    private PriecingBundle resources;
    /**
     * Enthält den Namen der Begonnen erforschung und die Zeit bis  die Erfosrchung verfuegbar ist.
     */
    private Map<String,Timer>researchDone;
    /**
     * Sein König. Mit ihm steigt und sinkt der Stern seines Empires.
     */
    private Unit king;
    /**
     * Alle veränderungen der Prototypen beispielsweise durch Erforschungen für diesen Spieler.
     * Das Erste Element ist immer die globale Veränderung. Sollte ein Gebäude zerstört werden und
     * wieder aufgebaut in dem Bereits erforscht wurde muss im Filter die Erforschung auf erforscht gesetzt werden.
     */
    private final Map<String, ConfigurationPrototype> protoFilter;
    /**
     * Die Staatsform des Spielers. Gibt Raum für individuelle schwächen.
     */
    private final Staatsform stateOfart;

    public Player(final Staatsform stateOfart, final  Unit king, final PriecingBundle resources) {
        protoFilter = new HashMap<>();
        this.stateOfart = stateOfart;
        this.king = king;
        this.resources = resources;
        protoFilter.put("general",new ConfigurationPrototype(0,0,0,0,0, DamageTypes.Magic,0, null));
    }

    public PriecingBundle getResources() {
        return resources;
    }

    public Unit getKing() {
        return king;
    }
    public ConfigurationPrototype getGeneral()
    {
        return protoFilter.get("general");
    }
    public void addProtoFilter(final String name, final ConfigurationPrototype value)
    {
        protoFilter.put(name, value);
    }
    public ConfigurationPrototype getProtoFilter(final String name) {
        return protoFilter.get(name);
    }

    public Staatsform getStateOfart() {
        return stateOfart;
    }
}
