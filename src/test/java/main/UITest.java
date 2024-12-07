package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;


public class UITest extends ApplicationTest {

    private UI ui;

    @Override
    public void start(Stage stage) {
        GameManager gm = new GameManager();
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

    @Test
    void testCreateBackground() {

        int bgNum = 0;
        String bgFileName = "background.jpg";

        // Act: Create the background by calling the method
        ui.createBackground(bgNum, bgFileName);

        // Access the Pane and ImageView that should have been created
        Pane backgroundPane = (Pane) ui.window.getScene().getRoot().lookup(".background-pane-" + bgNum);
        assertNotNull(backgroundPane, "The background pane should be present.");

        // Check if the background image has been set on the ImageView
        ImageView bgImageView = (ImageView) backgroundPane.lookup(".background-image-view");
        assertNotNull(bgImageView, "The ImageView should be present in the background pane.");

        // Verify that the image is loaded by checking the image URL or properties
        Image bgImage = bgImageView.getImage();
        assertNotNull(bgImage, "The background image should be loaded.");
        assertEquals("background.jpg", bgImage.getUrl(), "The image URL should match the background file name.");

        // Verify the fit dimensions of the ImageView
        assertEquals(700, bgImageView.getFitWidth(), "The ImageView width should be set to 700.");
        assertEquals(350, bgImageView.getFitHeight(), "The ImageView height should be set to 350.");
    }

}
