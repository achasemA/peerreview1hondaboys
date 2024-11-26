package event;

import main.GameManager;

public class Event05 {

    GameManager gm;

    public Event05(GameManager gm) {

        this.gm = gm;
    }
    public void lookHondaTrunk() {
        if(gm.player.hasPistol == 1){
            gm.ui.messageText.setText("IS THAT BRIAN FROM MARAUDER CODED!");
        }
        else{
            gm.ui.messageText.setText("(You see Brian's dead body)");
        }
    }
    public void talkHondaTrunk() {
        if(gm.theodoor.currentLife==0 && gm.wheeler.currentLife==0) {
            if(gm.player.hasPistol == 1){
                gm.ui.messageText.setText("Eughh Please... save... Julien and please end my misery");
            }
            else{
                gm.ui.messageText.setText("(Brian is already dead!)");
            }
        }
        else{
            gm.ui.messageText.setText("You must defeat the monsters first!");
            gm.playSE(gm.cannotSound);
        }
    }
    public void killHondaTrunk() {

        if(gm.theodoor.currentLife == 0 && gm.wheeler.currentLife == 0) {
            if(gm.player.hasPistol == 1){
                gm.playSE(gm.pistolShot);
                gm.ui.messageText.setText("(You ended Brian's misery)");
            }
            else{
                gm.ui.messageText.setText("(You already ended his misery!)");
            }
            gm.player.hasPistol = 0;
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("You must defeat the monsters first!");
            gm.playSE(gm.cannotSound);
        }

    }
}
