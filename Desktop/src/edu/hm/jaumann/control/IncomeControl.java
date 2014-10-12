package edu.hm.jaumann.control;

import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;
import edu.hm.jaumann.data.MoneyStuff.TimedPriecingBundle;
import edu.hm.jaumann.data.PlayerStuff.PlayerData;
import edu.hm.jaumann.data.basic.base.Interfaces.Identifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;


/**
 * Created by Michael on 04.10.2014.
 * Thread der die Einnahmen /Ausgaben der Spieler berechnet
 */
public class IncomeControl implements Runnable {
    final int punishment;
    /**
     * Zugriff auf alle Spieler
     */
    private final PlayerData data;
    /**
     * Zugriff auf den Rundentimer
     */
    private final RoundTimer timer;
    /**
     * Enthält alle Einkommen
     */
    private Map<Identifiable, TimedPriecingBundle> moneybag;
    /**
     * Neues Einkommen das unter Der Runde geadded wurde
     */
    private Map<Identifiable, TimedPriecingBundle> newIncome;
    /**
     * Einkommen die Entfernt werden müssen-> Geschieht am Ende der Runde
     */
    private Collection<Identifiable> removeIncome;

    /**
     * @param punishment Legt fest wie schwer Schulden gewichtet werden, Dieser Faktor zinsen wird fällig. z.B. 1 wäre verdoppeln
     * @param moneybag   Einkommen/Ausgaben mit Verursacher ID, Kosten
     * @param data       Zum Zugriff auf die Spielerressourcen
     * @param time       Gesharter Rundentimer
     */
    public IncomeControl(int punishment, Map<Identifiable, TimedPriecingBundle> moneybag, PlayerData data, final RoundTimer time) {
        this.punishment = punishment;
        this.moneybag = moneybag;
        this.data = data;
        timer = time;
        newIncome = new HashMap<>();
        removeIncome = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            if (timer.isIncomeRdy()) {
                moneybag.putAll(newIncome);    //Neues Einkommen hinzufügen
                newIncome.clear();
                computePunishment();
                computeIncome();
                synchronized (timer) {
                    timer.toggleIncomeCtrRdy();   //Dieser Thread ist für diese Runde fertig
                    timer.notify();
                }
                removeIncomes();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }

    }

    /**
     * Fügt neues Einkommen hinzu
     *
     * @param id     Einheit/Gebäude etc das dafür verantwortlich ist
     * @param bundle Einkommen/Ausgaben
     */
    public void addIncome(final Identifiable id, final TimedPriecingBundle bundle) {
        newIncome.put(id, bundle);
    }

    /**
     * Entfernt Einkommen das der ID zugeordnet ist
     *
     * @param id Einkommen das entfernt wird
     */
    public void removeIncome(final Identifiable id) {
        removeIncome.add(id);
    }

    /**
     * Berechnet Einkommmen aller Spieler, basierend auf Einkommen das diese Runde fällig wird
     */
    private void computeIncome() {
        moneybag.entrySet().parallelStream().filter(p -> timer.getRound() % p.getValue().getInterval() == 0)  //Gerade Income Zeit                                              //
                .forEach(p -> data.getPlayer(p.getKey().getPlayerID()).addRessources(p.getValue())); //Spieler Ressourcen zueweisen
    }

    /**
     * Berechnet Bestrafung für negative Ressourcenbeträge für alle Spieler
     */
    private void computePunishment() {
        for (Integer id : data.getPlayersIds()) {
            final PriecingBundle res = data.getPlayer(id).getResources();
            final IntFunction<Integer> punisher = value -> value < 0 ? value * punishment : 0;
            data.getPlayer(id).addRessources(new PriecingBundle(punisher.apply(res.getGold()), punisher.apply(res.getWood()),
                    punisher.apply(res.getStone()), punisher.apply(res.getMana()), punisher.apply(res.getFeed())));
        }
    }

    /**
     * Entfernt alle Einkommen am Ende der Runde
     */
    private void removeIncomes() {
        removeIncome.forEach(moneybag::remove);
        removeIncome.clear();
    }
}
