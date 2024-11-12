package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionHandler implements EventHandler<ActionEvent> {

    GameManager gm;

    public ActionHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void handle(ActionEvent e) {
        String yourChoice = ((javafx.scene.control.Button) e.getSource()).getText();
        handleAction(yourChoice);
    }

    // handles the action commands
    public void handleAction(String yourChoice) {
        switch (yourChoice) {
            // SCENE 1
            case "lookJeramiah":
                gm.ev1.lookJeramiah();
                break;
            case "talkJeramiah":
                gm.ev1.talkJeramiah();
                break;
            case "restJeramiah":
                gm.ev1.restJeramiah();
                break;
            case "lookFlashlight":
                gm.ev1.lookFlashlight();
                break;
            case "grabFlashlight":
                gm.ev1.grabFlashlight();
                break;
            case "restFlashlight":
                gm.ev1.restFlashlight();
                break;

            // SCENE 2
            case "search1Honda":
                gm.ev2.search1Honda();
                break;
            case "search2Honda":
                gm.ev2.search2Honda();
                break;
            case "restHonda":
                gm.ev2.restHonda();
                break;
            case "lookSponge":
                gm.engineStealerMonster.lookSponge();
                break;
            case "talkSponge":
                gm.engineStealerMonster.talkSponge();
                break;
            case "followSponge":
                gm.engineStealerMonster.followSponge();
                break;

            //SCENE 3
            case "lookHondaur":
                gm.hondaur.lookHondaur();
                break;
            case "talkHondaur":
                gm.hondaur.talkHondaur();
                break;
            case "attackHondaur":
                gm.hondaur.attackHondaur();
                break;
            case "lookAnthony":
                gm.hondaur.lookAnthony();
                break;
            case "talkAnthony":
                gm.hondaur.talkAnthony();
                break;
            case "touchAnthony":
                gm.hondaur.touchAnthony();
                break;


            // SCENE CHANGES
            case "goScene1":
                gm.sChanger.showScene1();
                break;
            case "goScene2":
                if(gm.player.hasFlashlight == 1){
                    gm.sChanger.showScene2();
                }
                else {
                    gm.ui.messageText.setText("It's dark outside! You need a flashlight");
                }
                break;
            case "goScene3":
                if(gm.player.hasFlashlight == 1){
                    gm.sChanger.showScene3();
                }
                break;
        }
    }
}
