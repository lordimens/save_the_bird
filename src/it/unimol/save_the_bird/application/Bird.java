package it.unimol.save_the_bird.application;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird {
    private int x;
    private int y;
    private int height;
    private int width;
    private BufferedImage bird_image;
    private int maxSpeed;
    public int life = 5;

    /**
     * Costruttore dell'oggetto Bird.
     *
     * @param image  Immagine dell'oggetto.
     * @param width  Larghezza in px da assegnare all'immagine.
     * @param height Larghezza in px da assegnare all'immagine.
     * @param x      Distanza dal margine sinistro del JPanel in px.
     * @param speed  Velocita' di spostamento dell'oggetto.
     */

    public Bird(BufferedImage image, int width, int height, int x, int speed) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.bird_image = image;
        this.maxSpeed = speed;
    }

    /**
     * Contiene le operazioni per garantire lo spostamento verso l'alto dell'oggetto e verifica che l'oggetto non
     * sia uscito dal JPanel{@code if(y!=0)}.
     *
     * @return Posizione (coordinata y ) dell'oggetto.
     */

    public int climb() {
        if (y != 0) {
            y -= maxSpeed;
        }
        return y;
    }

    /**
     * Contiene le operazioni per garantire lo spostamento verso il basso dell'oggetto e verifica che l'oggetto non
     * sia uscito dal JPanel{@code if(y<=0)}.
     *
     * @return Posizione (coordinata y ) dell'oggetto.
     */

    public int downhill() {
        if (y <= 570) {
            y += maxSpeed;
        }
        return y;
    }

    /**
     * Restituisce il rettangolo che circonda l'oggetto.
     *
     * @return Coordinate e larghezza e altezza dell'oggetto.
     */

    public Rectangle getBorder() {
        return new Rectangle(x, y, width, height);
    }

    public void paint(Graphics g, int y) {
        g.drawImage(bird_image, x, y, width, height, null);
    }
}
