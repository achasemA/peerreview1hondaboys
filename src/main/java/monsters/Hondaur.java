package monsters;

import main.GameManager;

public class Hondaur extends Monster {

    public Hondaur(GameManager gm) {
        super(gm,4, "Hondaur", 1);
    }
    public void addToScene() {

        gm.ui.createObject(3, 300,100,200,283,"Hondaur_2.png",
                "Look","Talk", "Attack", "lookHondaur",
                "talkHondaur", "attackHondaur");
    }

    @Override
    public void lookHondaur() {
        gm.ui.messageText.setText("You see a fearsome weakened " + monster+ " ready to rev its engine.");
    }
    @Override
    public void talkHondaur() {
        gm.ui.messageText.setText("The "+monster+" growls at you, its engine roaring.");
    }
    @Override
    public void attackHondaur() {

        currentLife--;
        gm.player.playerLife -=1;
        gm.player.updatePlayerStatus();
        gm.ui.messageText.setText("You attack the "+monster+" with your fists! (Its health decreases)");
        if(gm.player.playerLife <=0){
            gm.sChanger.showGameOverScreen(3);
            gm.ui.messageText.setText("You baka!");
        }
        else{
            gm.ui.messageText.setText("You lost a life! Be careful!");
        }

        if(currentLife == 0){
            gm.ui.createObject(3, 340,100,200,233,"blood.png",
                    "","", "", "",
                    "", "");
            gm.ui.createObject(3, 100,100,200,250,"anthony.png",
                    "Look","Talk", "Touch", "lookAnthony",
                    "talkAnthony", "touchAnthony");

            gm.ui.messageText.setText("The " + monster+ " has been defeated!");
        }
    }

    @Override
    public void lookSponge() {}

    @Override
    public void talkSponge() {}

    @Override public void followSponge() {}

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
}
