package edu.hm.jaumann.data.basic;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

import java.util.Collection;

public class Unit extends VulnerableObjekt {
    /**
     * Geschwindkigkeit des Objektes.
     */
    private float speed;
    /**
     * Ziel des Objektes.
     */
    private Vector2 destination;
    public Unit(final float y, final float x, final int level, final String name, final Collection<Effe> appliedOnMe, final float speed) {
        super(y, x, level, name, appliedOnMe);
        this.speed = speed;
    }

    public void move(final float millis)
    {
        float distance = getLoc().dst(destination);
        Vector2 direction = destination.sub(getLoc());
        direction.nor();
        final float factor = millis *speed;
        if(factor< distance)
            setLoc(getLoc().add(direction.mul(new Matrix3().scale(factor,factor))));
        else
            setLoc(destination);
    }

}
