package edu.hm.jaumann.control;

import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.Player;
import edu.hm.jaumann.data.PriecingBundle;
import edu.hm.jaumann.data.TimedPriecingBundle;
import edu.hm.jaumann.data.basic.Timer;
import edu.hm.jaumann.data.basic.base.Identifiable;

import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;


/**
 * Created by Michael on 04.10.2014.
 * Thread der die Einnahmen /Ausgaben der Spieler berechnet
 */
public class IncomeControl implements Runnable {
    final int punishment;
    /**Todo
     * gemeinsam in allen Timer synchronisiert variable / Tick hochzählen
     */
    private Map<Identifiable,TimedPriecingBundle> moneybag;
    private final Data data;
    private final RoundTimer timer;

    /**
     *
     * @param punishment Legt fest wie schwer Schulden gewichtet werden , Default 2
     * @param moneybag Einkommen/Ausgaben mit Verursacher ID, Kosten
     * @param data  Zum Zugriff auf die Spielerressourcen
     * @param time  Gesharter Rundentimer
     */
    public IncomeControl(int punishment, Map<Identifiable, TimedPriecingBundle> moneybag, Data data, final RoundTimer time) {
        this.punishment = punishment;
        this.moneybag = moneybag;
        this.data = data;
        timer = time;
    }

    @Override
    public void run() {

    }
    public void addIncome(final Identifiable id, final TimedPriecingBundle bundle)
    {
        moneybag.put(id, bundle);
    }

    public void removeIncome(final Identifiable id)
    {
        moneybag.remove(id);
    }
    private void computeIncome()
    {
                moneybag.entrySet().parallelStream().filter(p -> timer.getRound() % p.getValue().getInterval() == 0)  //Gerade Income Zeit                                              //
                        .forEach(p -> data.getPlayer(p.getKey().getPlayerID()).addRessources(p.getValue())); //Spieler Ressourcen zueweisen
    }
    private void computePunishment()
    {
        for(int id = 0; id< Player.getPlayerscount(); id++)
        {
            final PriecingBundle res = data.getPlayer(id).getResources();
            final IntFunction<Integer> punisher = new IntFunction<Integer>() {
                @Override
                public Integer apply(int value) {
                    return value<0? value*punishment:0;
                }
            };
            data.getPlayer(id).addRessources(new PriecingBundle(punisher.apply(res.getGold()),punisher.apply(res.getWood()),
                    punisher.apply(res.getStone()),punisher.apply(res.getMana()),punisher.apply(res.getFeed())));
        }
    }
}
