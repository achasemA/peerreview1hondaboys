package main;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameManagerTest {
    private GameManager gameManager;
    private Music mockMusic;
    private SoundEffect mockSoundEffect;
    private UI mockUI;

    @BeforeAll
    static void initJavaFX() {
        // Initialize the JavaFX platform
        Platform.startup(() -> {});
    }

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();

        // Mock dependencies
        mockMusic = mock(Music.class);
        mockSoundEffect = mock(SoundEffect.class);
        mockUI = mock(UI.class);

        gameManager.music = mockMusic;
        gameManager.se = mockSoundEffect;
        gameManager.ui = mockUI;

        // Mock UI components
        gameManager.ui.timerLabel = new Label();
    }

    @Test
    void testPlaySE() {
        URL mockUrl = mock(URL.class);

        gameManager.playSE(mockUrl);

        verify(mockSoundEffect).setFile(mockUrl);
        verify(mockSoundEffect).play(mockUrl);
    }

    @Test
    void testPlayMusic() {
        URL mockUrl = mock(URL.class);

        gameManager.playMusic(mockUrl);

        verify(mockMusic).setFile(mockUrl);
        verify(mockMusic).play(mockUrl);
        verify(mockMusic).loop(mockUrl);
    }

    @Test
    void testStopMusic() {
        URL mockUrl = mock(URL.class);

        gameManager.stopMusic(mockUrl);

        verify(mockMusic).stop(mockUrl);
    }

    @Test
    void testStartGameTimer() {
        gameManager.startGameTimer();

        assertNotNull(gameManager.gameTimer);
        assertInstanceOf(AnimationTimer.class, gameManager.gameTimer);
    }

    @Test
    void testStopGameTimer() {
        gameManager.startGameTimer();
        gameManager.stopGameTimer();

        assertNotNull(gameManager.gameTimer);
    }
}