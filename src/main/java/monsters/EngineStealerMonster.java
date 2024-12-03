package monsters;

import javafx.scene.image.ImageView;
import main.GameManager;

public class EngineStealerMonster extends Monster {

    private ImageView blood;

    public EngineStealerMonster(GameManager gm) {
        super(gm,10, 10,"Engine Stealer Monster",3);
    }
    public void addToScene3() {

        gm.ui.createObject(2, 600,250,50,38,"sponge.png",
                "Look","Talk", "Follow", "lookSponge",
                "talkSponge", "followSponge");
    }
    public void addToScene8() {
        gm.ui.createObject(8,200,100,350, 263,"spongeFinalBoss.png",
                "Talk","Attack","Let Live","talkSponge2","attackSponge", "letLiveSponge");
    }

    public void talkSponge2(){
        gm.ui.messageText.setText("So you've finally caught up to me. Put the gun down and I'll give your engine back.");
        gm.playSE(gm.monsterRoar);
    }
    public void attackSponge(){
        if(gm.player.hasAk47 == 1 && gm.player.hasPistol ==0){
            currentLife -= 5;
            gm.player.playerLife -= 2;
            gm.player.updatePlayerStatus();
            gm.ui.messageText.setText("*You shot it with your AK47*.\n (The monster loses 3 lives)");
            gm.playSE(gm.ak47shots);
            gm.playSE(gm.monsterRoar);
        }
        if(gm.player.hasPistol == 1 && gm.player.hasAk47 == 0){
            currentLife -= 2;
            gm.player.playerLife -= 2;
            gm.player.updatePlayerStatus();
            gm.ui.messageText.setText("*You shot it with your pistol*\n (The monster loses 2 lives).");
            gm.playSE(gm.pistolShot);
            gm.playSE(gm.monsterRoar);
        }
        if(gm.player.hasAk47 == 1 && gm.player.hasPistol == 1){
            currentLife -= 5;
            gm.player.playerLife -= 2;
            gm.player.updatePlayerStatus();
            gm.ui.messageText.setText("*You shot it with your AK47*.\n (The monster loses 3 lives)");
            gm.playSE(gm.ak47shots);
            gm.playSE(gm.monsterRoar);
        }
        else {
            currentLife -= 1;
            gm.player.playerLife -= 2;
            gm.player.updatePlayerStatus();
            gm.ui.messageText.setText("*You attack it with your fists*\n (The monster loses 1 life).");
            gm.playSE(gm.monsterRoar);
        }

        if(gm.player.playerLife <=0){
            gm.sChanger.showGameOverScreen(8);
            gm.ui.messageText.setText("You baka! You tested your luck!");
        }
        else{
            gm.ui.messageText.setText("You lost 2 lives! Be careful!");
            gm.playSE(gm.pistolShot);
            gm.playSE(gm.monsterHit);


        }

        if(currentLife == 0){
            if (blood == null) {
                blood = gm.ui.createObjectAndReturn(8, 200, 100, 200, 233, "blood.png", "", "", "", "", "", "");
            }

            // Make them visible
            blood.setVisible(true);
            gm.stopGameTimer();

        }else if (currentLife > 0) {
            // Hide blood while the monster is still alive
            if (blood != null) blood.setVisible(false);
        }
    }
    public void letLiveSponge() {
        gm.playSE(gm.monsterRoar);
    }

    @Override
    public void reset() {
        currentLife = maxLife; // Reset life

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
    public void lookSponge() {
        gm.ui.messageText.setText("An unknown creature is lurking");
    }

    @Override
    public void talkSponge() {
        gm.ui.messageText.setText("(It roars and runs way with what you make out to be your engine)");
        gm.playSE(gm.monsterRoar);
    }

    @Override
    public void followSponge() {
        gm.ui.messageText.setText("(You follow the creature into the woods)");
        gm.sChanger.showScene3();
    }
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
    @Override
    public void lookWheeler() {}
    @Override
    public void talkWheeler() {}
    @Override
    public void attackWheeler() {}

}
