package edu.hm.jaumann.data.MoneyStuff;

/**
 * Created by Michael on 04.10.2014.
 * PiercingBundle mit Zeitinformation
 */
public class TimedPriecingBundle extends PriecingBundle {
    private final int interval;

    public TimedPriecingBundle(final PriecingBundle basebundle, final int interval) {
        super(basebundle.getGold(), basebundle.getWood(), basebundle.getStone(), basebundle.getMana(), basebundle.getFeed());
        this.interval = interval;
    }

    public TimedPriecingBundle(final int money, final int wooden, final int stone, final int mana, final int feed, final int interval) {
        super(money, wooden, stone, mana, feed);
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }

    @Override
    public String toString() {
        return "TimedPriecingBundle{" +
                "interval=" + interval +
                '}';
    }
}
