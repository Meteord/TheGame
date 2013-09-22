package edu.hm.jaumann;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.hm.jaumann.data.GameMain;

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
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "TheGame";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 480;
        new LwjglApplication(new GameMain(), cfg);
    }
}