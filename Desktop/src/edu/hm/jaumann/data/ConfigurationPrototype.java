package edu.hm.jaumann.data;


import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.VulnerableObjekt;

public class ConfigurationPrototype {

    private final int speed;

    private final int level;

    private final int lp;

    private final int attack;

    private final int range;

    private final int armour;

    private final DamageTypes type;

    private final Effe<VulnerableObjekt>[] ownAbilitys;

    public ConfigurationPrototype(final int speed, final int level, final int attack, final int range,
                                  final int armour, final DamageTypes type, final int livepoints, final Effe<VulnerableObjekt>[] abilities) {
        this.speed = speed;
        this.level = level;
        this.attack = attack;
        this.range = range;
        this.armour = armour;
        this.type = type;
        lp = livepoints;
        ownAbilitys = abilities;
    }



    public int getSpeed() {
        return speed;
    }

    public int getAttack() {
        return attack;
    }

    public int getRange() {
        return range;
    }

    public int getArmour() {
        return armour;
    }

    public DamageTypes getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getLp() {
        return lp;
    }

    public Effe<VulnerableObjekt>[] getOwnAbilitys() {
        return ownAbilitys;
    }

    public ConfigurationPrototype comibne(final ConfigurationPrototype other, final int level, final DamageTypes type)
    {
        final int combindedlength = this.getOwnAbilitys().length+other.getOwnAbilitys().length-1;
        final Effe<VulnerableObjekt>[] abilitesCombined = new Effe[combindedlength];
        for( int index = getOwnAbilitys().length-1; index>= 0; index--)
             abilitesCombined[index]= getOwnAbilitys()[index];

        for( int index = combindedlength; index>= getOwnAbilitys().length-1; index--)
            abilitesCombined[index]= other.getOwnAbilitys()[index];
        return new ConfigurationPrototype(this.getSpeed()+other.getSpeed(),level,this.getAttack()+other.getAttack(),
                                          this.getRange()+other.getRange(), this.getArmour()+other.getArmour(),type,
                                           this.getLp()+other.getLp(),abilitesCombined);
    }
}
