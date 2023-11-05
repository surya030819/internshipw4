import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAdventureGameGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextArea textArea;
    private JButton choiceButton1;
    private JButton choiceButton2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextAdventureGameGUI gameGUI = new TextAdventureGameGUI();
            gameGUI.createAndShowGUI();
        });
    }

    public TextAdventureGameGUI() {
        frame = new JFrame("Text Adventure Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        choiceButton1 = new JButton("Choice 1");
        choiceButton2 = new JButton("Choice 2");

        choiceButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChoice(1);
            }
        });

        choiceButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChoice(2);
            }
        });

        panel.add(textArea);
        panel.add(choiceButton1);
        panel.add(choiceButton2);

        frame.getContentPane().add(panel);
    }

    public void createAndShowGUI() {
        frame.pack();
        frame.setVisible(true);
        displayStory("Welcome to the Text Adventure Game!\nYou find yourself at a crossroads. What will you do?\n1. Go left\n2. Go right");
    }

    private void displayStory(String message) {
        textArea.setText(message);
    }

    private void handleChoice(int choice) {
        if (choice == 1) {
            displayStory("You chose to go left.\nYou discover a treasure chest! What do you do?\n1. Open it\n2. Ignore it and continue");
        } else if (choice == 2) {
            displayStory("You chose to go right.\nYou encounter a ferocious dragon! What do you do?\n1. Fight the dragon\n2. Run away");
        }
        // Handle other scenarios and choices accordingly
    }
}