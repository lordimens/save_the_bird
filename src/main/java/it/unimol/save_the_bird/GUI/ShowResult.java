package it.unimol.save_the_bird.GUI;

import it.unimol.save_the_bird.application.FileReader;
import it.unimol.save_the_bird.application.InterfaceHandler;
import it.unimol.save_the_bird.application.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShowResult {
    private JPanel showResult;
    private JTextArea result_textArea;
    private JButton indietroButton;

    public InterfaceHandler change_interface;

    private FileReader fileReader = FileReader.getInstance();
    private File file_results = new File("Result.txt");
    private List<User> results = new ArrayList<User>();


    public ShowResult(InterfaceHandler change_interface) {
        this.change_interface = change_interface;

        results = fileReader.readFile(results, file_results);

        Font f = new Font("Helvetica", Font.BOLD, 20);
        result_textArea.setFont(f);
        for (int i = 0; i < results.size(); i++) {
            result_textArea.append("Utente: " + results.get(i).getUsername() + " - Tempo: " + results.get(i).getSurvival_time() + "\n");
        }

        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_interface.choise(5);
            }
        });
    }

    public JPanel getshow_Result() {
        return showResult;
    }
}
