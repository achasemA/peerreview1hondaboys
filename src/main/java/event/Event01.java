package event;

/**
 * This and all the other event classes handle specific scenes and buttons
 */
//TODO: more javadoc notes to help readability
import main.GameManager;

public class Event01 {

    GameManager gm;

    public Event01(GameManager gm) {
        this.gm = gm;
    }

    public void lookJeramiah() {
        gm.ui.messageText.setText("This is your tall handsome roommate Jeramiah. (He works on cars. Specifically Hondas)");
    }
    public void talkJeramiah() {
        gm.ui.messageText.setText("Did you hear that noise outside son?");
        gm.playSE(gm.engineNoise);
    }
    public void restJeramiah() {

        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("Come here my baka! \n*You lay in Jeramiah's strong arms*\n(Your life has been recovered)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
            gm.playSE(gm.awSound);
        }
        else{
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);

        }

    }
    public void lookFlashlight() {
        gm.ui.messageText.setText("This is a flashlight");
    }
    public void grabFlashlight() {
        if(gm.player.hasFlashlight == 0) {
            gm.player.hasFlashlight = 1;
            gm.ui.messageText.setText("(You obtained a flashlight)");

            gm.player.updatePlayerStatus();
            gm.playSE(gm.flashlightSwitch);
        }
        else{
            gm.ui.messageText.setText("(You already have a flashlight)");
            gm.playSE(gm.cannotSound);
        }

    }
    public void restFlashlight() {
        if(gm.player.hasFlashlight == 1) {
            gm.player.hasFlashlight = 0;
            gm.ui.messageText.setText("*You rest the flashlight back on the bed*");

            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("(You don't have a flashlight)");
            gm.playSE(gm.cannotSound);
        }

    }
}
