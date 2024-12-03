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
            //SCENE 4
            case "lookDenzel":
                gm.ev4.lookDenzel();
                break;
            case "talkDenzel":
                gm.ev4.talkDenzel();
                break;
            case "restDenzel":
                gm.ev4.restDenzel();
                break;
            //SCENE 5
            case "lookHondaTrunk":
                gm.ev5.lookHondaTrunk();
                break;
            case "talkHondaTrunk":
                gm.ev5.talkHondaTrunk();
                break;
            case "killHondaTrunk":
                gm.ev5.killHondaTrunk();
                break;
            case "lookTheodoor":
                gm.theodoor.lookTheodoor();
                break;
            case "talkTheodoor":
                gm.theodoor.talkTheodoor();
                break;
            case "attackTheodoor":
                gm.theodoor.attackTheodoor();
                break;
            case "lookWheeler":
                gm.wheeler.lookWheeler();
                break;
            case "talkWheeler":
                gm.wheeler.talkWheeler();
                break;
            case "attackWheeler":
                gm.wheeler.attackWheeler();
                break;
            //SCENE 6
            case "lookBrandon":
                gm.ev6.lookBrandon();
                break;
            case "talkBrandon":
                gm.ev6.talkBrandon();
                break;
            case "restBrandon":
                gm.ev6.restBrandon();
                break;
            case "lookDenzel2":
                gm.ev6.lookDenzel();
                break;
            case "talkDenzel2":
                gm.ev6.talkDenzel();
                break;
            case "playDenzel":
                gm.ev6.playDenzel();
                break;
            //SCENE 7
            case "lookJulian":
                gm.ev7.lookJulian();
                break;
            case "talkJulian":
                gm.ev7.talkJulian();
                break;
            case "holdJulian":
                gm.ev7.holdJulian();
                break;
            case "lookSlotMachine":
                gm.ev7.lookSlotMachine();
                break;
            case "talkSlotMachine":
                gm.ev7.talkSlotMachine();
                break;
            case "spinSlotMachine":
                gm.ev7.spinSlotMachine();
                break;
            case "lookAdrian":
                gm.ev7.lookAdrian();
                break;
            case "talkAdrian":
                gm.ev7.talkAdrian();
                break;
            case "thankAdrian":
                gm.ev7.thankAdrian();
                break;
            case "talkSponge2":
                gm.engineStealerMonster.talkSponge2();
                break;
            case "attackSponge":
                gm.engineStealerMonster.attackSponge();
                break;
            case "letliveSponge":
                gm.engineStealerMonster.letLiveSponge();
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
                    gm.playSE(gm.cannotSound);
                }
                break;
            case "goScene3":
                gm.sChanger.showScene3();
                break;
            case "goScene4":
                if(gm.hondaur.currentLife == 0){
                    gm.sChanger.showScene4();
                }
                else {
                    gm.ui.messageText.setText("You must beat the crap outta the Hondaur to proceed!");
                    gm.playSE(gm.cannotSound);
                }
                break;
            case "goScene5":
                if(gm.player.hasPistol == 1){
                    gm.sChanger.showScene5();
                }
                else {
                    gm.ui.messageText.setText("You should get the glock from Denzel!");
                    gm.playSE(gm.cannotSound);
                }
                break;
            case "goScene6":
                if(gm.theodoor.currentLife == 0 && gm.wheeler.currentLife == 0){
                    gm.sChanger.showScene6();
                }
                else{
                    gm.ui.messageText.setText("You must kill the monsters first!");
                    gm.playSE(gm.cannotSound);
                }
                break;
            case "goScene7":
                gm.sChanger.showScene7();
                break;
            case "goScene8":
                if(gm.ev7.julianLife == 0){
                    gm.sChanger.showScene8();
                }
                else {
                    gm.ui.messageText.setText("You need to spin the slot machine first!");
                }
                break;
            case "goLeaderboard":
                if(gm.engineStealerMonster.currentLife == 0) {
                    gm.sChanger.viewLeaderboard();
                }
                else{
                    gm.ui.messageText.setText("You must kill or let the monster live to proceed!");
                }
                break;
            case "restart":
                gm.sChanger.exitGameOverScreen();
                gm.sChanger.showScene1();
                gm.startGameTimer();
                break;
        }
    }
}
