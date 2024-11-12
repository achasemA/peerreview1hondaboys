package monsters;

import main.GameManager;

public class EngineStealerMonster extends Monster {

    public EngineStealerMonster(GameManager gm) {
        super(gm,4, "EngineStealerMonster",3);
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
    }

    @Override
    public void followSponge() {
        gm.ui.messageText.setText("(You follow the creature into the woods)");
    }

    @Override
    public void lookAnthony() {}

    @Override
    public void talkAnthony() {}

    @Override
    public void touchAnthony() {}
}
