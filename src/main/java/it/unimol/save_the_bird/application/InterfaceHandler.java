package it.unimol.save_the_bird.application;

import it.unimol.save_the_bird.GUI.*;

import javax.swing.*;

/**
 * Classe che permette di gestire il cambiamento tra un JPanel e un altro.
 *
 * @author Lorenzo Di Menna
 */

public class InterfaceHandler {

    private JFrame window;
    private StartPanel start_panel;
    private GamePanel game_panel;
    private DefeatPanel defeat_panel;
    private ShowResult show_result_panel;

    public InterfaceHandler(JFrame frame) {
        window = frame;
        this.choise(0);
    }

    /**
     * Ad ogni stato effettua una rimozione di un determinato JPanel e lo sostituisce con quello desiderato.
     */

    public void choise(int status) {
        if (status == 0) {
            this.start_panel = new StartPanel(this);
            this.window.add(start_panel.getStart_panel());
        } else if (status == 1) {
            this.window.remove(start_panel.getStart_panel());
            this.game_panel = new GamePanel(this);
            this.window.add(game_panel.getGamePanel());
            this.window.revalidate();
        } else if (status == 2) {
            this.window.remove(game_panel.getGamePanel());
            this.defeat_panel = new DefeatPanel(this);
            this.window.add(defeat_panel.getDefeat_panel());
            this.window.revalidate();
        } else if (status == 3) {
            this.window.remove(defeat_panel.getDefeat_panel());
            this.game_panel = new GamePanel(this);
            this.window.add(game_panel.getGamePanel());
            this.window.revalidate();
        } else if (status == 4) {
            this.window.remove(defeat_panel.getDefeat_panel());
            this.show_result_panel = new ShowResult(this);
            this.window.add(show_result_panel.getshow_Result());
            this.window.revalidate();
        } else if (status == 5) {
            this.window.remove(show_result_panel.getshow_Result());
            this.defeat_panel = new DefeatPanel(this);
            this.window.add(defeat_panel.getDefeat_panel());
            defeat_panel.saveButton.setEnabled(false);
            this.window.revalidate();
        }
    }
}
