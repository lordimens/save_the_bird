package it.unimol.save_the_bird.application;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    /**
     * Carica una traccia audio
     *
     * @param path Percorso del file audio.
     * @return Oggetto clip che poi al momento dell'uso sara' l'utente a decidere come farlo riprodurre.
     */

    public Clip play(String path) {
        AudioInputStream audio = null;
        try {
            audio = AudioSystem.getAudioInputStream(new File(path));
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;

        try {
            clip = AudioSystem.getClip();
            assert clip != null;
            clip.open(audio);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        assert clip != null;
        return clip;
    }
}
