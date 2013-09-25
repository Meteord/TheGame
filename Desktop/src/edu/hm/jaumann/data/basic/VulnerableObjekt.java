package edu.hm.jaumann.data.basic;



import java.util.Collection;

import java.util.function.Consumer;
import java.util.function.Predicate;

import edu.hm.jaumann.data.ConfigurationPrototype;
import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.functionInterface.ProtoGet;

import javax.security.auth.login.Configuration;

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
    private final ProtoGet<ConfigurationPrototype> protoLink;
    /**
     * Alle Effekte die Tonnenschwer auf diesem Objekt lasten.
     */
    private Collection<Effe> appliedOnMe;

    private final Timer[] ownEffesRunTime;
   

    public VulnerableObjekt(float y, float x, int level, String name,
			Collection<Effe> appliedOnMe) {
	    super(y, x,level, name);
        protoLink = () -> Data.getInstance().getProtos(name);
        currentLp = protoLink.get().getLp();
        armour = protoLink.get().getArmour();
        this.appliedOnMe.addAll(appliedOnMe);
        final int length =protoLink.get().getOwnAbilitys().length;
        ownEffesRunTime = new Timer[length];
        for(int time =0; time <=length;time++)
            ownEffesRunTime[time] = new Timer(protoLink.get().getOwnAbilitys()[time].getTime());
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
     * Aktiviert einen Effekt falls der einsatzbereit ist.
     * @param number
     */
    public void applyEffe(final int number,final VulnerableObjekt destination)
    {
          if(ownEffesRunTime[number].getTime() == 0)
          {
                protoLink.get().getOwnAbilitys()[number].apply(destination);
                ownEffesRunTime[number].resetTime();
          }

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

}