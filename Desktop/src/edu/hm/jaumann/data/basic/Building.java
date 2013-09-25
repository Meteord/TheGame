package edu.hm.jaumann.data.basic;

import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.functionInterface.ProtoGet;

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
    private final Research[] allGivenResearches;
    public Building(float y, float x, int level, String name, Collection<Effe> appliedOnMe, final String[] researches) {
        super(y, x, level, name, appliedOnMe);
        allGivenResearches = new Research[researches.length];
        for(int index = 0; index < researches.length; index++)
            allGivenResearches[index] = Data.getInstance().getResearch(researches[index]);
    }

}
