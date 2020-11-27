package it.unimol.save_the_bird.GUI;

import it.unimol.save_the_bird.Exceptions.EmptyStringException;
import it.unimol.save_the_bird.application.FileReader;
import it.unimol.save_the_bird.application.FileWriter;
import it.unimol.save_the_bird.application.InterfaceHandler;
import it.unimol.save_the_bird.application.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DefeatPanel {
    private JPanel defeatPanel;
    private JButton try_againButton;
    private JButton exitButton;
    private JButton visualizza_classificaButton;
    public JButton saveButton;
    private JLabel timerLabel;

    private InterfaceHandler change_interface;
    private List<User> results = new ArrayList<User>();
    private List<User> users = new ArrayList<User>();

    private FileReader fileReader = FileReader.getInstance();
    private FileWriter fileWriter = FileWriter.getInstance();

    private File file_last_user = new File("Last_User.txt");
    private File file_results = new File("Result.txt");


    public DefeatPanel(InterfaceHandler change_interface) {
        this.change_interface = change_interface;
        results = fileReader.readFile(results, file_results);
        users = fileReader.readFile(results, file_last_user);

        timerLabel.setText("Il tuo tempo di sopravvivenza è stato: " + users.get(0).getSurvival_time());


        try_againButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_interface.choise(3);
            }
        });
        visualizza_classificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change_interface.choise(4);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                assert users.get(0)!=null;
                assert users.get(0).getUsername()==null;

                while (users.get(0).getUsername() == null) {
                    try {
                        users.get(0).setUsername(JOptionPane.showInputDialog("Inserisci il tuo nome"));
                        results.add(users.get(0));
                        fileWriter.writeFile(results, "Result.txt");
                        saveButton.setEnabled(false);
                    } catch (EmptyStringException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getDefeat_panel() {
        return defeatPanel;
    }
}
