package monsters;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.GameManager;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HondaurTest extends ApplicationTest {

    private GameManager gameManager;
    private Hondaur hondaur;

    @Override
    public void start(Stage stage) {
        // Initialize GameManager and UI
        gameManager = new GameManager();
        gameManager.ui.createMainField(stage);

        // Initialize Hondaur
        hondaur = new Hondaur(gameManager);
    }

    @Test
    public void testLookHondaur_whenAlive() {
        // Set monster's life to a positive value
        hondaur.currentLife = 1;

        hondaur.lookHondaur();

        // Verify the message text
        TextArea messageText = lookup(".text-area").query();
        assertEquals("You see a fearsome weakened Hondaur ready to rev its engine.", messageText.getText());
    }

    @Test
    public void testLookHondaur_whenDead() {
        // Set monster's life to zero
        hondaur.currentLife = 0;

        hondaur.lookHondaur();

        // Verify the message text
        TextArea messageText = lookup(".text-area").query();
        assertEquals("The Hondaur is dead", messageText.getText());
    }
}