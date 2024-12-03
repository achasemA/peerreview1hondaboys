package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;
import static org.mockito.Mockito.*;

class SoundEffectTest {

    private SoundEffect soundEffect;
    private Clip mockClip;

    @BeforeEach
    void setUp() {
        soundEffect = new SoundEffect();
        mockClip = mock(Clip.class);  // Mocking the Clip class
    }

    @Test
    void testPlay() {
        soundEffect.clip = mockClip;
        soundEffect.play(null);

        // Verify that play starts from the beginning (frame position is set to 0) and starts the clip
        verify(mockClip, times(1)).setFramePosition(0);
        verify(mockClip, times(1)).start();
    }
}