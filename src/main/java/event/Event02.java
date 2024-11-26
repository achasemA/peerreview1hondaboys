package event;

import main.GameManager;

public class Event02 {

    GameManager gm;

    public Event02(GameManager gm) {

        this.gm = gm;
    }
    public void search1Honda() {
        gm.ui.messageText.setText("Nothing sus here");
    }
    public void search2Honda() {
        gm.ui.messageText.setText("OH MY GYAT MY ENGINE IS MISSING");
    }
    public void restHonda() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("*You rest on the hood of your car*\n(Your life has been recovered)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
        }
        else{
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);

        }
    }
}
