package main;

/**
 * This class handles the sound effects
 */

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

    Clip clip;

    public void setFile(URL name){

        try{
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(URL name){
        clip.setFramePosition(0);
        clip.start();
    }
}
