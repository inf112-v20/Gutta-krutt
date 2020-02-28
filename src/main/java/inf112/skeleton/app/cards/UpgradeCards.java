package inf112.skeleton.app.cards;

import java.util.*;

public class UpgradeCards {
    private static ArrayList<String[]> upgradeCardStack = new ArrayList<>();

    public UpgradeCards(){
        String[] dualProcessor = {"Dual Processor", "Description"};
        String[] tractorBeam = {"Tractor Beam", "Description"};
        String[] conditionalProgram = {"Conditional Program", "Description"};
        String[] miniHowitzer = {"Mini Howitzer", "Description"};

        upgradeCardStack.add(dualProcessor);
        upgradeCardStack.add(tractorBeam);
        upgradeCardStack.add(conditionalProgram);
        upgradeCardStack.add(miniHowitzer);
    }

    public void drawUpgradeCard(){
        Random randomNumber = new Random();
        int chosenCard = randomNumber.nextInt(100) % upgradeCardStack.size();

        switch (chosenCard){
            case 0:
                dualProcessor();
            case 1:
                tractorBeam();
            case 2:
                conditionalProgram();
            case 3:
                miniHowitzer();
            default:
                System.err.printf("Unvalid value");
        }

    }

    private void dualProcessor() {
        System.out.println("Case 0");
    }

    private void tractorBeam() {
        System.out.println("Case 1");
    }

    private void conditionalProgram() {
        System.out.println("Case 2");
    }

    private void miniHowitzer() {
        System.out.println("Case 3");
    }

    private String getDescription(int index){
        return upgradeCardStack.get(index)[1];
    }

    private String getName(int index){
        return upgradeCardStack.get(index)[0];
    }
}