package edu.hm.jaumann.data.basic.base;

public class Objekt implements Identifiable {

    /**
     * Eindeutige ID die das BasisObjekt definiert.
     */
    private final int buildID;
    /**
     * Eindeutige ID die den Besitzer definiert.
     */
    private final int playerID;


    public Objekt( int buildID, int playerID) {
        this.buildID = buildID;
        this.playerID = playerID;
    }
    @Override
    public int getBuildID() {
        return buildID;
    }


    @Override
    public int getPlayerID() {
        return playerID;
    }

}
