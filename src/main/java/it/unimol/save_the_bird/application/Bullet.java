package it.unimol.save_the_bird.application;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    private int x;
    private int y;
    private int height;
    private int width;
    private int speed;
    public BufferedImage bullet_image;

    /**
     * Costruttore dell'oggetto Bullet.
     *
     * @param x      Coordinata x dell'oggetto.
     * @param y      Coordinata y dell'oggetto.
     * @param height Altezza dell'immagine rapresentante l'oggetto.
     * @param width  Larghezza dell'immagine rapresentante l'oggetto.
     * @param speed  Velocita' di spostamento dell'oggetto.
     * @param image  Immagine dell'oggetto
     */

    public Bullet(int x, int y, int height, int width, int speed, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.bullet_image = image;
    }

    public int getX() {
        acceleration();
        return x;
    }

    public int getY() {
        return y;
    }

    private void acceleration() {
        x -= speed;
    }

    /**
     * Restituisce il rettangolo che circonda l'oggetto.
     *
     * @return Coordinate e larghezza e altezza dell'oggetto.
     */

    public Rectangle getBorder() {
        return new Rectangle(x, y, width, height);
    }

}
