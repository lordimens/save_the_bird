package it.unimol.save_the_bird.application;

import it.unimol.save_the_bird.Exceptions.EmptyStringException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {

    @Test
    public void check_61_seconds() {
        Timer timer = new Timer(){};
        timer.start();
        try {
            Thread.sleep(5000);
            timer.active=false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int minute = timer.getMinute();
        int second = timer.getSecond();

        assertEquals(0,minute);
        assertEquals(5,second);


    }

}