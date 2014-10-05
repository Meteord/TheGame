package edu.hm.jaumann.data.factorys;

import edu.hm.jaumann.data.basic.CounterEffe;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.UnlimitedEffe;
import edu.hm.jaumann.data.basic.base.livingObjekt;
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
public class ConditionFactory {
    private static ConditionFactory ourInstance = new ConditionFactory();

    public static ConditionFactory getInstance() {
        return ourInstance;
    }

    private ConditionFactory() {
    }

    public Condition<livingObjekt, Effe> getTimeEffe()
    {
        return new Condition<livingObjekt, Effe>() {
            @Override
            public boolean test(final Effe effekt,final livingObjekt aim) {
                final boolean erg =   effekt.getTime() == 0;
                if(erg)
                    effekt.apply(aim);
                return erg;
            }
        };
    }
    public Condition<livingObjekt, UnlimitedEffe> getUlimitedTimeEffe()
    {
        return (effekt, aim) -> {
            if(effekt.getTime() == 0)
            {
                effekt.apply(aim);
                effekt.resetTime();
            }
            return false;
        };
    }
    public Condition<livingObjekt, CounterEffe> getCounterEffeTimedEnd()
    {
        return (effekt, aim) -> {
            if(effekt.getTime() == 0)
            {
                effekt.apply(aim);
                effekt.decreaseCount();
            }
            return effekt.getCount() == 0;
        };
    }
}
