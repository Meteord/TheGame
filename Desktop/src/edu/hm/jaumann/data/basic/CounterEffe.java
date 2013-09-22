package edu.hm.jaumann.data.basic;

import edu.hm.jaumann.data.functionInterface.Applyer;
import edu.hm.jaumann.data.functionInterface.Condition;

/**
 * /*
 * Autor: Michael
 * Date: 22.09.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public class CounterEffe<T> extends Effe {

    private int count;

    public CounterEffe(final Applyer<T> doSth, final Condition<T, CounterEffe> condition,
                       final  int time, final  int count) {
        super(doSth, condition, time);
        this.count = count;
    }

    public void decreaseCount()
    {
        count--;
    }

    public int getCount() {
        return count;
    }
}
