package edu.hm.jaumann.data.basic;

import com.badlogic.gdx.math.Vector2;

import java.util.Collection;

/**
 * /*
 * Autor: Michael
 * Date: 22.09.13
 * Projektname: $(PROJEKT_NAME)
 * Deskription:
 * Package: $(PACKAGE_NAME)
 * Hochschule München, Fakultät 07 für Mathematik und Informatik
 * Praktikum Softwareentwicklung II,
 * Studiengruppe IF2A java version 1.7.0_07,
 * getestet unter Win7 Home Premium
 * Created with IntelliJ IDEA.
 */
public class Unit extends VulnerableObjekt {
    /**
     * Geschwindkigkeit des Objektes.
     */
    private float speed;
    /**
     * Ziel des Objektes.
     */
    private Vector2 destination;
    public Unit(final float y, final float x, final int level, final String name, final Collection<Effe> appliedOnMe, final float speed) {
        super(y, x, level, name, appliedOnMe);
        this.speed = speed;
    }

}
