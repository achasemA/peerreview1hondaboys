package monsters;

import javafx.scene.image.ImageView;
import main.GameManager;

public class Hondaur extends Monster {

    private ImageView anthony; // Reference for anthony
    private ImageView blood;   // Reference for blood

    public Hondaur(GameManager gm) {
        super(gm,4,4, "Hondaur", 1);
    }
    public void addToScene() {

        gm.ui.createObject(3, 300,100,200,283,"Hondaur_2.png",
                "Look","Talk", "Attack", "lookHondaur",
                "talkHondaur", "attackHondaur");
    }

    @Override
    public void lookHondaur() {
        if(currentLife >0) {
            gm.ui.messageText.setText("You see a fearsome weakened " + monster+ " ready to rev its engine.");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText("The "+ monster+ " is dead");
            gm.playSE(gm.cannotSound);
        }
    }
    @Override
    public void talkHondaur() {
        if(currentLife >0) {
            gm.ui.messageText.setText("The "+monster+" growls at you, its engine roaring.");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText("The "+monster+" is already dead");
            gm.playSE(gm.cannotSound);
        }
    }
    @Override
    public void attackHondaur() {

        currentLife--;
        gm.player.playerLife -=1;
        gm.player.updatePlayerStatus();
        gm.ui.messageText.setText("You attack the "+monster+" with your fists! (Its health decreases)");
        if(gm.player.playerLife <=0){
            gm.sChanger.showGameOverScreen(3);
            gm.ui.messageText.setText("You baka! You tested your luck!");
        }
        else{
            gm.ui.messageText.setText("You lost a life! Be careful!");
            gm.playSE(gm.monsterHit);

        }

        if(currentLife == 0){
            if (blood == null) {
                blood = gm.ui.createObjectAndReturn(3, 340, 100, 200, 233, "blood.png", "", "", "", "", "", "");
            }
            if (anthony == null) {
                anthony = gm.ui.createObjectAndReturn(3, 100, 100, 200, 250, "anthony.png",
                        "Look", "Talk", "Touch", "lookAnthony", "talkAnthony", "touchAnthony");
            }

            // Make them visible
            blood.setVisible(true);
            anthony.setVisible(true);

            gm.ui.messageText.setText("The " + monster+ " has been defeated!");
        }else if (currentLife > 0) {
            // Hide anthony and blood while the monster is still alive
            if (anthony != null) anthony.setVisible(false);
            if (blood != null) blood.setVisible(false);
        }
    }

    @Override
    public void reset() {
        currentLife = maxLife; // Reset Hondaur's life

        if (anthony != null) {
            anthony.setVisible(false);
        }
        if (blood != null) {
            blood.setVisible(false);
        }
    }

    @Override
    public void lookAnthony() {
        gm.ui.messageText.setText("A gorgeous short king appears out of no where!");
    }

    @Override
    public void talkAnthony() {
        gm.ui.messageText.setText("Yoooo did you kill THE "+monster+"?? My clan has been hunting it down for years!");
    }
    @Override
    public void touchAnthony() {
        gm.ui.messageText.setText("*You grasp his cheek. He sheds a tear* My boy Denzel should be up ahead!");
    }

    @Override
    public void lookTheodoor() {}
    @Override
    public void talkTheodoor() {}
    @Override
    public void attackTheodoor() {}
    @Override
    public void lookWheeler() {}
    @Override
    public void talkWheeler() {}
    @Override
    public void attackWheeler() {}
    @Override
    public void lookSponge() {}
    @Override
    public void talkSponge() {}
    @Override public void followSponge() {}

}
