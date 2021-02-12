package it.unimol.save_the_bird.application;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private BufferedImage image;

    /**
     * Permette il caricamento dell'immagine e gestisce un ì'eccezione IOException al suo interno nel caso l'immagine
     * specificata nel path non viene trovata.
     *
     * @param path Percorso dell'immagine.
     */
    public BufferedImage loadImage (String path){
        try {
            image= ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Immagine non trovata");
        }
        return image;
    }
}
