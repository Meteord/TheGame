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
}
