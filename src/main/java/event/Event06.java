package event;

import javafx.scene.image.ImageView;
import main.GameManager;

public class Event06 {
    GameManager gm;
    private ImageView denzel;

    public Event06(GameManager gm) {

        this.gm = gm;
    }
    public void reset(){
        if (denzel != null) {
            denzel.setVisible(false);
        }
    }

    public void lookDenzel(){
        gm.ui.messageText.setText("Denzel shows up");
    }
    public void talkDenzel(){
        gm.ui.messageText.setText("I got worried for you so I ran after you");

    }
    public void playDenzel(){

        if(gm.player.hasAk47 == 0) {
            gm.player.hasAk47 = 1;
            gm.ui.messageText.setText("*You cheer Denzel up by playing Valorant music*\nYou realy know how to cheer me up!\n *Denzel gives you an ak47*");

            gm.player.updatePlayerStatus();
            gm.playSE(gm.reload);
        }
        else{
            gm.ui.messageText.setText("(You already have an ak47)");
            gm.playSE(gm.cannotSound);
        }

    }

    public void lookBrandon() {
        gm.ui.messageText.setText("This is Brandon. He seems to be doing a fit check");
    }
    public void talkBrandon() {
        gm.ui.messageText.setText("Yo I wouldn't go in there if I were you! A monster is on the loose!");
    }
    public void restBrandon() {
        if(gm.player.playerLife != gm.player.playerMaxLife) {
            gm.ui.messageText.setText("You look injured... Come here\n*Brandon gives you a warm hug*\n(You gain life)");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
            gm.playSE(gm.heal);
            gm.playSE(gm.awSound);
        }
        else {
            gm.ui.messageText.setText("(Your life is full)");
            gm.playSE(gm.cannotSound);
            if (denzel == null){
                denzel = gm.ui.createObjectAndReturn(6, 450, 110, 200, 250, "denzel.png",
                        "Look", "Talk", "Play", "lookDenzel2", "talkDenzel2", "playDenzel");
                denzel.setVisible(true);
            }
            else {
                denzel.setVisible(false);
            }


        }

    }
}
