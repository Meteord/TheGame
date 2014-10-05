package edu.hm.jaumann.control;

import edu.hm.jaumann.data.Data;

/**
 * Created by Michael on 23.03.2014.
 */
public class GameDaeomon extends Thread {
    private final Data data;

    public GameDaeomon(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
    }
}
