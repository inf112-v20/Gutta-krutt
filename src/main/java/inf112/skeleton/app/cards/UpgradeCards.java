package inf112.skeleton.app.cards;

import java.lang.reflect.Array;
import java.util.*;

public class UpgradeCards extends Cards {
    static ArrayList<String[]> upgrade = new ArrayList<String[]>();

    static{
        String[] dualProc = {"Dual Processor", "Description"};
        String[] tractorBeam = {"Tractor Beam", "Description"};
        String[] conditionalProgram = {"Conditional Program", "Description"};
        String[] miniHowitzer = {"Mini Howitzer", "Description"};

        upgrade.add(dualProc);
        upgrade.add(tractorBeam);
        upgrade.add(conditionalProgram);
        upgrade.add(miniHowitzer);
    }
}