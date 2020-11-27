package it.unimol.save_the_bird.GUI;

import it.unimol.save_the_bird.application.ImageHandler;
import it.unimol.save_the_bird.application.InterfaceHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Classe che inizializza il pannello iniziale del gioco e implementa l'interfaccia Key Listener per un eventuale
 * interazione da tastiera con l'utente.
 * @author Lorenzo Di Menna
 */

public class StartPanel extends JPanel implements KeyListener {

    private ImageHandler loader = new ImageHandler();
    private BufferedImage background_start_panel = loader.loadImage("/immagini/background.jpg");
    private InterfaceHandler change_interface;

    private JPanel start_panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background_start_panel, 0, 0, getWidth(), getHeight(), null);
            g.dispose();
        }
    };

    public StartPanel(InterfaceHandler change_interface) {
        this.change_interface = change_interface;
        start_panel.setFocusable(true);
        start_panel.addKeyListener(this);
    }

    public JPanel getStart_panel() {
        return start_panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        change_interface.choise(1);
        start_panel.setFocusable(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
