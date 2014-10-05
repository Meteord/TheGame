package edu.hm.jaumann.control;

/**
 * Created by Michael on 23.03.2014.
 */
public abstract class Direction {
     private final DirectionType type;

    public Direction(DirectionType type) {
        this.type = type;
    }
    public abstract void apply();
}
