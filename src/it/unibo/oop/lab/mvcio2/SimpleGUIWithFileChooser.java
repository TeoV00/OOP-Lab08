package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    public SimpleGUIWithFileChooser() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JButton saveBtn = new JButton("Save");
        final ControllerExtended controller = new ControllerExtended();

        saveBtn.addActionListener(e -> {
            try {
                controller.saveOnFile(textArea.getText());
               System.out.println(controller.getFullPath());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        final JPanel topPanel = new JPanel(new BorderLayout());
        final JTextField pathField = new JTextField(controller.getFullPath());
        final JButton browseBtn = new JButton("Browse");
        pathField.setEditable(false);

        browseBtn.addActionListener(e -> {
            final JFileChooser chooser = new JFileChooser();
            final int returnState = chooser.showSaveDialog(frame);
            if (returnState == JFileChooser.APPROVE_OPTION) {
                pathField.setText(chooser.getSelectedFile().getPath());
                controller.setFile(chooser.getSelectedFile().getName());
                textArea.setText(controller.getAllText());
            } else if (returnState == JFileChooser.CANCEL_OPTION) {
                //nothing, non error dialog window
                System.out.println("");
            } else {
                JOptionPane.showMessageDialog(chooser, "Error");
            }
        });
        System.out.println("set text text area");
        textArea.setText(controller.getAllText());

        topPanel.add(pathField, BorderLayout.CENTER);
        topPanel.add(browseBtn, BorderLayout.EAST);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(saveBtn, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser();
    }


}
