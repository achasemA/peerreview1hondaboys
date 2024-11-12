package main;

import event.Event01;
import event.Event02;
import event.Event03;
import javafx.application.Application;
import javafx.stage.Stage;
import monsters.EngineStealerMonster;
import monsters.Hondaur;

public class GameManager extends Application {
    ActionHandler aHandler = new ActionHandler(this);
    public UI ui = new UI(this);
    public Player player = new Player(this);
    public SceneChanger sChanger = new SceneChanger(this);

    public Event01 ev1 = new Event01(this);
    public Event02 ev2 = new Event02(this);
    public Event03 ev3 = new Event03(this);
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
        player.setPlayerDefaultStatus();
        ui.generateScene();
        sChanger.showScene1();
    }
}
