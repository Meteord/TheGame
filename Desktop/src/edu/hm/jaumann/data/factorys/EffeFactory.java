package edu.hm.jaumann.data.factorys;

import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.basic.base.VulnerableObjekt;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.base.effectible;
import edu.hm.jaumann.data.basic.base.livingObjekt;
import edu.hm.jaumann.data.functionInterface.Applyer;

public class EffeFactory {
    private static EffeFactory ourInstance = new EffeFactory();

    public static EffeFactory getInstance() {
        return ourInstance;
    }

    private EffeFactory() {
    }

    /**
     * Gibt einen HeilEffekt zurück.
     * @param healValue
     * @return den HeilEffekt
     */
    public Applyer<livingObjekt> getHealEffe(final int healValue)
    {
        return appied -> appied.heal(healValue);
    }

    /**Richtet Schaden am Ziel an.
     * @param damageAmount Schadenswert
     * @param type Typ des Schadens.
     * @return  den effekt.
     */
    public Applyer<livingObjekt> damager(final int damageAmount, final DamageTypes type)
    {
        return appied -> {
            appied.drainLp(damageAmount);
        };
    }
    public Applyer<effectible>chainEffekt(final Applyer<effectible> firstEffe, final Effe secondChain)
    {
        return appied -> {
                firstEffe.apply(appied);
                appied.equipEffe(secondChain);

        };
    }
}
