package edu.hm.jaumann.data.basic;

/**
 * Timer zum gezielten einteilen von Zeitintervallen.
 */
public class Timer{
    /**
     * Die momentane Zeit bis zum ende des Intervalls.
     */
    private int runtime;
    /**
     * Die Laenge eines Intervalles.
     */
    private final int time;

    public Timer(int time) {
        this.time = time;
        runtime = time;
    }

    public int getTime() {

        return runtime;
    }

    /**
     * Verringert die Zeitspanne bis zum Ende des Intervalles.
     * @param timer die Verringerungszeit. Sollte diese Groeser als die Restzeit sein ist das Ende des Intervalles eingetreten.
     */
    public void decreaseTime(final int timer)
    {
         runtime = timer<runtime ? runtime -timer: 0;
    }

    /**
     * Setzt die Zeit zurueck auf volle Intervalllaenge.
     */
    public void resetTime()
    {
        runtime = time;
    }
}
