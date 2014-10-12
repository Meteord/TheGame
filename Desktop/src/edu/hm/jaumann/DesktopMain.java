package edu.hm.jaumann;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.math.Vector3;
import edu.hm.jaumann.data.DamageTypes;
import edu.hm.jaumann.data.Data;
import edu.hm.jaumann.data.MoneyStuff.PriecingBundle;
import edu.hm.jaumann.data.basic.Effe;
import edu.hm.jaumann.data.basic.Timer;
import edu.hm.jaumann.data.basic.UnlimitedEffe;
import edu.hm.jaumann.data.basic.base.VulnerableObjekt;
import edu.hm.jaumann.data.basic.base.VulnerableObjektPrototype;
import edu.hm.jaumann.data.factorys.ConditionFactory;
import edu.hm.jaumann.data.factorys.EffeFactory;

public class DesktopMain {
    public static void main(String[] args) {
        final Effe[] effes = new Effe[1];
        effes[0] = new Effe(EffeFactory.getInstance().damager(20, DamageTypes.Fire), ConditionFactory.getInstance().getTimeEffe(), 10);
        final Timer[] timers = new Timer[1];
        timers[0] = new Timer(10);
        final VulnerableObjektPrototype test = new VulnerableObjektPrototype(1, true, 100, 100, effes, DamageTypes.Fire, new PriecingBundle(0, 10, 20, 30, 40), timers);
        Data.getInstance().addPrototye(test);


        final VulnerableObjekt objektone = Data.getInstance().getProtos(1).getInstance(1, new Vector3(0, 0, 0));
        final VulnerableObjekt objekttwo = Data.getInstance().getProtos(1).getInstance(1, new Vector3(0, 0, 0));
        System.out.println(objektone.getCurrentLp());
        objektone.equipEffe(new UnlimitedEffe<>(EffeFactory.getInstance().getHealEffe(20), 10,
                ConditionFactory.getInstance().getUlimitedTimeEffe()));
        objektone.equipEffe(new UnlimitedEffe<>(EffeFactory.getInstance().damager(2, DamageTypes.Fire), 2,
                ConditionFactory.getInstance().getUlimitedTimeEffe()));
        objektone.drainLp(50);
        for (int x = 0; x < 30; x++) {
            objektone.runEffes(1);
            System.out.println(objektone.getCurrentLp());
        }
//        for(int x =0; x<40; x++)
//        {
//
//            if(objekttwo.isReady(0))
//            {
//                System.out.println("Ready to detach and attack :D");
//                Data.getInstance().getProtos(objekttwo.getUnitID()).getOwnEffes(0).apply(objektone);
//                System.out.println("objtetwo get damage" +objektone.getCurrentLp());
//                objektone.getOwnEffesRunTime(0).resetTime();
//            }
//            objektone.runEffes(1);
//            objektone.getOwnEffesRunTime(0).decreaseTime(1);
//            System.out.println("objtektwo is still aalive" + objektone.getCurrentLp());
//            System.out.println(objektone.getOwnEffesRunTime(0).getTime());
//        }
        //   new ObjektXMLmaker().writePrototype(test);
        //  new ObjektXMLmaker().writeResearch(new Research(10,test,new String[] {test.getName(),"Hans"},"Improved Magician",new PriecingBundle(100,20,0,0,200)));
        ApplicationListener listener = new TheGame();
        // define the window's title
        String title = "TheGame";

        // define the window's size
        final int width = 800, height = 480;

        // whether to use OpenGL ES 2.0
        boolean useOpenGLES2 = false;
        System.out.println("hallo");
        // create the gam
        new LwjglApplication(listener, title, width, height, useOpenGLES2);
    }
}