package bank_management_system.CustomerModule;

import bank_management_system.Components.*;
import bank_management_system.Dao.AccountDao;
import bank_management_system.Dao.CustomerDao;
import bank_management_system.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;


public class Dashboard extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JPanel greyPanel;
    private JLabel CustomerLabel;
    private String customerbalance;
    private  Customer customer;
    private double balance;


   public Dashboard(){}

    public Dashboard (Customer customer) {
        CustomerDao dd = new CustomerDao();
        this.customer = dd.getCustomerByUsername(customer.getUsername());
        AccountDao acc = new AccountDao();
        balance=acc.getAccountBalance(this.customer.getCUSTID());
        initComponents();
    }

    private void initComponents() {
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton transactions = createButton("Transactions");
        transactions.setBounds(20, 180, 150, 40);

        JButton account_details = createButton("Account Details");
        account_details.setBounds(20, 240, 150, 40);

        JButton logoutButton = createButton("Logout");
        logoutButton.setBounds(20, 300, 150, 40);

        JButton helpButton = createButton("Help and Support");
        helpButton.setBounds(20, 360, 150, 40);

        bluePanel.add(homeButton);
        bluePanel.add(profileButton);
        bluePanel.add(transactions);
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
        greyPanel.setBounds(200, 0, 1000, 700);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);

        Header header  = new Header();
        header.setBounds(0,0,1000,70);
        greyPanel.add(header);

        LocalTime currentTime = LocalTime.now();
        String greeting;
        if (currentTime.isBefore(LocalTime.NOON)) {
            greeting = "Good morning";
        } else if (currentTime.isBefore(LocalTime.of(17, 0))) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        String customerName = customer.getFirstName();
        // Create a label for the welcome message
        JLabel welcomeLabel = new JLabel(String.format("%s, %s! Welcome to Our Bank Management System.", greeting, customerName));
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        welcomeLabel.setBounds(30,10,1000,50);// Customize font and size
        welcomeLabel.setForeground(Color.white);
        header.add(welcomeLabel);

        RoundPanel roundPanel1 = new RoundPanel();
        roundPanel1.setBounds(40,100,200,180);
        roundPanel1.setLayout(null);
//        CurveLineChart chart = new CurveLineChart();
//        chart.addData(new ModelChart("January", new double[]{500, 50, 100}));
//        chart.addData(new ModelChart("February", new double[]{600, 300, 150}));
//        chart.addData(new ModelChart("March", new double[]{200, 50, 900}));
//        chart.addData(new ModelChart("April", new double[]{480, 700, 100}));
//        chart.addData(new ModelChart("May", new double[]{350, 540, 500}));
//        chart.addData(new ModelChart("June", new double[]{450, 800, 100}));
//        roundPanel1.add(chart);
//        chart.start();
        JPanel jPanel1 = new JPanel();
        roundPanel1.setBackground(Color.BLACK);
        jPanel1.setBounds(15,25,200,180);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        Progress progress1 = new Progress();
        progress1.setBackground(new Color(78, 79, 235));
        progress1.setForeground(new Color(215, 187, 245));
        progress1.setBounds(10,0,150,150);
        progress1.setValue((int) ((balance/50000)*100));

        JLabel jLabel1 = new JLabel();
        jLabel1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(200, 200, 20));
        jLabel1.setBounds(0,0,200,12);
        jLabel1.setText("Current Balance");
        roundPanel1.add(jPanel1);
        jPanel1.add(jLabel1);
        jPanel1.add(progress1);
        greyPanel.add(roundPanel1);
        progress1.start();


        RoundPanel history_oanel = new RoundPanel();
        history_oanel.setBounds(700,90,250,540);
        history_oanel.setBackground(Color.white);
        greyPanel.add(history_oanel);

        RoundPanel transaction_oanel = new RoundPanel();
        transaction_oanel.setBounds(20,330,650,300);
        transaction_oanel.setBackground(Color.white);
        greyPanel.add(transaction_oanel);


        CustomerLabel = new JLabel("");
        CustomerLabel.setForeground(Color.WHITE);
        CustomerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        CustomerLabel.setBounds(0, 20, 600, 30);
        CustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greyPanel.add(CustomerLabel);

        account_details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDetails acc = new AccountDetails(customer);
                acc.setVisible(true);
            }
        });
        transactions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transactions tt = new Transactions(customer);
                tt.setVisible(true);
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


        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/bank_management_system/Icons/Waves.png").getImage());
        JLabel veiwLabel = new JLabel();
        veiwLabel.setIcon(imageIcon);
        veiwLabel.setBounds(0,100,1060,650);
        greyPanel.add(veiwLabel);


          customerbalance = String.valueOf(balance);
          Card Total_Money = new Card();
          Total_Money.setColor1(Color.BLACK);
          Total_Money.setColor2(new Color(101, 40, 247));
          Total_Money.setBounds(300,90,300,200);
        Total_Money.setData(new Model_Card(new ImageIcon(getClass().getResource("/bank_management_system/Icons/profit.png")),"Total Balance",customerbalance,"Rupees"));
        greyPanel.add(Total_Money);
//        Card Card2 = new Card();
//        Card2.setColor1(Color.BLACK);
//        Card2.setColor2(new Color(101, 40, 247));
//        Card2.setBounds(300,100,200,180);
//        Card2.setData(new Model_Card(new ImageIcon(getClass().getResource("profit.png")),"Total Balance",customerbalance,"Rupees"));
//        greyPanel.add(Card2);



        add(mainPanel);

        pack();

        setLocationRelativeTo(null);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
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

