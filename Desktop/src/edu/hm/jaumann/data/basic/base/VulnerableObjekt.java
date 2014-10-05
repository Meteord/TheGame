package edu.hm.jaumann.data.basic.base;


import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.Timer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class VulnerableObjekt extends LocatedObjekt implements livingObjekt, effectible {
    /**
     * Maximale Anzahl an Lebenspunkten
     */
    private final int maxLp;
    /**
     * Lebenspunkte des Objektes.
     */
    private int currentLp;
    /**
     * Rüstung des Objektes;
     */
    private int armour;

    /**
     * Alle Effekte die Tonnenschwer auf diesem Objekt lasten.
     */
    private Collection<Effe> appliedOnMe;

    private final Timer[] ownEffesRunTime;


    public VulnerableObjekt(final int id, final int besitzer, final Vector3 loc, boolean visible, int maxLp, int armour,
                             Timer[] ownEffesRunTime) {
	    super(id, besitzer,loc,visible);
        this.maxLp = maxLp;
        currentLp= maxLp;
        this.armour = armour;
        this.ownEffesRunTime=ownEffesRunTime;
        appliedOnMe = new ArrayList<>();
        appliedOnMe.addAll(appliedOnMe);
	}

	private boolean setLp(final int value)
    {
        currentLp = value<0 ? 0: value;
        return currentLp == 0;
    }

    @Override
    public int getCurrentLp() {
        return currentLp;
    }

    @Override
    public int getArmour() {
        return armour;
    }

    @Override
    public boolean drainLp(final int value)
    {
         return setLp(getCurrentLp()-value);

    }
    @Override
    public void heal(final int value)
    {
        final int newLp = value + getCurrentLp();
        if(newLp<= maxLp)
             setLp(newLp);
        else
            setLp(maxLp);
    }

    @Override
    public void equipEffe(final Effe<livingObjekt> effe)
    {
        appliedOnMe.add(effe);
    }

    /**
     * gibt zurück ob der Effekt einsatzbereit ist.
     * @param number
     */
    @Override
    public boolean isReady(final int number)
    {
          return ownEffesRunTime[number].getTime()==0;

    }

    /**
     * Verringert die Zeit aller ausgerüsteten Effetke und wendet diese an.
     * @param decreasedTime
     */
    @Override
    public void runEffes(final int decreasedTime) {
        appliedOnMe.forEach(effe -> {
               effe.decreaceTime(decreasedTime);
                System.out.println(effe.getTime());
        }
        );
        final livingObjekt temp = this;
        appliedOnMe.removeIf(effe -> effe.getCondition().test(effe,temp)) ;
    }

    public Timer getOwnEffesRunTime(final int index) {
        return ownEffesRunTime[index];
    }

    /**
     * Anzahl der eigenen Effekte.
     * @return die Anahl.
     */
    public int getEffeCount()
    {
        return ownEffesRunTime.length;
    }

    public Timer[] getOwnEffesRunTime() {
        return ownEffesRunTime;
    }
}