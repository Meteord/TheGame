package edu.hm.jaumann.data.basic.base.Interfaces;

import com.badlogic.gdx.graphics.Texture;
import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;

/**
 * Created by Michael on 07.02.14.
 */
public interface informational {
    Texture getPic();

    String getInfo();

    PriecingBundle getKosten();

    int getId();
}
