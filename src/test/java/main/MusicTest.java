package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;
import static org.mockito.Mockito.*;

class MusicTest {

    private Music music;
    private Clip mockClip;

    @BeforeEach
    void setUp() throws Exception {
        music = new Music();
        mockClip = mock(Clip.class);  // Mocking the Clip class
    }

    @Test
    void testPlay() {
        music.clip = mockClip;
        music.play(null);

        // Verify that play starts from the beginning (frame position is set to 0) and starts the clip
        verify(mockClip, times(1)).setFramePosition(0);
        verify(mockClip, times(1)).start();
    }

    @Test
    void testLoop() {
        music.clip = mockClip;
        music.loop(null);

        // Verify that loop is called with the proper argument for continuous looping
        verify(mockClip, times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    void testStop() {
        music.clip = mockClip;
        music.stop(null);

        // Verify that stop is called on the clip
        verify(mockClip, times(1)).stop();
    }
}