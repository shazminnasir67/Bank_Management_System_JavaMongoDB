package bank_management_system.Components;

import javax.swing.*;
import java.awt.*;

public class DialogBox extends JFrame {
        public JPanel mainPanel;
        public JPanel bluePanel;
        public GradientPanel greyPanel;

        public DialogBox() {
            initComponents();
        }

        public void initComponents() {
          //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Dialog Box");

            mainPanel = new JPanel();
            mainPanel.setLayout(null);
            mainPanel.setPreferredSize(new Dimension(600, 600));

            bluePanel = new JPanel();
            bluePanel.setBackground(new Color(0, 0, 0));
            bluePanel.setBounds(0, 0, 600, 100);
            mainPanel.add(bluePanel);

            greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235)); // Using the custom gradient panel
          // Updated bounds to remove the gap
            greyPanel.setBounds(0, 100, 600, 500);  // Updated bounds to remove the gap
            greyPanel.setLayout(null);
            mainPanel.add(greyPanel);


            add(mainPanel);

            pack();

            setLocationRelativeTo(null);
        }
    public JButton createJButton(String text){
        JButton jbutton = new JButton(text);
        jbutton.setFont(new Font("Arial", Font.BOLD, 16));
        jbutton.setForeground(Color.WHITE);
//        jbutton.setOpaque(false);

        jbutton.setBackground(new Color(0, 0, 0));
        jbutton.setBorder(null);
        return jbutton;
    }
    public  JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }
    public JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(new Color(230, 230, 250));
        textField.setBorder(null);
        return textField;
    }

    public JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(230, 230, 250));
        passwordField.setBorder(null);
        return passwordField;
    }

    public JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        return separator;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {



        });
    }
}







