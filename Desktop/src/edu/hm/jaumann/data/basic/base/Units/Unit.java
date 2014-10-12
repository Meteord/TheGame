package edu.hm.jaumann.data.basic.base.Units;

import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.Timer;
import edu.hm.jaumann.data.basic.base.VulnerableObjekt;

import java.util.Collection;

public class Unit extends VulnerableObjekt {
    /**
     * Geschwindkigkeit des Objektes.
     */
    private int speed;
    /**
     * Ziel des Objektes.
     */
    private Vector3 destination;

    private boolean hasDestination;

    public Unit(int id, int besitzer, Vector3 loc, boolean visible, int maxLp, int armour, Collection<Effe> appliedOnMe, Timer[] ownEffesRunTime) {
        super(id, besitzer, loc, visible, maxLp, armour,ownEffesRunTime);
    }


    /**
     *
     * @return Ziel erreicht.
     */
    public boolean move()
    {
        boolean reached= false;
        if(destination!=null)
        {
            final Vector3 between = getLocation().sub(destination);
            reached = between.len()-speed<0;
            addLocation(between.nor().scl(speed));
        }
        return  reached;
    }

    /**
     * Ziel zu dem sich die Einheit bewegt.
     * @param destination
     */
    public void aim(Vector3 destination)
    {
         this.destination = destination;
    }
    public Vector3 getDestination() {
        return destination;
    }
}
