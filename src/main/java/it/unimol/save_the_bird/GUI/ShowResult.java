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

/*        Font f = new Font("Helvetica", Font.BOLD, 20);
        result_textArea.setFont(f);*/
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        showResult = new JPanel();
        showResult.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        showResult.setBackground(new Color(-1896448));
        final JLabel label1 = new JLabel();
        label1.setBackground(new Color(-1896448));
        Font label1Font = this.$$$getFont$$$("Bauhaus 93", -1, 72, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("RISULTATI");
        showResult.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        indietroButton = new JButton();
        indietroButton.setText("Indietro");
        showResult.add(indietroButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        showResult.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        result_textArea = new JTextArea();
        scrollPane1.setViewportView(result_textArea);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return showResult;
    }

}
