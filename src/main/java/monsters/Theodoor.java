package monsters;

import javafx.scene.image.ImageView;
import main.GameManager;

public class Theodoor extends Monster {

    private ImageView blood;   // Reference for blood

    public Theodoor(GameManager gm) {
        super(gm,4,4, "Theodoor", 2);
    }
    public void addToScene() {

        gm.ui.createObject(5, 450,95,200,283,"theodoor.png",
                "Look","Talk", "Attack", "lookTheodoor",
                "talkTheodoor", "attackTheodoor");
    }

    @Override
    public void lookTheodoor() {
        if(currentLife >0) {
            gm.ui.messageText.setText("You see " + monster+ " the door ready to feast on your adorable body.");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText(monster+ " the door is dead");
            gm.playSE(gm.cannotSound);
        }
    }

    @Override
    public void talkTheodoor() {
        if(currentLife >0) {
            gm.ui.messageText.setText(monster+" the door roars at you, its hinges creaking.");
            gm.playSE(gm.monsterRoar);
        }
        else {
            gm.ui.messageText.setText(monster+" the door is already dead");
            gm.playSE(gm.cannotSound);
        }
    }

    @Override
    public void attackTheodoor() {
        currentLife-=2;
        gm.player.playerLife -=1;
        gm.player.updatePlayerStatus();
        gm.ui.messageText.setText("You shoot "+monster+" the door with your glock! (Its health decreases by 2)");
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
                blood = gm.ui.createObjectAndReturn(5, 450, 95, 200, 233, "blood.png", "", "", "", "", "", "");
            }

            // Make them visible
            blood.setVisible(true);

            gm.ui.messageText.setText( monster+ " the door has been defeated!");
        }else if (currentLife > 0) {
            // Hide blood while the monster is still alive
            if (blood != null) blood.setVisible(false);
        }
    }

    @Override
    public void reset() {
        currentLife = maxLife; // Reset Theodoor's life

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
    public void lookWheeler() {}
    @Override
    public void talkWheeler() {}
    @Override
    public void attackWheeler() {}
}
