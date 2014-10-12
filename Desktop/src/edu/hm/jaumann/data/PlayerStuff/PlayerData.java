package edu.hm.jaumann.data.PlayerStuff;

import java.util.Set;

/**
 * Created by Michael on 12.10.2014.
 */
public interface PlayerData {
    Player getPlayer(int besitzer);

    public Set<Integer> getPlayersIds();
}
