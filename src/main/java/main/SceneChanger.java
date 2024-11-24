package main;

public class SceneChanger {

    GameManager gm;

    public SceneChanger(GameManager gm) {

        this.gm = gm;
    }

    public void showScene1(){

        gm.ui.bgPane[1].setVisible(true);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.messageText.setText("You are inside your room and you hear a sus sound outside");
    }
    public void showScene2(){

        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(true);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.messageText.setText("You are outside your house");
    }
    public void showScene3(){
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(true);
        gm.ui.bgPane[4].setVisible(false);
        gm.ui.messageText.setText("The Engine Monster Stealer gets away and you find yourself lost in the woods");
    }
    public void showScene4() {
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.bgPane[4].setVisible(true);
        gm.ui.messageText.setText("You find a tall, dark, and handsome man");
    }
    public void showGameOverScreen(int currentBgNum){

            gm.ui.bgPane[currentBgNum].setVisible(false);
            gm.ui.titleLabel.setVisible(true);
            gm.ui.titleLabel.setText("YOU DIED");
            gm.ui.restartButton.setVisible(true);
            gm.ui.restartButton.setText("Click Here To Restart");
            gm.stopGameTimer();
        }
    public void exitGameOverScreen(){

        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.player.setPlayerDefaultStatus();
    }

}
