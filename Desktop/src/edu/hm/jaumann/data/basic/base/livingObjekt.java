package edu.hm.jaumann.data.basic.base;

/**
 * Created by Michael on 05.02.14.
 */
public interface livingObjekt {
    int getCurrentLp();

    int getArmour();

    boolean drainLp(int value);

    void heal(int value);
}
