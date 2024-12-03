package main;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;
import java.util.Objects;

public class UI {
    GameManager gm;
    Stage window;
    public TextArea messageText;
    public Pane[] bgPane = new Pane[11];
    ImageView[] bgImageView = new ImageView[11];
    public Label timerLabel;

    // PLAYER UI
    public Label flashlightLabel, pistolLabel, ak47Label;
    ImageView[] lifeLabels = new ImageView[5];

    //GAME OVER UI
    public Label titleLabel;
    public Button restartButton;

    public UI(GameManager gm) {
        this.gm = gm;
    }

    public void createTitleScreen(Stage primaryStage) {
        // Window setup
        this.window = primaryStage;
        window.setTitle("Engine Of Desolation");
        window.setWidth(800);
        window.setHeight(600);

        // Create the root pane for the title screen
        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");

        // Background Image
        ImageView backgroundImage = new ImageView(
                new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("titleScreen.png")))
        );
        backgroundImage.setFitWidth(800);
        backgroundImage.setFitHeight(600);
        backgroundImage.setPreserveRatio(false);

        // Floating Text
        Text floatingText = new Text(80, 200, "Engine Of Desolation");
        floatingText.setFont(Font.font("Times New Roman", 70));
        floatingText.setFill(Color.DARKRED);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(floatingText.translateYProperty(), 0)),
                new KeyFrame(Duration.seconds(2), new KeyValue(floatingText.translateYProperty(), -50))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        //START BUTTON
        Button startButton = new Button("Start");
        startButton.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 24px; -fx-background-color: white;");
        startButton.setLayoutX((800 - 150) / 2); // Center horizontally (approximate for button width)
        startButton.setLayoutY(400);  // Center vertically (approximate for button height)

        // Start button functionality
        startButton.setOnAction(e -> {
            // Transition to the main game screen
            createMainField(window);
            createPlayerField();
            createGameOverField();
            gm.player.setPlayerDefaultStatus();
            generateScene();
            gm.sChanger.showScene1();
            gm.startGameTimer();

        });

        // Add components to root
        root.getChildren().addAll(backgroundImage, floatingText, startButton);

        // Create and set the scene
        Scene titleScene = new Scene(root, 800, 600);
        window.setScene(titleScene);
        window.show();
    }

    public void createMainField(Stage primaryStage) {
        this.window = primaryStage;
        window.setTitle("Engine Of Desolation");
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

        //Timer Label
        timerLabel = new Label("Time: 00:00");
        timerLabel.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 24px; -fx-text-fill: white;");
        timerLabel.setLayoutX((double) (800 - 100) / 2); // Center horizontally (approximate for 100px width)
        timerLabel.setLayoutY(10);
        root.getChildren().add(timerLabel);

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
        bgPane[bgNum].setVisible(false);

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
//To help objects appear and disappear when game is restarted
    public ImageView createObjectAndReturn(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
                                           String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem choice1 = new MenuItem(choice1Name);
        MenuItem choice2 = new MenuItem(choice2Name);
        MenuItem choice3 = new MenuItem(choice3Name);

        choice1.setOnAction(e -> gm.aHandler.handleAction(choice1Command));
        choice2.setOnAction(e -> gm.aHandler.handleAction(choice2Command));
        choice3.setOnAction(e -> gm.aHandler.handleAction(choice3Command));

        contextMenu.getItems().addAll(choice1, choice2, choice3);

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
        return objectImageView; // Return the created ImageView
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
        inventoryPanel.setSpacing(10);
        inventoryPanel.setPrefWidth(150);
        inventoryPanel.setPrefHeight(50);
        inventoryPanel.setStyle("-fx-background-color: black;");

        // Initialize and assign flashlightLabel
        Image flashlightImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("flashlightIcon.png")));
        flashlightLabel = new Label(); // Assign to flashlightLabel
        flashlightLabel.setGraphic(new ImageView(flashlightImage));
        flashlightLabel.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(flashlightLabel);

        // Initialize and assign pistolLabel
        Image pistolImage = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("pistol.png")));
        pistolLabel = new Label(); // Assign to pistolLabel
        pistolLabel.setGraphic(new ImageView(pistolImage));
        pistolLabel.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(pistolLabel);

        // Initialize and assign ak47Label
        Image ak47Image = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("ak47.png")));
        ak47Label = new Label(); // Assign to ak47Label
        ak47Label.setGraphic(new ImageView(ak47Image));
        ak47Label.setVisible(false); // Hide initially
        inventoryPanel.getChildren().add(ak47Label);

        Pane root = (Pane) window.getScene().getRoot();
        root.getChildren().addAll(background, lifePanel, inventoryPanel);
    }

    public void createGameOverField() {

        // Title Label
        titleLabel = new Label("");
        titleLabel.setLayoutX(200);
        titleLabel.setLayoutY(150);
        titleLabel.setTextFill(Color.RED);
        titleLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 70px;");
        titleLabel.setVisible(false);

        // Restart Button
        restartButton = new Button("Restart");
        restartButton.setLayoutX(340);
        restartButton.setLayoutY(320);
        restartButton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-border-color: transparent;");
        restartButton.setFocusTraversable(false);
        restartButton.setOnAction(e -> gm.aHandler.handleAction("restart"));
        restartButton.setVisible(false);

        // Add to root
        Pane root = (Pane) window.getScene().getRoot();
        titleLabel.layoutXProperty().bind(root.widthProperty().subtract(titleLabel.widthProperty()).divide(2));
        titleLabel.layoutYProperty().bind(root.heightProperty().subtract(titleLabel.heightProperty()).divide(2).subtract(50)); // Adjust offset as needed
        restartButton.layoutXProperty().bind(root.widthProperty().subtract(restartButton.widthProperty()).divide(2));
        restartButton.layoutYProperty().bind(root.heightProperty().subtract(restartButton.heightProperty()).divide(2).add(50)); // Adjust offset as needed
        root.getChildren().addAll(titleLabel, restartButton);
    }

    public void displayLeaderboard(List<String> leaderboard) {
        StringBuilder leaderboardText = new StringBuilder("Fastest Times:\n");
        for (int i = 0; i < leaderboard.size(); i++) {
            leaderboardText.append((i + 1)).append(". ").append(leaderboard.get(i)).append("\n");
        }

        // Display the leaderboard in a dialog or a text area
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Leaderboard");
        alert.setHeaderText("Top 10 Fastest Times");
        alert.setContentText(leaderboardText.toString());
        alert.showAndWait();
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
        // SCENE 3
        createBackground(3,"woods.png");
        gm.hondaur.addToScene();
        gm.engineStealerMonster.addToScene3();
        createArrowButton(3, 650, 150, 50, 50, "rightArrow50x50.png", "goScene4");
        // SCENE 4
        createBackground(4,"campfire.png");
        createObject(4, 100,100, 200,250,"denzel.png"
                , "Look", "Talk","Rest","lookDenzel",
                "talkDenzel","restDenzel");
        createArrowButton(4, 650, 150, 50, 50, "rightArrow50x50.png", "goScene5");
        // SCENE 5
        createBackground(5,"woods2.png");
        createObject(5, 250,150, 200,200,"hondaTrunk.png"
                , "Look", "Talk","Kill","lookHondaTrunk",
                "talkHondaTrunk","killHondaTrunk");
        createArrowButton(5, 650, 150, 50, 50, "rightArrow50x50.png", "goScene6");
        gm.theodoor.addToScene();
        gm.wheeler.addToScene();
        // SCENE 6
        createBackground(6, "casinoEntrance.png");
        createObject(6, 80, 140, 200, 250, "brandon.png",
                "Look", "Talk", "Rest",
                "lookBrandon", "talkBrandon", "restBrandon");
        createArrowButton(6, 650, 150, 50, 50, "rightArrow50x50.png", "goScene7");
        // SCENE 7
        createBackground(7, "casino.png");
        createObject(7, 200, 130, 200, 224, "julian.png",
                "Look", "Talk", "Hold",
                "lookJulian", "talkJulian", "holdJulian");
        createObject(7, 350, 30, 300, 354, "slotMachine.png",
                "Look", "Talk", "Spin",
                "lookSlotMachine", "talkSlotMachine", "spinSlotMachine");
        createObject(7, 80, 50, 225, 300, "adrian.png",
                "Look", "Talk", "Thank",
                "lookAdrian", "talkAdrian", "thankAdrian");
        createArrowButton(7, 650, 150, 50, 50, "rightArrow50x50.png", "goScene8");
        // SCENE 8
        createBackground(8, "cityStreet.png");
        gm.engineStealerMonster.addToScene8();
        createArrowButton(8, 650, 150, 50, 50, "rightArrow50x50.png", "goLeaderboard");
        // LEADERBOARD SCREEN
        createBackground(9,"bedroom.png");
    }
}