package bank_management_system.CustomerModule;

import bank_management_system.Components.DialogBox;
import bank_management_system.Components.FButton;
import bank_management_system.Components.GradientPanel;
import bank_management_system.Dao.AccountDao;
import bank_management_system.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions extends JFrame{
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JPanel greyPanel;
    private JLabel CustomerLabel;
    private JButton veiwButton;
    private JButton editButton;
    private JButton withdrawButton;
    private JButton transactionButton;
    private JButton paybillButton;
    private JButton depositButton;
    private JSeparator separator1;
    private  JSeparator separator2;
    private Customer customer;
    private JTable table;

    public Transactions(Customer customer) {

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

        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235)); // Using the custom gradient panel
        greyPanel.setBounds(200, 0, 1060, 650);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);

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

        JButton helpButton = createButton("Help");
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

        JLabel iconLabel = new JLabel(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\bankicon.png")); // Replace with the actual path to your icon
        iconLabel.setBounds(50,50,200,200); // Set the position and size of the icon label
        bluePanel.add(iconLabel);
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\\\Users\\\\HOME\\\\Desktop\\\\Project\\\\src\\\\newSystem\\\\src\\\\image1.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
    JLabel veiwLabel = new JLabel();
        veiwLabel.setIcon(imageIcon);
        veiwLabel.setBounds(150,100,200,200);
        greyPanel.add(veiwLabel);

    ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\folder.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
    JLabel editLabel = new JLabel();
        editLabel.setIcon(imageIcon2);
        editLabel.setBounds(300,80,130,130);
        greyPanel.add(editLabel);



    ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\icon3.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
    JLabel editLabel1 = new JLabel();
        editLabel1.setIcon(imageIcon3);
        editLabel1.setBounds(880,70,150,150);
        greyPanel.add(editLabel1);

    ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\icon4.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
    JLabel editLabel2 = new JLabel();
        editLabel2.setIcon(imageIcon4);
        editLabel2.setBounds(280,60,150,150);
        greyPanel.add(editLabel2);

        FButton TransactionButton = new FButton();
        TransactionButton.setBounds(150, 200, 200, 50);
        TransactionButton.setFillOriginal(Color.BLACK);
        TransactionButton.setForeground(Color.white);
        TransactionButton.setFillOver(new Color(78, 79, 235));
        TransactionButton.setText("Transaction");
        greyPanel.add(TransactionButton);

        FButton DepositButton = new FButton();
        DepositButton.setBounds(150, 400, 200, 50);
        DepositButton.setFillOriginal(Color.BLACK);
        DepositButton.setForeground(Color.white);
        DepositButton.setFillOver(new Color(78, 79, 235));
        DepositButton.setText("Deposit Money");
        greyPanel.add(DepositButton);

        FButton WithdrawButton = new FButton();
        WithdrawButton.setBounds(450, 400, 200, 50);
        WithdrawButton.setFillOriginal(Color.BLACK);
        WithdrawButton.setForeground(Color.white);
        WithdrawButton.setFillOver(new Color(78, 79, 235));
        WithdrawButton.setText("withdraw  Money");
        greyPanel.add(WithdrawButton);

        FButton PaybillButton = new FButton();
        PaybillButton.setBounds(450, 200, 200, 50);
        PaybillButton.setFillOriginal(Color.BLACK);
        PaybillButton.setForeground(Color.white);
        PaybillButton.setFillOver(new Color(78, 79, 235));
        PaybillButton.setText("Paybill");
        greyPanel.add(PaybillButton);



    ImageIcon imageIcon5 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\icon5.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
    JLabel editLabel3 = new JLabel();
        editLabel3.setIcon(imageIcon5);
        editLabel3.setBounds(300,260,140,140);
        greyPanel.add(editLabel3);

    ImageIcon imageIcon6 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\icon6.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
    JLabel editLabel4 = new JLabel();
        editLabel4.setIcon(imageIcon6);
        editLabel4.setBounds(580,260,140,140);
        greyPanel.add(editLabel4);

    ImageIcon imageIcon7 = new ImageIcon(new ImageIcon("C:\\Users\\HOME\\Desktop\\Project\\src\\newSystem\\src\\icon7.png").getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
    JLabel editLabel5 = new JLabel();
        editLabel5.setIcon(imageIcon7);
        editLabel5.setBounds(880,270,150,150);
        greyPanel.add(editLabel5);

        TransactionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            transaction();
        }
    });
        PaybillButton.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            PayBill();
        }
    });
        WithdrawButton.addActionListener(new

    ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            Withdraw();
        }
    });
        DepositButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            Deposit();
        }
    });

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
        button.setOpaque(false);
        button.setFont(new Font("Monospaced",Font.PLAIN,16));
        return button;
    }


    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(230, 230, 250));
        passwordField.setBorder(null);
        return passwordField;
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255,255,255));
        return separator;
    }
    AccountDao accountDao = new AccountDao();
    public void Withdraw() {
        DialogBox db = new DialogBox();
        JLabel amount_To_be_withdrawn = db.createLabel("Enter Amount:");
        amount_To_be_withdrawn.setBounds(120, 40, 130, 20);
        JTextField amounttext = db.createTextField();
        amounttext.setBounds(300, 40, 130, 20);
        JLabel Id = db.createLabel("Enter Account ID:");
        Id.setBounds(120, 80, 130, 20);
        JTextField ID = db.createTextField();
        ID.setBounds(300, 80, 130, 20);
        JButton button1 = db.createJButton("Withdraw");
        button1.setBounds(220, 130, 130, 30);
        button1.setBorder(BorderFactory.createEtchedBorder());
        db.greyPanel.add(amount_To_be_withdrawn);
        db.greyPanel.add(amounttext);
        db.greyPanel.add(Id);
        db.greyPanel.add(ID);
        db.greyPanel.add(button1);
        db.setVisible(true);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(ID.getText().isEmpty() && amounttext.getText().isEmpty())) {
                    boolean accept = accountDao.withdrawMoney(Integer.parseInt(ID.getText()),Integer.parseInt(amounttext.getText()));
                    if (accept) {
                        //setBalance(currentBalance - withdrawAmount);

                        JTextArea message = new JTextArea("Withdraw Confirmation\n" +
                                "\n" +
                                "Transaction Details:\n" +
                                "\n" +
                                "Account Number: " + ID.getText() + "\n" +
                                "Transaction Date: " + currentDate + "\n" +
                                "Transaction Time: " + currentTime + "\n" +
                                "Withdraw Amount: " + amounttext.getText() + "\n" +
                                "Current Balance: " + accountDao.getAccountBalance(Integer.parseInt(ID.getText())));
                        message.setBounds(20, 180, 550, 150);
                        message.setEditable(false);
                        message.setLineWrap(true);
                        message.setBackground(new Color(102, 153, 204));
                        message.setForeground(Color.white);
                        Font font = new Font("Arial", Font.BOLD, 13);
                        message.setFont(font);
                        db.greyPanel.add(message);

                        JTextArea message2 = new JTextArea("Thank you for using our online banking services. " +
                                "Your withdrawal  has been successfully debited from your account. " +
                                "If you have any questions or require further assistance, please don't hesitate to " +
                                "contact our customer support.\n\n" +
                                "Regards,\n" +
                                "ATLAS BANK");
                        message2.setBounds(20, 360, 550, 220);
                        message2.setEditable(false);
                        message2.setLineWrap(true);
                        message2.setBackground(new Color(102, 153, 204));
                        message2.setForeground(Color.white);
                        Font font3 = new Font("Arial", Font.ITALIC, 13);
                        message2.setFont(font3);
                        db.greyPanel.add(message2);

                        db.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(db, "Insufficient balance in the account.",
                                "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    ID.setBorder(BorderFactory.createLineBorder(Color.red));
                    amounttext.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });
    }

    public void Deposit(){
        DialogBox db = new DialogBox();
        JLabel amount_To_be_deposit = db.createLabel("Enter Amount :");
        amount_To_be_deposit.setBounds(120,40,130,20);
        JTextField amounttext = db.createTextField();
        amounttext.setBounds(300,40,130,20);
        JLabel Id = db.createLabel("Enter Account ID :");
        Id.setBounds(120,80,130,20);
        JTextField ID = db.createTextField();
        ID.setBounds(300,80,130,20);
        JButton button1 = db.createJButton("Deposit");
        button1.setBounds(220,130,130,30);
        button1.setBorder(BorderFactory.createEtchedBorder());
        db.greyPanel.add(amount_To_be_deposit);
        db.greyPanel.add(amounttext);
        db.greyPanel.add(Id);
        db.greyPanel.add(ID);
        db.greyPanel.add(button1);
        db.setVisible(true);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(ID.getText().equals("")&&amounttext.getText().equals(""))) {
                    int accountId = Integer.parseInt(ID.getText());
                    double depositAmount = Integer.parseInt(amounttext.getText());
                    accountDao.depositMoney(accountId,depositAmount);
                    JTextArea message = new JTextArea("Deposit Confirmation\n" +
                            "\n" +
                            "Transaction Details:\n" +
                            "\n" +
                            "Account Number: " + ID.getText() + "\n" +
                            "Transaction Date:" + currentDate + "\n" +
                            "Transaction Time:" + currentTime + "\n" +
                            "Deposit Method:  Online Transfer\n" +
                            "Current Amount: " + accountDao.getAccountBalance(accountId));
                    message.setBounds(20, 180, 550, 150);
                    message.setEditable(false);
                    message.setLineWrap(true);
                    message.setForeground(Color.white);
                    Font font = new Font("Arial", Font.BOLD, 13);
                    message.setFont(font);

                    db.greyPanel.add(message);

                    JTextArea message2 = new JTextArea("Thank you for using our online banking services.Your deposit has been successfully " +
                            "credited to your account. If you have any questions or require further assistance," +
                            "please don't hesitate to contact our customer support.\n\n" +
                            "Regards,\n" +
                            "ATLAS BANK" );
                    message2.setBounds(20, 360, 550, 220);
                    message2.setEditable(false);
                    message2.setLineWrap(true);
                    message2.setForeground(Color.white);
                    Font font3 = new Font("Arial", Font.ITALIC, 13);
                    message2.setFont(font3);
                    db.greyPanel.add(message2);
                    db.setVisible(true);

                }else {
                    ID.setBorder(BorderFactory.createLineBorder(Color.red));
                    amounttext.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });

    }

    public  void transaction() {
        DialogBox db = new DialogBox();
        db.setSize(900, 600);
        db.greyPanel.setBounds(0, 100, 900, 500);
        db.bluePanel.setBounds(0, 0, 900, 100);
        db.setTitle("Transaction");

        JLabel senderLabel = db.createLabel("Sender Account ID:");
        senderLabel.setBounds(120, 40, 150, 20);
        JTextField senderText = db.createTextField();
        senderText.setBounds(300, 40, 130, 20);

        JLabel receiverLabel = db.createLabel("Receiver Account ID:");
        receiverLabel.setBounds(120, 70, 150, 20);
        JTextField receiverText = db.createTextField();
        receiverText.setBounds(300, 70, 130, 20);

        JLabel amountLabel = db.createLabel("Enter Amount:");
        amountLabel.setBounds(120, 100, 130, 20);
        JTextField amountText = db.createTextField();
        amountText.setBounds(300, 100, 130, 20);

        JButton confirmButton = db.createJButton("Confirm");
        confirmButton.setBounds(220, 140, 130, 30);
        confirmButton.setBorder(BorderFactory.createEtchedBorder());

        db.greyPanel.add(senderLabel);
        db.greyPanel.add(senderText);
        db.greyPanel.add(receiverLabel);
        db.greyPanel.add(receiverText);
        db.greyPanel.add(amountLabel);
        db.greyPanel.add(amountText);
        db.greyPanel.add(confirmButton);

        db.setVisible(true);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int money = Integer.parseInt(amountText.getText());
                if (!(senderText.getText().isEmpty() && amountText.getText().isEmpty()&&receiverText.getText().isEmpty())) {
                    accountDao.performTransaction(Integer.parseInt(senderText.getText()),Integer.parseInt(receiverText.getText()),Integer.parseInt(amountText.getText()));
                    LocalDate currentDate = LocalDate.now();
                    LocalTime currentTime = LocalTime.now();
                    senderText.setBorder(BorderFactory.createLineBorder(Color.green));
                    receiverText.setBorder(BorderFactory.createLineBorder(Color.green));
                    amountText.setBorder(BorderFactory.createLineBorder(Color.green));
                    JTextArea message = new JTextArea("Transaction Confirmation\n" +
                            "\n" +
                            "Transaction Details:\n" +
                            "\n" +
                            "Sender Account Number: " + senderText.getText() + "\n" +
                            "Recipient Account Number: " + receiverText.getText() + "\n" +
                            "Transaction Date: " + currentDate + "\n" +
                            "Transaction Time: " + currentTime + "\n" +
                            "Transact Amount: " + money + "\n" +
                            "Current Balance: " + accountDao.getAccountBalance(Integer.parseInt(senderText.getText())));
                    message.setBounds(480, 40, 300, 200);
                    message.setEditable(false);
                    message.setLineWrap(true);
                    message.setBackground(new Color(102, 153, 204));
                    message.setForeground(Color.white);
                    Font font = new Font("Arial", Font.BOLD, 13);
                    message.setFont(font);
                    db.greyPanel.add(message);
                    JTextArea message2 = new JTextArea("Thank you for using our online banking services. " +
                            "Your Transaction of " + money + " has been successfully debited from your account. " +
                            "If you have any questions or require further assistance, please don't hesitate to " +
                            "contact our customer support.\n\n" +
                            "Regards,\n" +
                            "ATLAS BANK");
                    message2.setBounds(20, 300, 550, 220);
                    message2.setEditable(false);
                    message2.setLineWrap(true);
                    message2.setBackground(new Color(102, 153, 204));
                    message2.setForeground(Color.white);
                    Font font3 = new Font("Arial", Font.ITALIC, 13);
                    message2.setFont(font3);
                    db.greyPanel.add(message2);
                    db.setVisible(true);
                }
                else {
                    senderText.setBorder(BorderFactory.createLineBorder(Color.red));
                    receiverText.setBorder(BorderFactory.createLineBorder(Color.red));
                    amountText.setBorder(BorderFactory.createLineBorder(Color.red));
                }
                confirmButton.setEnabled(false);
            }
        });
        db.setVisible(true);

    }

    public void PayBill(){
        DialogBox db = new DialogBox();
        JLabel amount_To_be_withdrawn = db.createLabel("Enter Bill Amount:");
        amount_To_be_withdrawn.setBounds(120, 40, 130, 20);
        JTextField amounttext = db.createTextField();
        amounttext.setBounds(300, 40, 130, 20);
        JLabel Id = db.createLabel("Enter Account ID:");
        Id.setBounds(120, 80, 130, 20);
        JTextField ID = db.createTextField();
        ID.setBounds(300, 80, 130, 20);
        JButton button1 = db.createJButton("Pay Bill");
        button1.setBounds(220, 130, 130, 30);
        button1.setBorder(BorderFactory.createEtchedBorder());
        db.greyPanel.add(amount_To_be_withdrawn);
        db.greyPanel.add(amounttext);
        db.greyPanel.add(Id);
        db.greyPanel.add(ID);
        db.greyPanel.add(button1);
        db.setVisible(true);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(ID.getText().isEmpty() && amounttext.getText().isEmpty())) {
                    double currentBalance = accountDao.getAccountBalance(Integer.parseInt(ID.getText()));
                    double  withdrawAmount= Double.parseDouble(amounttext.getText());

                    if (currentBalance >= withdrawAmount) {

                        double newbalance = currentBalance-withdrawAmount;
                        accountDao.updateAccountBalance(Integer.parseInt(ID.getText()),newbalance);
                        JTextArea message = new JTextArea("Payment Confirmation\n" +
                                "\n" +
                                "Transaction Details:\n" +
                                "\n" +
                                "Account Number: " + ID.getText() + "\n" +
                                "Transaction Date: " + currentDate + "\n" +
                                "Transaction Time: " + currentTime + "\n" +
                                "Payment Amount: " + withdrawAmount + "\n" +
                                "Current Balance: " + newbalance);
                        message.setBounds(20, 180, 550, 150);
                        message.setEditable(false);
                        message.setLineWrap(true);
                        message.setBackground(new Color(102, 153, 204));
                        message.setForeground(Color.white);
                        Font font = new Font("Arial", Font.BOLD, 13);
                        message.setFont(font);
                        db.greyPanel.add(message);

                        JTextArea message2 = new JTextArea("Thank you for using our online banking services. " +
                                "Your withdrawal of " + withdrawAmount + " has been successfully debited from your account. " +
                                "If you have any questions or require further assistance, please don't hesitate to " +
                                "contact our customer support.\n\n" +
                                "Regards,\n" +
                                "ATLAS BANK");
                        message2.setBounds(20, 360, 550, 220);
                        message2.setEditable(false);
                        message2.setLineWrap(true);
                        message2.setBackground(new Color(102, 153, 204));
                        message2.setForeground(Color.white);
                        Font font3 = new Font("Arial", Font.ITALIC, 13);
                        message2.setFont(font3);
                        db.greyPanel.add(message2);

                        db.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(db, "Insufficient balance in the account.",
                                "Payment Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    ID.setBorder(BorderFactory.createLineBorder(Color.red));
                    amounttext.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });
    }

    public static void main(String[] args) {

    }
}
