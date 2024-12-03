package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class UITest extends ApplicationTest {

    private UI ui;

    @Override
    public void start(Stage stage) {
        GameManager gm = new GameManager(); // Mock GameManager or use a real one
        ui = new UI(gm);
        ui.createTitleScreen(stage);
    }

    @Test
    void testTitleScreenElements() {

        Scene scene = ui.window.getScene();
        assertNotNull(scene, "Scene should not be null");

        // Check that the Start button exists
        Button startButton = (Button) scene.lookup(".button");
        assertNotNull(startButton, "Start button should be present");
        assertEquals("Start", startButton.getText(), "Button text should be 'Start'");
    }
}