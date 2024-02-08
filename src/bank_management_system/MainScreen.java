package bank_management_system;

import bank_management_system.Components.FButton;
import bank_management_system.CustomerModule.GUISignIn;
import bank_management_system.Components.GradientPanel;
import bank_management_system.Manager.AdminMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;

    public MainScreen() {

        initComponents();
    }
    private void initComponents() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1150, 700));



//        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245), new Color(78, 79, 235)); // Using the custom gradient panel
//        greyPanel.setBounds(0, 0, 1000, 600);  // Updated bounds to remove the gap
//        greyPanel.setLayout(null);
//        mainPanel.add(greyPanel);
//        JLabel Wecome = new JLabel("WELCOME TO OUR BANK MANAGEMENT SYSTEM");
//        Wecome.setBounds(150,30,9000,40);
//        Wecome.setForeground(Color.BLACK);
//        Wecome.setFont(new Font("Arial", Font.BOLD, 28));
//        greyPanel.add(Wecome);
//
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/bank_management_system/Panelmain.png").getImage());
        JLabel editLabel1 = new JLabel();
        editLabel1.setIcon(imageIcon);
        editLabel1.setBounds(0,0,1150,700);
        mainPanel.add(editLabel1);

        FButton CustomerButton = new FButton();
        CustomerButton.setBounds(700,30,200,60);
        CustomerButton.setFillOriginal(Color.BLACK);
        CustomerButton.setForeground(Color.white);
        CustomerButton.setFillOver(new Color(78, 79, 235));
        CustomerButton.setText("Customer");
        editLabel1.add(CustomerButton);

        FButton EmployeeButton = new FButton();
        EmployeeButton.setBounds(920,30,200,60);
        EmployeeButton.setFillOriginal(Color.BLACK);
        EmployeeButton.setForeground(Color.white);
        EmployeeButton.setFillOver(new Color(78, 79, 235));
        EmployeeButton.setText("Employee");
        editLabel1.add(EmployeeButton);

        CustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                dispose();
                GUISignIn c = new GUISignIn();
                c.setVisible(true);
            }
        });
        EmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                dispose();
                AdminMain adminMain = new AdminMain();
                adminMain.setVisible(true);
            }
        });
        JPanel customPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Enable anti-aliasing for the custom panel
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
        };
        add(customPanel);
        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainScreen mm = new MainScreen();
            mm.setVisible(true);
        });
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "root", "like1212");
            // Perform your database operations here
        } catch (SQLException e) {
            // Handle any exceptions
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    System.out.println("connection closed");
                }else {
                    System.out.println("Connection is null");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any exceptions that occur while closing
            }
        }


    }
}
