package it.unimol.save_the_bird.application;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Classe che attraverso l'utilizzo del thread permette di creare l'oggetto Shooting.
 *
 * @author Lorenzo Di Menna
 */

public class Shooting extends Thread {
    private int number;
    private int wait;
    private BufferedImage bullet_image;
    private List<Bullet> bullets = new ArrayList<Bullet>();
    private final int maxSpeed = 9;
    public boolean active;

    /**
     * Costruttore della classe che imposta automaticamente la variabile active = true {@code active=true}
     * per fare in modo che il thread possa partire immediatamente.
     *
     * @param number       Numero di proiettili da inserire in una riga
     * @param wait         Attesa tra la creazione di una riga e l'altra.
     * @param bullet_image Immagine del proiettile.
     */
    public Shooting(int number, int wait, BufferedImage bullet_image) {
        this.number = number;
        this.wait = wait;
        this.bullet_image = bullet_image;
        active = true;
    }

    @Override
    public void run() {

        while (active) {
            IntStream.range(0, number).forEach(i -> bullets.add(new Bullet(1300, (int) (Math.random() * 720), 20, 40,
                    (int) (Math.random() * maxSpeed) + 2, bullet_image)));
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            g.drawImage(bullet_image, bullet.getX(), bullet.getY(), 40, 20, null);
        }
    }

    public List<Bullet> getList() {
        return bullets;
    }

}
