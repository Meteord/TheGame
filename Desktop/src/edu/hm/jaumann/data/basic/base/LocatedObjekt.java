package edu.hm.jaumann.data.basic.base;

import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.functionInterface.Positionable;

/**
 * Created by Michael on 05.02.14.
 */
public class LocatedObjekt extends Objekt implements Positionable{
    private Vector3 location;
    private boolean visible;

    public LocatedObjekt(final int buildID, final int playerID , Vector3 location, boolean visible) {
        super(buildID,playerID);
        this.location = location;
        this.visible = visible;
    }
    public void addLocation(Vector3 adder)
    {
        location.add(adder);
    }
    @Override
    public Vector3 getLocation() {
        return location;
    }
    @Override

    public boolean isVisible() {
        return visible;
    }
}
