package edu.hm.jaumann.data.basic;

import edu.hm.jaumann.data.functionInterface.Applyer;
import edu.hm.jaumann.data.functionInterface.Condition;


public class UnlimitedEffe <T> extends Effe{
    private final int resetTime;

    public UnlimitedEffe(final Applyer doSth, final int time, final Condition<T, UnlimitedEffe> condition) {
        super(doSth, condition, time);
        resetTime = time;
    }

    public void resetTime()
    {
        setTime(resetTime);
    }
}
