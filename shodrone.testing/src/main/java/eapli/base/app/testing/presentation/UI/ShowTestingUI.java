package eapli.base.app.testing.presentation.UI;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import rcomp.testingAppUser.TestingAppUser;

import java.io.IOException;

public class ShowTestingUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        String filename = Console.readLine("FileName:");
        int collisionThreshold = Console.readInteger("Collision Threshold:");
        try{
            if(TestingAppUser.testSimulator(filename, collisionThreshold)){
                System.out.println("Show Proposal tested!");
            }else{
                System.out.println("Error while testing Show Proposal!");
                return false;
            }
        }catch (IOException e){
            System.out.println("Error:" + e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Show Testing";
    }
}
