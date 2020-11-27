package it.unimol.save_the_bird.application;

import it.unimol.save_the_bird.Exceptions.EmptyStringException;

import java.io.Serializable;

/**
 * Classe che rappresenta l'utente e implementa Serializable per permette il salvataggio su file attraverso la
 * serializzazione.
 *
 * @author Lorenzo Di Menna
 */

public class User implements Serializable {
    private String username;
    private String survival_time;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws EmptyStringException {
        if (!username.isEmpty()) {
            this.username = username;
        } else {
            throw new EmptyStringException("La stringa username è vuota");
        }
    }

    public String getSurvival_time() {
        return survival_time;
    }

    public void setSurvival_time(String survival_time) {
        this.survival_time = survival_time;
    }
}
