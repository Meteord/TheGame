package edu.hm.jaumann.tests;

import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.control.IncomeControl;
import edu.hm.jaumann.control.RoundTimer;
import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;
import edu.hm.jaumann.data.MoneyStuff.TimedPriecingBundle;
import edu.hm.jaumann.data.PlayerStuff.Player;
import edu.hm.jaumann.data.basic.base.Building.Building;
import edu.hm.jaumann.data.basic.base.Interfaces.Identifiable;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests IncomeControlThread
 */
public class IncomeControlTest {
    private final RoundTimer timer = new RoundTimer(0);
    private final Data data = Data.getInstance();
    private IncomeControl control;
    private Building buildint;
    private Thread controls;

    @org.junit.Before
    public void setUp() throws Exception {

        data.addPlayer(new Player(0, null));
        buildint = new Building(0, 0, new Vector3(0, 0, 0), false, 100, 20, null, null, new TimedPriecingBundle(10, 10, -10, 5, 5, 2));
        final Map<Identifiable, TimedPriecingBundle> map = new HashMap<>();
        control = new IncomeControl(2, map, data, timer);
        controls = new Thread(control);
        controls.start();

    }


    @org.junit.Test
    public void testAddIncome() throws Exception {
        control.addIncome(buildint, buildint.getIncome());
        for (int x = 0; x < 6; x++) {
            nextRnd();

        }
        System.out.println(timer.getRound());
        Assert.assertEquals(new PriecingBundle(230, 30, -910, 15, 15), data.getPlayer(0).getResources());


    }

    private void nextRnd() throws InterruptedException {
        synchronized (timer) {
            timer.increaseRound();
        }
        timer.toggleIncomeCtrRdy();
        controls.interrupt();
        synchronized (timer) {
            timer.wait();
        }
    }

    @org.junit.Test
    public void testRemoveIncome() throws InterruptedException {
        data.addPlayer(new Player(2, null));
        Building build = new Building(1, 2, new Vector3(0, 0, 0), false, 100, 20, null, null, new TimedPriecingBundle(10, 10, -10, 5, 5, 1));
        control.addIncome(build, build.getIncome());
        nextRnd();
        nextRnd();
        control.removeIncome(build);
        nextRnd();
        nextRnd();
        Assert.assertEquals(new PriecingBundle(230, 30, -390, 15, 15), data.getPlayer(2).getResources());
    }
}