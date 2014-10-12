package edu.hm.jaumann.data.map;

import java.util.Arrays;

/**
 * Created by Michael on 22.04.2014.
 */
public class Map {
    /**
     * Map in Tileform
     */
    private Tile[][] map;

    /**
     * Fertig initialisierte map
     *
     * @param map die Karte
     */
    public Map(Tile[][] map) {
        this.map = map;
    }

    /**
     * Map mit Dimensionen initialisiert
     *
     * @param x weite
     * @param y höhe
     */
    public Map(final int x, final int y) {
        map = new Tile[y][x];
    }

    /**
     * gibt ein Feld zurück
     *
     * @param x an der koordinate x
     * @param y an der Koordinate y
     * @return
     */
    public Tile getTile(final int x, final int y) {
        return map[y][x];
    }

    /**
     * gibt einen Ausschnitt der Karte zurück
     *
     * @param x      beginnt bei dieser Position x
     * @param y      -y
     * @param deltax mit der Ausdehnung in X-Dimension
     * @param deltay Y-Dimension
     * @return
     */
    public Tile[][] getSubMap(final int x, final int y, final int deltax, final int deltay) {
        Tile[][] sub = new Tile[deltax][deltay];
        for (int j = 0; j < deltay; j++) {
            sub[j] = Arrays.copyOfRange(map[y + j], x, x + deltax);
        }
        return sub;
    }

    public void changeTile(final int x, final int y, final Tile tile) {
        map[y][x] = tile;
    }

    public void changeSubMap(final int x, final int y, final Tile[][] submap) {
        final int deltay = submap.length;
        final int deltax = submap[0].length;
        for (int j = 0; j < deltay; j++) {
            for (int i = 0; i < deltax; i++)
                changeTile(x + i, y + j, submap[j][i]);
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "map=" + Arrays.toString(map) +
                '}';
    }

    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }
}
