package event;

import main.GameManager;

public class Event03 {

    GameManager gm;

    public Event03(GameManager gm) {

        this.gm = gm;
    }
    public void lookHondaur() {
        gm.ui.messageText.setText("Its a Hondaur");
    }
    public void talkHondaur() { //change text
        gm.ui.messageText.setText("The Hondaur growls at you and revs his engine ");
    }
    public void attackHondaur() { //change text
        gm.ui.messageText.setText("*You start beating the shit out of the poor Hondaur*");
        //LMAO
    }


}
