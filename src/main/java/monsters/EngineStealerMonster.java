package monsters;

import main.GameManager;

public class EngineStealerMonster extends Monster {

    public EngineStealerMonster(GameManager gm) {
        super(gm,4, 4,"EngineStealerMonster",3);
    }
    public void addToScene() {

        gm.ui.createObject(2, 600,250,50,38,"sponge.png",
                "Look","Talk", "Follow", "lookSponge",
                "talkSponge", "followSponge");
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
    @Override
    public void reset() {}
}
