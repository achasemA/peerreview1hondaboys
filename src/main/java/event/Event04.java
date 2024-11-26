package event;

import main.GameManager;

public class Event04 {

    GameManager gm;

    public Event04(GameManager gm) {

        this.gm = gm;
    }
    public void lookDenzel() {
        gm.ui.messageText.setText("This is Denzel. (He listens to Valorant music)");
    }
    public void talkDenzel() {
        if(gm.player.hasPistol == 0) {
            gm.player.hasPistol = 1;
            gm.ui.messageText.setText("My oh my I've been waiting for you heh. Here's a glock.\nI saw a monster running with an engine towards the casino!");

            gm.player.updatePlayerStatus();
            gm.playSE(gm.reload);
        }
        else{
            gm.ui.messageText.setText("(You already have a glock)");
            gm.playSE(gm.cannotSound);
        }
    }
    public void restDenzel() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("(Denzel has been lonely without his girlfriend)\n*Denzel runs up to you unexpectedly and gives you a hug*\n(Your life has been recovered)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
            gm.playSE(gm.awSound);
        }
        else {
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);
        }
    }
}
