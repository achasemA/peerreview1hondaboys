package monsters;

import main.GameManager;

public abstract class Monster {

    protected GameManager gm;
    public int currentLife;
    protected int maxLife;
    protected String monster;
    protected int attackDamage;

    public Monster(GameManager gm,int currentLife,int maxLife, String monster, int attackDamage) {
        this.gm = gm;
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.attackDamage = attackDamage;
        this.monster = monster;
    }

    public abstract void reset();
    public abstract void lookHondaur();
    public abstract void talkHondaur();
    public abstract void attackHondaur();
    public abstract void lookSponge();
    public abstract void talkSponge();
    public abstract void followSponge();
    public abstract void lookAnthony();
    public abstract void talkAnthony();
    public abstract void touchAnthony();
    public abstract void lookTheodoor();
    public abstract void talkTheodoor();
    public abstract void attackTheodoor();
    public abstract void lookWheeler();
    public abstract void talkWheeler();
    public abstract void attackWheeler();




}
