package edu.hm.jaumann.data.PlayerStuff;

import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;
import edu.hm.jaumann.data.basic.Timer;
import edu.hm.jaumann.data.basic.base.Units.Unit;

import java.util.Map;

public class Player {

    /**
     * id des Besitzers
     */
    private final int playerID;
    /**
     * die Ressourcen des Spielers.
     */
    private PriecingBundle resources;

    /**
     * Enthält den Namen der Begonnen erforschung und die Zeit bis  die Erfosrchung verfuegbar ist.
     */
    private Map<String, Timer> researchDone;
    /**
     * Sein König. Mit ihm steigt und sinkt der Stern seines Empires.
     */
    private Unit king;

    public Player(int playerID, Unit king) {
        this.playerID = playerID;
        this.king = king;
        resources = new PriecingBundle(200, 0, 0, 0, 0);

    }

    public int getPlayerID() {
        return playerID;
    }

    public PriecingBundle getResources() {
        return resources;
    }

    /**
     * vereinigt die beiden Priecing bundles, will man beispielsweise Ressourcen abziehen müssen
     * negative beträge beim bundle genommen werden
     */
    public void addRessources(final PriecingBundle bundle) {
        resources = resources.combine(bundle);
    }


}
