package edu.hm.jaumann;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * /*
 * Autor: Michael
 * Date: 21.09.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public class DesktopMain {
    public static void main(String[] args) {
        ApplicationListener listener = new TheGame();

        // define the window's title
        String title = "TheGame";

        // define the window's size
        final int width = 800, height = 480;

        // whether to use OpenGL ES 2.0
        boolean useOpenGLES2 = false;

        // create the game
        new LwjglApplication( listener, title, width, height, useOpenGLES2 );
    }
}