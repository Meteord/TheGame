package edu.hm.jaumann;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import edu.hm.jaumann.Config.ObjektXMLmaker;
import edu.hm.jaumann.data.ConfigurationPrototype;
import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.PriecingBundle;
import edu.hm.jaumann.data.basic.Research;
import edu.hm.jaumann.data.functionInterface.ObjektType;

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
       final ConfigurationPrototype test =  new ConfigurationPrototype(10, ObjektType.Unit, 10 ,10 ,10 ,10, DamageTypes.Magic, 100, null, "research") ;
        new ObjektXMLmaker().writePrototype(test);
        new ObjektXMLmaker().writeResearch(new Research(10,test,new String[] {test.getName(),"Hans"},"Improved Magician",new PriecingBundle(100,20,0,0,200)));
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