package edu.hm.jaumann.data.basic;


import edu.hm.jaumann.data.functionInterface.Applyer;
import edu.hm.jaumann.data.functionInterface.Condition;



public class Effe<T> {
    /**
     * Effekt der auf Das Ziel gewirkrt wird, wenn die Zeit Abgelaufen ist.
     */
    private final Applyer<T>doSth;
    /**
     *
     */
    private final Condition<T,Effe> condition;
    /**
     * Zeit die der Effe noch zu Wirken hat.
     */
    private int time;

    public Effe(final Applyer<T> doSth, Condition<T, Effe> condition, final int time) {
        this.doSth = doSth;
        this.condition = condition;
        this.time = time;
    }

    void setTime(int time) {
        this.time = time;
    }

    /** Verringert die Zeit bis der Effe wieder Aktiviert werden kann.
     *
     * @param value
     * @return
     */
    public boolean decreaceTime(final int value)
    {

        time -= value;
        if(time < 0)
            time = 0;
        return time == 0;
    }
    public void apply(T aim){
       doSth.apply(aim);
    }

    public int getTime() {
        return time;
    }

    /**
     * Gibt die Bedingung zurück. Sollte der Effekt einsatzbereit sein wird er aktiviert .
     * @return   die Bedingung
     */
    public Condition<T, Effe> getCondition() {
        return condition;
    }
}
