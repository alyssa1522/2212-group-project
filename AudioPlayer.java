
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * class that manages all the audio for the game
 * 
 * @author Alyssa Spasic
 */
public class AudioPlayer {
    private Clip backgroundMusicClip;
    private Clip buttonClickClip;
    private Clip madCatClip;
    private Clip correctClip;
/*
 * Initializing audio player
 */
    public AudioPlayer() {
        // Load background music
        loadBackgroundMusic("audio/backgroundMusic2.wav");
        // Load button click sound effect
        loadButtonClickSound("audio/buttonClick2.wav");
        // Load mad cat sound effect
        loadMadCatSound("audio/madCat.wav");
        // Load correct answer sound effect
        loadCorrectSound("audio/correct.wav");
    }
    /**
     * Loads the background music
     * @param filePath the file path 
     */
    private void loadBackgroundMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * Loads button click sound
     * @param filePath the file path
     */
    private void loadButtonClickSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            buttonClickClip = AudioSystem.getClip();
            buttonClickClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
/**
 * Loads the mad cat sound
 * @param filePath the file path
 */
    private void loadMadCatSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            madCatClip = AudioSystem.getClip();
            madCatClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * Loads correct sound
     * @param filePath the file path
     */
    private void loadCorrectSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            correctClip = AudioSystem.getClip();
            correctClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /**
     * plays background music
     */
    public void playBackgroundMusic() {
        if (backgroundMusicClip != null && !backgroundMusicClip.isRunning()) {
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    /**
     * stops background music
     */
    public void stopBackgroundMusic() {
        if (backgroundMusicClip != null && backgroundMusicClip.isRunning()) {
            backgroundMusicClip.stop();
        }
    }
    /**
     * plays button click sound
     */
    public void playButtonClickSound() {
        if (buttonClickClip != null) {
            buttonClickClip.setFramePosition(0);
            buttonClickClip.start();
        }
    }
    /**
     * plays mad cat sound
     */
    public void playMadCatSound() {
        if (madCatClip != null) {
            madCatClip.setFramePosition(0);
            madCatClip.start();
        }
    }
    /**
     * plays correct sound
     */
    public void playCorrectSound() {
        if (correctClip != null) {
            correctClip.setFramePosition(0);
            correctClip.start();
        }
    }
    /**
     * Sees if background music is playing
     * @return boolean of background music is playing 
     */
    public boolean isBackgroundMusicPlaying() {
        return backgroundMusicClip != null && backgroundMusicClip.isRunning();
    }
}
