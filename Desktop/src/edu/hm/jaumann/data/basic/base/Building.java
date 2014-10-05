package edu.hm.jaumann.data.basic.base;

import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.Timer;

import java.util.Collection;

/**
 * /*
 * Autor: Michael
 * Date: 24.09.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public class Building extends VulnerableObjekt {
    /**
     *  true fallse gebäude aufgebaut ist, false falls nicht.
     */
    private boolean build;

    private informational[] informations;


    public Building(int id, int besitzer, Vector3 loc, boolean visible, int maxLp, int armour, Collection<Effe> appliedOnMe, Timer[] ownEffesRunTime) {
        super(id, besitzer, loc, visible, maxLp, armour, ownEffesRunTime);
    }
}
