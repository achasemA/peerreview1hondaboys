package main;

/**
 * this class handles the player logic
 */
// TODO: improve loop readability

public class Player {

    GameManager gm;

    public int playerMaxLife;
    public int playerLife;

    public int hasFlashlight;
    public int hasPistol;
    public int hasAk47;


    public Player(GameManager gm) {

        this.gm = gm;
    }

    public void setPlayerDefaultStatus() {

        playerMaxLife = 5;
        playerLife = 2;
        hasFlashlight = 0;
        hasPistol = 0;
        hasAk47 = 0;

        updatePlayerStatus();
    }
    public void updatePlayerStatus() {

        int i = 0;
        while (i < 5) {
            gm.ui.lifeLabels[i].setVisible(false);
            i++;
        }

        // Set visible only the icons corresponding to playerLife
        int lifeCount = playerLife;
        i = 0; // Reset i to 0 to use for setting life icons
        while (lifeCount > 0 && i < gm.ui.lifeLabels.length) {
            gm.ui.lifeLabels[i].setVisible(true);
            lifeCount--;
            i++;
        }

        // CHECK PLAYER ITEMS
        gm.ui.flashlightLabel.setVisible(hasFlashlight == 1);
        gm.ui.pistolLabel.setVisible(hasPistol == 1);
        gm.ui.ak47Label.setVisible(hasAk47 == 1);
        }
    }
    // TODO: add methods for things like if the player is alive, damage, heal

