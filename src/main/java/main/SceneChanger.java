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
        gm.ui.messageText.setText("You are inside your room and you hear a sus sound outside");
    }
    public void showScene2(){

        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(true);
        gm.ui.bgPane[3].setVisible(false);
        gm.ui.messageText.setText("You are outside your house");
    }
    public void showScene3(){
        gm.ui.bgPane[1].setVisible(false);
        gm.ui.bgPane[2].setVisible(false);
        gm.ui.bgPane[3].setVisible(true);
        gm.ui.messageText.setText("The Engine Monster Stealer gets away and you find yourself lost in the woods");
    }

}
