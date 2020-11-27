package it.unimol.save_the_bird.application;

import it.unimol.save_the_bird.Exceptions.EmptyStringException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test (expected=EmptyStringException.class)
    public void check_null_username() throws EmptyStringException {
        User user = new User();
        user.setUsername("");
    }

    @Test
    public void check_valid_username() throws EmptyStringException {
        User user = new User();
        user.setUsername("lorenzo");
    }
}