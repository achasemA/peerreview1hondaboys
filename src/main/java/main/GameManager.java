package main;

import event.Event01;
import event.Event02;
import event.Event03;
import event.Event04;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import monsters.EngineStealerMonster;
import monsters.Hondaur;

public class GameManager extends Application {

    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public SceneChanger sChanger = new SceneChanger(this);

    private long startTime;
    private AnimationTimer gameTimer;
    private long elapsedTime;

    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Event03 ev3 = new Event03(this);
    public Event04 ev4 = new Event04(this);
    public Hondaur hondaur = new Hondaur(this);
    public EngineStealerMonster engineStealerMonster = new EngineStealerMonster(this);


    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ui.createMainField(primaryStage);
        ui.createPlayerField();
        ui.createGameOverField();
        player.setPlayerDefaultStatus();
        ui.generateScene();
        sChanger.showScene1();

        startGameTimer();
    }


    public void startGameTimer() {
        startTime = System.nanoTime();
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                elapsedTime = (now - startTime) / 1_000_000; // Convert to milliseconds
                updateTimerUI();
            }
        };
        gameTimer.start();
    }

    public void stopGameTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
        }
    }

    private void updateTimerUI() {
        // Format the time as minutes and seconds
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        seconds %= 60;

        // Display the timer on the UI
        ui.timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
}
