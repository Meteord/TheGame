package edu.hm.jaumann.tests;

import edu.hm.jaumann.data.map.Map;
import edu.hm.jaumann.data.map.Tile;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MapTest {
    private Map map;

    @Before
    public void setUp() throws Exception {
        final Tile[][] testMap = {{Tile.Land, Tile.Land, Tile.Water},
                {Tile.Water, Tile.Water, Tile.Water},
                {Tile.Land, Tile.Water, Tile.Water}};
        map = new Map(testMap);
    }

    @Test
    public void testGetTile() throws Exception {
        Assert.assertTrue(Tile.Land.equals(map.getTile(0, 2)));

    }

    @Test
    public void testGetSubMap() throws Exception {
        final Tile[][] expected = {{Tile.Land, Tile.Water}, {Tile.Water, Tile.Water}};
        Assert.assertTrue(Arrays.deepEquals(expected, map.getSubMap(1, 0, 2, 2)));
    }

    @Test
    public void changeSubMap() throws Exception {
        final Tile[][] expected = {{Tile.Land, Tile.Land}, {Tile.Land, Tile.Land}};
        map.changeSubMap(1, 0, expected);
        Assert.assertTrue(Arrays.deepEquals(expected, map.getSubMap(1, 0, 2, 2)));
    }
}