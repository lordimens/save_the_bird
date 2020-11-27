package it.unimol.save_the_bird.application;

import java.awt.*;

/**
 * Classe che implementa un cronometro per monitorare il tempo di sopravvivenza dell'utente.
 *
 * @author Lorenzo Di Menna
 */

public class Timer extends Thread {
    private int minute;
    private int second;
    public boolean active;

    public Timer() {
        active = true;
        minute = 0;
        second = 0;
    }

    @Override
    public void run() {
        while (active) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            second++;
            if (second == 60) {
                minute++;
                second = 0;
            }
        }
    }

    public void paint(Graphics g) {
        g.drawString(minute + ":" + second, 645, 25);
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
