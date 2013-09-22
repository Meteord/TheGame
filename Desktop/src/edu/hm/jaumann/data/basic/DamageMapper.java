package edu.hm.jaumann.data.basic;



import edu.hm.jaumann.data.DamageTypes;

public class DamageMapper
{

    private final DamageTypes[] position;
    //Enthält konkretes mapping
    private final Double[][] damageMap;

    /**Konstruktor
     *
     * @param values enthält das Konkrete Mapping der Aufbau ist in der form:
     *  1.DAmageType vs: 2 DAmageTye....nten
     *  2.DamageType vs: 3 DamageType....nten
     *  n-1 DAmageType vs. nten DAmageType.
     */
    public DamageMapper(final Double[][] values)
    {
            damageMap = values;
            position = DamageTypes.values();
    }

    /**Gibt dem Index des DamageTypes innerhalb des Position arrays zurück..
     *
     * @param type
     * @return
     */
    private int getIndex(DamageTypes type)
    {
        int indechs = 0;
        for(int index = position.length-1; index >=0; index--)
                 if(type == position[index])
                 {
                     indechs = index;
                     break;
                 }
         return indechs;

    }

    public double calculateDamageDependicies(final DamageTypes attacker, final DamageTypes defender)
    {
        final double result;
        if(attacker == defender)
            result = 1;
        else
        {
            final int attackerIndex = getIndex(attacker);
            final int defenderIndex = getIndex(defender);
            if(attackerIndex < defenderIndex)
                result = damageMap[attackerIndex][defenderIndex-(1+attackerIndex)];
            else
            {
                result =1/( damageMap[defenderIndex][attackerIndex-(1+defenderIndex)]);
            }
        }
        return result;
    }
}