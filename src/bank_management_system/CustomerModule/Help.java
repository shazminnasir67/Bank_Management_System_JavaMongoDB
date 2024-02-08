package bank_management_system.CustomerModule;
import bank_management_system.Components.GradientPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JPanel greyPanel;
    private JTextArea faqTextArea;
    private JButton backButton;

    public Help() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Help / FAQs");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 700));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0, 0, 0));
        bluePanel.setBounds(0, 0, 200, 700);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);

        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245), new Color(78, 79, 235));
        greyPanel.setBounds(200, 0, 1060, 700);
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);
        JButton homeButton = createButton("Home");
        homeButton.setBounds(20, 60, 150, 40);

        JButton profileButton = createButton("Transactions");
        profileButton.setBounds(20, 120, 150, 40);

        JButton recentButton = createButton("History");
        recentButton.setBounds(20, 180, 150, 40);

        JButton settingsButton = createButton("Settings");
        settingsButton.setBounds(20, 240, 150, 40);

        JButton logoutButton = createButton("Logout");
        logoutButton.setBounds(20, 300, 150, 40);

        JButton helpButton = createButton("Help");
        helpButton.setBounds(20, 360, 150, 40);

        bluePanel.add(homeButton);
        bluePanel.add(profileButton);
        bluePanel.add(recentButton);
        bluePanel.add(settingsButton);
        bluePanel.add(logoutButton);
        bluePanel.add(helpButton);

// Adjusted positions for separators
        JSeparator separator1 = createSeparator();
        separator1.setBounds(20, 110, 150, 1);

        JSeparator separator2 = createSeparator();
        separator2.setBounds(20, 170, 150, 1);

        JSeparator separator3 = createSeparator();
        separator3.setBounds(20, 230, 150, 1);

        JSeparator separator4 = createSeparator();
        separator4.setBounds(20, 290, 150, 1);

        JSeparator separator5 = createSeparator();
        separator5.setBounds(20, 350, 150, 1);

        JSeparator separator6 = createSeparator();
        separator6.setBounds(20, 410, 150, 1);

        JSeparator separator7 = createSeparator();
        separator7.setBounds(20, 470, 150, 1);

        bluePanel.add(separator1);
        bluePanel.add(separator2);
        bluePanel.add(separator3);
        bluePanel.add(separator4);
        bluePanel.add(separator5);
        bluePanel.add(separator6);


        mainPanel.add(bluePanel);


        faqTextArea = new JTextArea();
        faqTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        // Set text area background to be transparent
        faqTextArea.setForeground(Color.BLACK); // Set text area foreground to white
        faqTextArea.setLineWrap(true);
        faqTextArea.setWrapStyleWord(true);
        faqTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(faqTextArea);
        scrollPane.setBounds(20, 50, 960, 550);
        greyPanel.add(scrollPane);

        // You can populate the FAQ text here
        String faqText = "  Frequently Asked Questions:\n\n" +
                "   1. How do I open a new account?\n\n" +
                "   To open a new account, visit one of our branches with your valid ID and proof of address.\n\n" +
                "   2. How can I reset my password?\n\n" +
                "   You can reset your password by clicking on the 'Forgot Password' link on the sign-in page.\n\n" +
                "   3. How can I check my account balance?\n\n" +
                "   You can check your account balance by logging into your account online or by visiting an ATM.\n\n" +
                "   4. What should I do if my card is lost or stolen?\n\n" +
                "   If your card is lost or stolen, please contact our customer support immediately to report it.\n\n" +
                "   5. How can I transfer funds to another account?\n\n" +
                "   You can transfer funds to another account by using the 'Transfer Funds' feature in your online banking.\n\n" +
                "   6. How do I update my contact information?\n\n" +
                "   You can update your contact information by visiting the nearest branch or contacting our customer support.\n\n" +
                "   7. What are the fees for using ATMs?\n\n" +
                "   ATM fees vary depending on your account type and the ATM you use. Check our website for more information.\n\n" +
                "   8. How can I view my transaction history?\n\n" +
                "   You can view your transaction history by logging into your online banking account and selecting 'Transaction History'.\n\n";

        faqTextArea.setText(faqText);

        backButton = new JButton("Back");
        backButton.setBounds(50, 610, 100, 30);
        backButton.setBackground(new Color(78, 79, 235));
        backButton.setForeground(Color.WHITE);
        greyPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the back button action, e.g., returning to the main menu
                dispose(); // Close the Help window
            }
        });

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }
    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255,255,255));
        return separator;
    }
    private static JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 0, 0));
        button.setBorder(null);
        button.setOpaque(false);
        button.setFont(new Font("Monospaced",Font.PLAIN,16));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Help help = new Help();
            help.setVisible(true);
        });
    }
}
