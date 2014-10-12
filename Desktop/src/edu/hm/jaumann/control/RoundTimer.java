package edu.hm.jaumann.control;

/**
 * Created by Michael on 04.10.2014.
 */
public class RoundTimer {
    private int round;
    private boolean incomeRdy = false;

    public RoundTimer(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void increaseRound() {
        round++;
    }

    public boolean isIncomeRdy() {
        return incomeRdy;
    }

    public void toggleIncomeCtrRdy() {
        incomeRdy = !incomeRdy;
    }
}
