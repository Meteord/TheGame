package edu.hm.jaumann.data.factorys;

import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.basic.VulnerableObjekt;
import edu.hm.jaumann.data.basic.Effe;
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
    public Applyer<VulnerableObjekt> getHealEffe(final int healValue)
    {
        return new Applyer<VulnerableObjekt>() {
            @Override
            public void apply(VulnerableObjekt appied) {
                appied.heal(healValue);
            }
        };
    }

    /**Richtet Schaden am Ziel an.
     * @param damageAmount Schadenswert
     * @param type Typ des Schadens.
     * @return  den effekt.
     */
    public Applyer<VulnerableObjekt> damager(final int damageAmount, final DamageTypes type)
    {
        return new Applyer<VulnerableObjekt>() {
            @Override
            public void apply(VulnerableObjekt appied) {
                appied.drainLp(damageAmount,type);
            }
        };
    }
    public Applyer<VulnerableObjekt>chainEffekt(final Applyer<VulnerableObjekt> firstEffe, final Effe secondChain)
    {
        return new Applyer<VulnerableObjekt>() {
            @Override
            public void apply(final VulnerableObjekt appied) {
                    firstEffe.apply(appied);
                    appied.equipEffe(secondChain);

            }
        };
    }
}
