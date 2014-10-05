package edu.hm.jaumann.data.basic.base;

import com.badlogic.gdx.graphics.Texture;
import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.Player;
import edu.hm.jaumann.data.PriecingBundle;

/**
 * Created by Michael on 06.02.14.
 */
public class Infos implements informational {
    private final Texture pic;
    private final String info;
    private final PriecingBundle kosten;
    //Id des Objektes das durch die RunMethode ausgebildet /erforscht wird.
    private final int id;
    public Infos(Texture pic, String info, PriecingBundle kosten, int id) {
        this.pic = pic;
        this.info = info;
        this.kosten = kosten;
        this.id = id;
    }
    //Sollte der Benutzer die
    public void run(final Player player)
    {
        new Thread(() -> {
            Data.getInstance().getProtos(id);
            //Wartezeit holen und dann die Einheit/Forschung dem Spieler adden
        }).start();
    }

    @Override
    public Texture getPic() {
        return pic;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public PriecingBundle getKosten() {
        return kosten;
    }

    @Override
    public int getId() {
        return id;
    }
}
