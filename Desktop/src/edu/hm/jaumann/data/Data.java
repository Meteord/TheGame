package edu.hm.jaumann.data;

import edu.hm.jaumann.data.basic.base.VulnerableObjektPrototype;

import java.util.HashMap;
import java.util.Map;


public class Data {
    private static Data ourInstance = new Data();
    private final Map<Integer,VulnerableObjektPrototype> protos;
    private final Map<Integer, Player>playerMap;
    public static Data getInstance() {
        return ourInstance;
    }

    private Data() {
        protos = new HashMap<>();
        playerMap = new HashMap<>();
    }


    public VulnerableObjektPrototype getProtos(final Integer id) {
        return protos.get(id);
    }
    public void addPrototye(final VulnerableObjektPrototype protos)
    {
           this.protos.put(protos.getBuildID(), protos);
    }
    public void addPlayer(final Player player)
    {
        playerMap.put(player.getPlayerID(),player);
    }
    public Player getPlayer(final int besitzer)
    {
        return playerMap.get(besitzer);
    }


}

