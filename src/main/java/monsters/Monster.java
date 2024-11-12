package monsters;

import main.GameManager;

public abstract class Monster {

    protected GameManager gm;
    protected int currentLife;
    protected String monster;
    protected int attackDamage;

    public Monster(GameManager gm,int currentLife, String monster, int attackDamage) {
        this.gm = gm;
        this.currentLife = currentLife;
        this.attackDamage = attackDamage;
        this.monster = monster;
    }

    public abstract void lookHondaur();
    public abstract void talkHondaur();
    public abstract void attackHondaur();
    public abstract void lookSponge();
    public abstract void talkSponge();
    public abstract void followSponge();
    public abstract void lookAnthony();
    public abstract void talkAnthony();
    public abstract void touchAnthony();


}
