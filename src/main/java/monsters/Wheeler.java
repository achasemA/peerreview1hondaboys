package monsters;

import javafx.scene.image.ImageView;
import main.GameManager;

public class Wheeler extends Monster {

    private ImageView blood;   // Reference for blood

    public Wheeler(GameManager gm) {
        super(gm,4,4, "Wheeler", 2);
    }
    public void addToScene() {

        gm.ui.createObject(5, 50,95,200,283,"wheel.png",
                "Look","Talk", "Attack", "lookWheeler",
                "talkWheeler", "attackWheeler");
    }

    @Override
    public void lookWheeler() {
        if(currentLife >0) {
            gm.ui.messageText.setText("You see the " + monster+ " ready to run you over.");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText(monster+ " is dead");
            gm.playSE(gm.cannotSound);
        }
    }

    @Override
    public void talkWheeler() {
        if(currentLife >0) {
            gm.ui.messageText.setText(monster+" roars at you! (He is scared of the glock).");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText(monster+" is already dead");
            gm.playSE(gm.cannotSound);
        }
    }

    @Override
    public void attackWheeler() {
        currentLife-=2;
        gm.player.playerLife -=1;
        gm.player.updatePlayerStatus();
        gm.ui.messageText.setText("You shoot "+monster+" with your glock! (Its health decreases by 2)");
        if(gm.player.playerLife <=0){
            gm.sChanger.showGameOverScreen(5);
            gm.ui.messageText.setText("You baka! You tested your luck!");
        }
        else{
            gm.ui.messageText.setText("You lost a life! Be careful!");
            gm.playSE(gm.pistolShot);
            gm.playSE(gm.monsterHit);


        }

        if(currentLife == 0){
            if (blood == null) {
                blood = gm.ui.createObjectAndReturn(5, 50, 95, 200, 233, "blood.png", "", "", "", "", "", "");
            }

            // Make them visible
            blood.setVisible(true);

            gm.ui.messageText.setText( monster+ " has been defeated!");
        }else if (currentLife > 0) {
            // Hide blood while the monster is still alive
            if (blood != null) blood.setVisible(false);
        }
    }
    @Override
    public void reset() {
        currentLife = maxLife; // Reset Wheeler's life

        if (blood != null) {
            blood.setVisible(false);
        }
    }

    @Override
    public void lookHondaur() {}
    @Override
    public void talkHondaur() {}
    @Override
    public void attackHondaur() {}
    @Override
    public void lookSponge() {}
    @Override
    public void talkSponge() {}
    @Override
    public void followSponge() {}
    @Override
    public void lookAnthony() {}
    @Override
    public void talkAnthony() {}
    @Override
    public void touchAnthony() {}
    @Override
    public void lookTheodoor() {}
    @Override
    public void talkTheodoor() {}
    @Override
    public void attackTheodoor() {}
}
