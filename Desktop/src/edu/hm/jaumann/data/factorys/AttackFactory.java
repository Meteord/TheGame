package edu.hm.jaumann.data.factorys;

import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.basic.VulnerableObjekt;
import edu.hm.jaumann.data.functionInterface.Matcher;



public class AttackFactory {
    private static AttackFactory ourInstance = new AttackFactory();

    public static AttackFactory getInstance() {
        return ourInstance;
    }

    private AttackFactory() {
    }

    /**Gibt den Schaden direkt an den Defensor weiter.
     *
     * @param range  reichweite des Objekts.
     * @param damage  Schaden des Objekts.
     * @param type  Schadenstyp des Objekts.
     * @return gibt die LambdaAttackfunk tion zurück.
     */
    private Matcher<VulnerableObjekt> getStandartAttack(final int range, final int damage, final DamageTypes type)
    {
           return new Matcher<VulnerableObjekt>() {
               @Override
               public void match(final VulnerableObjekt agressor, final  VulnerableObjekt defensor) {
                    if (agressor.getLoc().epsilonEquals(defensor.getLoc(),range)  )
                    {
                       defensor.drainLp(damage, type);
                    }
                }
           };
    }
    /**Reflektier den Schaden.
     *
     * @param range  reichweite des Objekts.
     * @param damage  Schaden des Objekts.
     * @param type  Schadenstyp des Objekts.
     * @return gibt die LambdaAttackfunktion zurück.
     */
    private Matcher<VulnerableObjekt> getMirrorDamage(final int range, final int damage, final DamageTypes type)
    {
        return new Matcher<VulnerableObjekt>() {
            @Override
            public void match(final VulnerableObjekt agressor, final VulnerableObjekt defensor) {
                if (agressor.getLoc().epsilonEquals(defensor.getLoc(),range)  )
                {
                    agressor.drainLp(damage, type);
                }
            }
        };
    }

    /**Verlangsamt das Ziel.
     *
     * @param range  reichweite des Objekts.
     * @param damage  Schaden des Objekts.
     * @param type  Schadenstyp des Objekts.
     * @return gibt die LambdaAttackfunktion zurück.
     */
   /* private Matcher<VulnerableObjekt> getSlowDownDamage(final int range, final int damage, final DamageTypes type)
    {
        return new Matcher<Unit>() {
            @Override
            public void match(final Unit agressor, final Unit defensor) {
                if (agressor.getDistance(defensor) <= range)
                {
                    defensor.drainLp(damage, type);
                    //Todo ziel verlangsamen, dazu vllt allgemein geschwindikeit und schaden einführen.
                }
            }
        };
    }*/

    private Matcher<VulnerableObjekt> combineMatchers(final Matcher<VulnerableObjekt> one, final Matcher<VulnerableObjekt>two)
    {
        return(aggressor,defensor)-> {
                one.match(aggressor,defensor);
                two.match(aggressor,defensor);
        };
    }




}
