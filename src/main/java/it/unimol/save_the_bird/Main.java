
package it.unimol.save_the_bird;

import it.unimol.save_the_bird.application.InterfaceHandler;
import it.unimol.save_the_bird.application.Music;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int width = 1280;
    private static final int height = 720;
    private static final String game_name = "Save the Bird";


    public static void main(String[] args) {
        Music music = new Music();
        music.play("D:\\lordi\\lordi\\PROGETTI IntelliJ\\CHROME_DINO\\src\\musica\\traccia.wav").loop(6);
//prova
        Dimension frame_dimension = new Dimension(width, height);

        JFrame start_frame = new JFrame(game_name);
        start_frame.setPreferredSize(frame_dimension);
        start_frame.setMaximumSize(frame_dimension);
        start_frame.setResizable(false);

        InterfaceHandler gui = new InterfaceHandler(start_frame);
        gui.choise(0);


        start_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        start_frame.setVisible(true);
        start_frame.pack();
    }
}
