package it.unimol.save_the_bird.GUI;

import it.unimol.save_the_bird.application.*;
import it.unimol.save_the_bird.application.Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che inizializza il pannello di gioco e implementa l'interfaccia Key ListenerMouseWheelListener per un eventuale
 * interazione da mouse con l'utente.
 * @author Lorenzo Di Menna
 */

public class GamePanel implements MouseWheelListener {

    private int bird_y = 260;
    private ImageHandler loader = new ImageHandler();
    private InterfaceHandler change_interface;
    private Music music = new Music();

    //CARICAMENTO IMMAGINI
    private BufferedImage bird = loader.loadImage("/immagini/bird.png");
    private BufferedImage bullet = loader.loadImage("/immagini/bullet.png");
    private BufferedImage background_game_panel = loader.loadImage("/immagini/background_game_panel.jpg");


    private Bird pio = new Bird(bird, 100, 100, 50, 15);
    private Shooting shooting = new Shooting(5, 2000, bullet);
    private Timer timer = new Timer();

    private User user = new User();
    private List<User> users = new ArrayList<User>();

    private FileWriter fileWriter = FileWriter.getInstance();


    private JPanel game_panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(background_game_panel, 0, 0, 1280, 720, null);

            g.setColor(Color.red);
            Font f = new Font("Helvetica", Font.BOLD, 20);
            g.setFont(f);
            g.drawString("Vita: " + pio.life, 25, 25);

            pio.paint(g, bird_y);
            shooting.paint(g);
            timer.paint(g);

            List<Bullet> bullets = shooting.getList();

            /*ITERAZIONE CHE SCORRE TUTTI GLI ELEMENTI DELLA LISTA BULLET E VERIFICA LA COLLISIONE CON PIO E IN CASO DI
            VITE PARI A 0 FA TERMINARE IL GIOCO E APRE IL DEFEAT PANEL*/

            for (int i = 0; i < bullets.size(); i++) {
                if (CollisionHandler.checkCollision(pio, bullets.get(i))) {
                    bullets.remove(i);
                    music.play("D:\\lordi\\lordi\\PROGETTI IntelliJ\\CHROME_DINO\\src\\musica\\sparo.wav").start();
                    pio.life -= 1;
                }
                if (pio.life == 0) {
                    shooting.active = false;
                    timer.active = false;

                    user.setSurvival_time(timer.getMinute() + ":" + timer.getSecond());
                    users.add(user);

                    fileWriter.writeFile(users, "Last_User.txt");
                    change_interface.choise(2);
                    break;
                }
            }
            repaint();

        }
    };


    public GamePanel(InterfaceHandler change_interface) {
        this.change_interface = change_interface;

        game_panel.addMouseWheelListener(this);

        shooting.start();
        timer.start();
    }

    public JPanel getGamePanel() {
        return game_panel;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation_code = e.getWheelRotation();
        if (rotation_code < 0) {
            bird_y = pio.climb();
            pio.paint(game_panel.getGraphics(), bird_y);
            game_panel.repaint();
        } else {
            bird_y = pio.downhill();
            pio.paint(game_panel.getGraphics(), bird_y);
            game_panel.repaint();
        }
    }
}

