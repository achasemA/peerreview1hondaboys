package main;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class UI {
    GameManager gm;
    Stage window;
    public TextArea messageText;
    public Pane[] bgPane = new Pane[10];
    ImageView[] bgImageView = new ImageView[10];
    ImageView[] lifeLabels = new ImageView[5];

    // PLAYER UI
    public Label flashlightLabel, pistolLabel, ak47Label;

    public UI(GameManager gm) {
        this.gm = gm;
    }

    public void createMainField(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Game Window");
        window.setWidth(800);
        window.setHeight(600);

        // Main Pane with black background
        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");

        // Create main TextArea
        messageText = new TextArea("THIS IS SAMPLE TEXT");
        messageText.setPrefSize(700, 150);
        messageText.setLayoutX(50);
        messageText.setLayoutY(410);
        messageText.setEditable(false);
        messageText.setWrapText(true);

        // Set styles for the TextArea
        messageText.setStyle("-fx-font-family: 'Arial'; " +
                "-fx-font-size: 26px; " +
                "-fx-background-color: black; " + //
                "-fx-text-fill: black; " +
                "-fx-border-color: white; " +
                "-fx-border-width: 1px;");

        // Add the TextArea to the root Pane
        root.getChildren().add(messageText);

        // Create and set the Scene
        Scene scene = new Scene(root, 800, 600);
        window.setScene(scene); // Set the scene to the primary stage
        window.show(); // Show the primary stage
    }

    public void createBackground(int bgNum, String bgFileName) {
        bgPane[bgNum] = new Pane();
        bgPane[bgNum].setPrefSize(700, 350);
        bgPane[bgNum].setLayoutX(50);
        bgPane[bgNum].setLayoutY(50);

        // Background Image
        Image bgImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(bgFileName)));
        bgImageView[bgNum] = new ImageView(bgImage);
        bgImageView[bgNum].setFitWidth(700);
        bgImageView[bgNum].setFitHeight(350);

        bgPane[bgNum].getChildren().add(bgImageView[bgNum]);
        ((Pane) window.getScene().getRoot()).getChildren().add(bgPane[bgNum]);
    }

    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
                             String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
        // Context Menu for Object
        ContextMenu contextMenu = new ContextMenu();
        MenuItem choice1 = new MenuItem(choice1Name);
        MenuItem choice2 = new MenuItem(choice2Name);
        MenuItem choice3 = new MenuItem(choice3Name);

        choice1.setOnAction(e -> gm.aHandler.handleAction(choice1Command));
        choice2.setOnAction(e -> gm.aHandler.handleAction(choice2Command));
        choice3.setOnAction(e -> gm.aHandler.handleAction(choice3Command));

        contextMenu.getItems().addAll(choice1, choice2, choice3);

        // Object Image
        Image objectImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(objFileName)));
        ImageView objectImageView = new ImageView(objectImage);
        objectImageView.setFitWidth(objWidth);
        objectImageView.setFitHeight(objHeight);
        objectImageView.setLayoutX(objx);
        objectImageView.setLayoutY(objy);

        objectImageView.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(objectImageView, e.getScreenX(), e.getScreenY());
            }
        });

        bgPane[bgNum].getChildren().add(objectImageView);
    }

    public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command) {
        // Arrow Button Image
        Image arrowImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(arrowFileName)));
        Button arrowButton = new Button();
        arrowButton.setGraphic(new ImageView(arrowImage));
        arrowButton.setLayoutX(x);
        arrowButton.setLayoutY(y);
        arrowButton.setOnAction(e -> gm.aHandler.handleAction(command));
        bgPane[bgNum].getChildren().add(arrowButton);
    }
    public void createPlayerField() {
        // Create a HBox to hold the life icons
        HBox lifePanel = new HBox();
        lifePanel.setSpacing(10); // Space between icons
        lifePanel.setLayoutX(50); // Set X position
        lifePanel.setLayoutY(0); // Set Y position

        // Create a background rectangle for the life panel
        Rectangle background = new Rectangle(300 , 50);
        background.setLayoutX(50);
        background.setLayoutY(0);
        background.setFill(Color.BLACK); // Set background color to blue

        // Load the life icon image
        Image lifeImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("heart.png")));

        // Loop to create and add life icons to the lifePanel
        for (int i = 0; i < 5; i++) { // 5 life icons
            lifeLabels[i] = new ImageView(lifeImage); // Create a new ImageView for each icon
            lifeLabels[i].setFitWidth(50); // Set width of each icon
            lifeLabels[i].setFitHeight(50); // Set height of each icon
            lifePanel.getChildren().add(lifeLabels[i]);
        }

        HBox inventoryPanel = new HBox();
        inventoryPanel.setLayoutX(590);
        inventoryPanel.setLayoutY(0);
        inventoryPanel.setSpacing(10); // Similar to GridLayout in Java Swing
        inventoryPanel.setPrefWidth(150);
        inventoryPanel.setPrefHeight(50);
        inventoryPanel.setStyle("-fx-background-color: black;");

        // Initialize and assign flashlightLabel
        Image flashlightImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("flashlight (1).png")));
        flashlightLabel = new Label(); // Assign to flashlightLabel
        flashlightLabel.setGraphic(new ImageView(flashlightImage));
        flashlightLabel.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(flashlightLabel);

        // Initialize and assign pistolLabel
        Image pistolImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pistol-gun (1).png")));
        pistolLabel = new Label(); // Assign to pistolLabel
        pistolLabel.setGraphic(new ImageView(pistolImage));
        pistolLabel.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(pistolLabel);

        // Initialize and assign ak47Label
        Image ak47Image = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("ak47 (1).png")));
        ak47Label = new Label(); // Assign to ak47Label
        ak47Label.setGraphic(new ImageView(ak47Image));
        ak47Label.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(ak47Label);

        Pane root = (Pane) window.getScene().getRoot(); // Assuming you are using a Pane as the root
        root.getChildren().addAll(background, lifePanel, inventoryPanel); // Add background and lifePanel to the root
    }

    public void generateScene() {
        // SCENE 1
        createBackground(1, "bedroom.png");
        createObject(1, 100, 100, 200, 250, "jeramiah.png",
                "Look", "Talk", "Rest",
                "lookJeramiah", "talkJeramiah", "restJeramiah");
        createObject(1, 500, 230, 50, 50, "flashlight.png",
                "Look", "Grab", "Rest",
                "lookFlashlight", "grabFlashlight", "restFlashlight");
        createArrowButton(1, 650, 150, 50, 50, "rightArrow50x50.png", "goScene2");
        // SCENE 2
        createBackground(2, "driveway700x350.png");
        createObject(2, 350, 230, 200, 151, "honda200x151.png",
                "Search Inside", "Search hood", "Rest",
                "search1Honda", "search2Honda", "restHonda");
        createArrowButton(2, 650, 150, 50, 50, "rightArrow50x50.png", "goScene3");
        //SCENE 3
        createBackground(3,"woods.png");
        gm.hondaur.addToScene();
        gm.engineStealerMonster.addToScene();
    }
}