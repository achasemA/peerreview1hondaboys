package event;

import main.GameManager;

public class Event07 {

    GameManager gm;
    public int julianLife = 2;

    public Event07(GameManager gm) {

        this.gm = gm;
    }
    public void lookJulian() {
        gm.ui.messageText.setText("Julian is in serious condition");
        if(julianLife ==0) {
            gm.ui.messageText.setText("You see Julien's lifeless body");
        }
    }
    public void talkJulian() {
        if(julianLife == 2 || julianLife == 1) {
            gm.ui.messageText.setText("*Julian cries when he sees you* I don't want to die...");
        }
        else {
            gm.ui.messageText.setText("Julien is already dead");
            gm.playSE(gm.cannotSound);
        }
    }
    public void holdJulian() {
        if(julianLife == 2) {
            gm.ui.messageText.setText("*You hold Julian's hand and tell him it'll be okay*\nJulian says his last words: Can you spin it one last time for me?");
            julianLife=1;
        }
        if(julianLife == 1) {
            gm.ui.messageText.setText("*You hold Julian's hand and tell him it'll be okay*\nJulian says his last words: Can you spin it one last time for me?");
        }
        else{
            gm.ui.messageText.setText("Julian is already dead");
            gm.playSE(gm.cannotSound);
        }
    }
    public void lookSlotMachine() {
        gm.ui.messageText.setText("You see the slot machine that the Marauder Coded gang made");
    }
    public void talkSlotMachine() {
        gm.ui.messageText.setText("(The slot machine displays your aura: 10,000,000)");
    }
    public void spinSlotMachine() {
        if(julianLife == 1) {
            gm.ui.messageText.setText("*You spin*\n YOU WIN 6 MILLION DOLLARS!!!\n *Julien sighs and passes away*");
            julianLife =0;
            gm.playSE(gm.slotWin);
        }
        else{
            if(julianLife == 2) {
                gm.ui.messageText.setText("You must hold Julian first!");
                gm.playSE(gm.cannotSound);
            }
            if(julianLife < 1) {
                gm.ui.messageText.setText("*You have no more spins left*");
                gm.playSE(gm.cannotSound);
            }
        }

    }
    public void lookAdrian() {
        gm.ui.messageText.setText("You see Adrian, the leader of the Honda Boyz");
    }
    public void talkAdrian() {
        gm.ui.messageText.setText("It was supposed to be an era of peace between the Honda Boyz and Marauder Coded\n *Adrian cries*\n I tried to save him I really did");
    }
    public void thankAdrian() {
        gm.ui.messageText.setText("*You thank Adrian for his great efforts*\n (Adrian will give you 10% of his profits if you avenge Julian)");

    }
}
