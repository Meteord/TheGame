package edu.hm.jaumann;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;

/**
 * /*
 * Autor: Michael
 * Date: 23.09.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public class TheGame extends ApplicationListener {
    public static final String LOG=   TheGame.class.getSimpleName();
    private FPSLogger fpsLogger;
    private ScreenManager manage;
    @Override
    public void create() {
        Gdx.app.log( TheGame.LOG, "Creating game" );
        fpsLogger = new FPSLogger();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log( TheGame.LOG, "Resizing game to: " + width + " x " + height );

}

    @Override
    public void render() {
        // the following code clears the screen with the given RGB color (green)
        Gdx.gl.glClearColor( 0f, 1f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        // output the current FPS
        fpsLogger.log();
    }

    @Override
    public void pause() {
        Gdx.app.log( TheGame.LOG, "Pausing game" );
    }

    @Override
    public void resume() {
        Gdx.app.log( TheGame.LOG, "Resuming game" );
    }

    @Override
    public void dispose() {
        Gdx.app.log( TheGame.LOG, "Disposing game" );
    }
}
