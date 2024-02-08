package bank_management_system.CustomerModule;

import bank_management_system.Components.GradientPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JPanel greyPanel;
    private JLabel settingsLabel;
    private JButton saveButton;

    private JCheckBox enableNotifications;
    private JCheckBox enableDarkMode;
    private JComboBox<String> languageComboBox;

    public Settings() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Settings");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 700));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0, 0, 0));
        bluePanel.setBounds(0, 0, 200, 700);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);

        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245), new Color(78, 79, 235));
        greyPanel.setBounds(200, 0, 1060, 650);
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);

        settingsLabel = new JLabel("Settings");
        settingsLabel.setForeground(Color.WHITE);
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        settingsLabel.setBounds(0, 20, 650, 30);
        settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greyPanel.add(settingsLabel);

        enableNotifications = new JCheckBox("Enable Notifications");
        enableNotifications.setBounds(50, 80, 200, 30);
        enableNotifications.setForeground(Color.WHITE);
        enableNotifications.setOpaque(false);
        greyPanel.add(enableNotifications);

        enableDarkMode = new JCheckBox("Enable Dark Mode");
        enableDarkMode.setBounds(50, 120, 200, 30);
        enableDarkMode.setForeground(Color.WHITE);
        enableDarkMode.setOpaque(false);
        greyPanel.add(enableDarkMode);

        languageComboBox = new JComboBox<>(new String[]{"English", "Spanish", "French", "German"});
        languageComboBox.setBounds(50, 160, 200, 30);
        languageComboBox.setForeground(Color.WHITE);
        languageComboBox.setOpaque(false);
        greyPanel.add(languageComboBox);

        saveButton = new JButton("Save");
        saveButton.setBounds(50, 200, 100, 30);
        saveButton.setBackground(new Color(102, 153, 204));
        saveButton.setBorder(BorderFactory.createEtchedBorder());
        greyPanel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle saving of settings here
                boolean notificationsEnabled = enableNotifications.isSelected();
                boolean darkModeEnabled = enableDarkMode.isSelected();
                String selectedLanguage = (String) languageComboBox.getSelectedItem();

                // You can save these settings to a configuration file or database
                // and apply them to your application.
            }
        });

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Settings settings = new Settings();
            settings.setVisible(true);
        });
    }
}
