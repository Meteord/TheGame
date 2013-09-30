package edu.hm.jaumann;

import com.badlogic.gdx.Game;
import edu.hm.jaumann.Config.ObjektXMLmaker;
import edu.hm.jaumann.View.MainMenu;

public class ScreenManager extends Game {
    private MainMenu main;
    @Override
    public void create()
    {
         main = new MainMenu();
    }

    @Override
    public void render() {

    }

    public void setStartScreen()
    {
        setScreen(main);
    }
}
