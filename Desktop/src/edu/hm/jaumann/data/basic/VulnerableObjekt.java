package edu.hm.jaumann.data.basic;



import java.util.Collection;

import java.util.function.Consumer;
import java.util.function.Predicate;

import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.functionInterface.ProtoGet;

public class VulnerableObjekt extends Objekt {

    /**
     * Lebenspunkte des Objektes.
     */
    private int currentLp;
    /**
     * Rüstung des Objektes;
     */
    private int armour;
    /**
     * Verbindung mit dem Prototyp des Objektes, der Alle noetigen Informationen bereitstellt.
     */
    private final ProtoGet protoLink;
    /**
     * Alle Effekte die Tonnenschwer auf diesem Objekt lasten.
     */
    private Collection<Effe> appliedOnMe;

    private final int[] ownEffesRunTime;
   

    public VulnerableObjekt(float y, float x, int level, String name,
			Collection<Effe> appliedOnMe) {
	    super(y, x,level, name);
        protoLink = () -> Data.getInstance().getProtos(name);
        currentLp = protoLink.get().getLp();
        armour = protoLink.get().getArmour();
        this.appliedOnMe.addAll(appliedOnMe);
        final int length =protoLink.get().getOwnAbilitys().length;
        ownEffesRunTime = new int[length];
        for(int time =0; time <=length;time++)
            ownEffesRunTime[time] = protoLink.get().getOwnAbilitys()[time].getTime();
	}

	private boolean setLp(final int value)
    {
        currentLp = value<0 ? 0: value;
        return currentLp == 0;
    }

    public int getCurrentLp() {
        return currentLp;
    }

    public int getArmour() {
        return armour;
    }

    public boolean drainLp(final int value, DamageTypes types)
    {
         return setLp(getCurrentLp()-value);

    }
    public void heal(final int value)
    {
        final int newLp = value + getCurrentLp();
        if(newLp<= protoLink.get().getLp())
             setLp(newLp);
        else
            setLp(protoLink.get().getLp());
    }

    public void equipEffe(final Effe<VulnerableObjekt> effe)
    {
        appliedOnMe.add(effe);
    }

    /**
     *
     * @param number
     */
    public void applyEffe(final int number,final VulnerableObjekt destination)
    {
          protoLink.get().getOwnAbilitys()[number].apply(destination);

    }

    /**
     * Verringert die Zeit aller ausgerüsteten Effetke und wendet diese an.
     * @param decreasedTime
     */
    public void runEffes(final int decreasedTime) {
        appliedOnMe.forEach(new Consumer<Effe>() {
            @Override
            public void accept(Effe effe) {
                   effe.decreaceTime(decreasedTime);
                    System.out.println(effe.getTime());
            }
        }
        );
        final VulnerableObjekt temp = this;
        appliedOnMe.removeIf(new Predicate<Effe>() {
            @Override
            public boolean test(Effe effe) {
               return effe.getCondition().test(effe,temp);
            }
        }) ;
    }

}