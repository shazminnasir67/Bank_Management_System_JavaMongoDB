package bank_management_system.CustomerModule;

import bank_management_system.Components.GradientPanel;
import bank_management_system.Dao.AccountDao;
import bank_management_system.MainScreen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDetails extends JFrame{
    private JPanel mainPanel;
    private JPanel bluePanel;
    private Account account;
    private Customer customer;



    public AccountDetails(Customer cust) {
        this.customer = cust;
        AccountDao acc = new AccountDao();
        account = acc.getAccountInfo(cust.getCUSTID());
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 700));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0, 0, 0));
        bluePanel.setBounds(0, 0, 200, 700);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);

        JButton homeButton = createButton("Dashboard");
        homeButton.setBounds(20, 60, 150, 40);

        JButton profileButton = createButton("Profile");
        profileButton.setBounds(20, 120, 150, 40);

        JButton recentButton = createButton("Transactions");
        recentButton.setBounds(20, 180, 150, 40);

        JButton account_details = createButton("Account Details");
        account_details.setBounds(20, 240, 150, 40);

        JButton logoutButton = createButton("Logout");
        logoutButton.setBounds(20, 300, 150, 40);

        JButton helpButton = createButton("Help and Support");
        helpButton.setBounds(20, 360, 150, 40);

        bluePanel.add(homeButton);
        bluePanel.add(profileButton);
        bluePanel.add(recentButton);
        bluePanel.add(account_details);
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


        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235)); // Using the custom gradient panel
        greyPanel.setBounds(200, 0, 1060, 650);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);

    GradientPanel cardPanel = new GradientPanel(new Color(101, 40, 247),new Color(227, 132, 255)); // Using the custom gradient panel
        cardPanel.setBounds(600, 100, 350, 200);  // Updated bounds to remove the gap
        cardPanel.setLayout(null);
        greyPanel.add(cardPanel);

    // Account number label at top left
    JLabel accountLabel = new JLabel(account.getCardNumber());
        accountLabel.setBounds(10, 30, 330, 30);
        accountLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 26));
        cardPanel.add(accountLabel);

    // Visa label at bottom right
    JLabel visaLabel = new JLabel("VISA");
        visaLabel.setFont(new Font("Arial", Font.BOLD, 26));
        visaLabel.setBounds(280, 160, 60, 30);
        cardPanel.add(visaLabel);

    // Valid from and valid end dates labels
    JLabel validFromLabel = new JLabel("Valid from: 05/25");
        validFromLabel.setBounds(40, 100, 100, 20);
        cardPanel.add(validFromLabel);

    JLabel validEndLabel = new JLabel("Valid until: 05/30");
        validEndLabel.setBounds(160, 100, 100, 20);
        cardPanel.add(validEndLabel);

    JLabel nameLabel = new JLabel(account.getFirstName());
        nameLabel.setBounds(20, 130, 330, 30);
        nameLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 22));
        cardPanel.add(nameLabel);

    // WiFi signals (using Unicode characters)
    JLabel wifiLabel = new JLabel("\u2301 \u2301 \u2301"); // Unicode for wifi symbol
        wifiLabel.setFont(new Font("Arial", Font.BOLD, 30));
        wifiLabel.setBounds(180, 160, 100, 30);
        cardPanel.add(wifiLabel);

        account_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetails acc = new AccountDetails(customer);
                acc.setVisible(true);
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard acc = new Dashboard(customer);
                acc.setVisible(true);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen acc = new MainScreen();
                acc.setVisible(true);
            }
        });
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Help acc = new Help();
                acc.setVisible(true);
            }
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile acc = new Profile(customer);
                acc.setVisible(true);
            }
        });

        add(mainPanel);

        pack();

        setLocationRelativeTo(null);
}
    private static JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 0, 0));
        button.setBorder(null);
        button.setFont(new Font("Monospaced",Font.PLAIN,16));
        return button;
    }
    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255,255,255));
        return separator;
    }

    public static void main(String[] args) {


    }
}
