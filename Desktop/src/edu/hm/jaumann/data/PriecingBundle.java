package edu.hm.jaumann.data;

public class PriecingBundle {
    /**
     * Goldkosten.
     */
    private final int gold;
    /**
     * Holzkosten.
     */
    private final int wood;
    /**
     * Steinkosten.
     */
    private final int stone;
    /**
     * ManaKosten.
     */
    private final int mana;
    /**
     * NahrungsKosten.
     */
    private final int feed;

    public PriecingBundle(final int money, final int wooden, final int stone, final int mana, final int feed) {
        gold = money;
        wood = wooden;
        this.stone = stone;
        this.mana = mana;
        this.feed = feed;
    }

    public int getGold() {
        return gold;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getMana() {
        return mana;
    }

    public int getFeed() {
        return feed;
    }
    public PriecingBundle combine(final PriecingBundle other)
    {
        return new PriecingBundle(this.getGold()+ other.getGold(),
                                  this.getWood()+ other.getWood(),
                                  this.getStone()+ other.getStone(),
                                  this.getMana()+ other.getMana(),
                other.getFeed() + this.getFeed());
    }
}
