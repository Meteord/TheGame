package edu.hm.jaumann.data.basic.base;

import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.Timer;

/**
 * Created by Michael on 07.02.14.
 */
public class VulnerableObjektPrototype extends VulnerableObjekt {
    private final Effe[] ownEffes;
    private DamageTypes type;
    private PriecingBundle bundle;

    public VulnerableObjektPrototype(int id, boolean visible, int maxLp, int armour, Effe[] ownEffes, DamageTypes type, PriecingBundle bundle, Timer[] timers) {
        super(id, 0, new Vector3(0, 0, 0), visible, maxLp, armour, timers);
        this.ownEffes = ownEffes;
        this.type = type;
        this.bundle = bundle;
    }


    public Effe getOwnEffes(int number) {
        return ownEffes[number];
    }

    public DamageTypes getType() {
        return type;
    }

    public PriecingBundle getBundle() {
        return bundle;
    }

    public VulnerableObjekt getInstance(final int besitzer, final Vector3 loc) {

        return new VulnerableObjekt(getBuildID(), besitzer, loc, isVisible(), getCurrentLp(), getArmour(), getOwnEffesRunTime().clone());
    }
}
