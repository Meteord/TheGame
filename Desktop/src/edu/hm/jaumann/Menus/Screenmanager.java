package edu.hm.jaumann.Menus;

import com.badlogic.gdx.ApplicationListener;

/**
 * Created by Michael on 06.02.14.
 */
public class Screenmanager implements ApplicationListener {
    private static Screenmanager ourInstance = new Screenmanager();

    public static Screenmanager getInstance() {
        return ourInstance;
    }

    private Screenmanager() {
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
