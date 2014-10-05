package edu.hm.jaumann.data.basic.base;

import edu.hm.jaumann.data.basic.Effe;

/**
 * Created by Michael on 05.02.14.
 */
public interface effectible {
    void equipEffe(Effe<livingObjekt> effe);

    boolean isReady(int number);

    void runEffes(int decreasedTime);
}
