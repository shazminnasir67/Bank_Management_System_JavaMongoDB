package bank_management_system.CustomerModule;
import bank_management_system.Components.DialogBox;
import bank_management_system.Components.FButton;
import bank_management_system.Components.GradientPanel;
import bank_management_system.Dao.CustomerDao;
import bank_management_system.MainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JFrame{
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JTable table;
    private DefaultTableModel tableModel;
    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAccountno() {
        return Accountno;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getAddress() {
        return Address;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassoword() {
        return Passoword;
    }

    public String getEmail() {
        return Email;
    }

    private String FirstName;
    private String LastName;
    private String Accountno;
    private String CNIC;
    private String PhoneNo;
    private String Address;
    private Customer customer;

    public double getbalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAccountno(String accountno) {
        Accountno = accountno;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;
    private String fileName;
    GradientPanel greyPanel;

    public void setPassoword(String passoword) {
        Passoword = passoword;
    }

    private String Passoword;
    private String Email;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public Profile(Customer customer) {
        this.customer = customer;
        initComponents();
    }
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setTitle("xyz");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 700));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0, 0, 0));
        bluePanel.setBounds(0, 0, 200, 700);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);

        greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235)); // Using the custom gradient panel
        greyPanel.setBounds(200, 0, 1060, 650);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);
        add(mainPanel);

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

        FButton Viewpersonal = new FButton();
        Viewpersonal.setBounds(200,100,200,40);
        Viewpersonal.setFillOriginal(Color.BLACK);
        Viewpersonal.setForeground(Color.white);
        Viewpersonal.setFillOver(new Color(78, 79, 235));
        Viewpersonal.setText("View Personal Information");
        greyPanel.add(Viewpersonal);

        FButton updatepersonalinformation = new FButton();
        updatepersonalinformation.setBounds(500,100,200,40);
        updatepersonalinformation.setFillOriginal(Color.BLACK);
        updatepersonalinformation.setForeground(Color.white);
        updatepersonalinformation.setFillOver(new Color(78, 79, 235));
        updatepersonalinformation.setText("Update Personal Information");
        greyPanel.add(updatepersonalinformation);

        updatepersonalinformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                UpdateAccount();
            }
        });
        Viewpersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                ViewPersonalInformation();
            }
        });
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
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard acc = new Dashboard(customer);
                acc.setVisible(true);
            }
        });


        mainPanel.add(bluePanel);

        pack();

        setLocationRelativeTo(null);

    }
    CustomerDao customerDao = new CustomerDao();
    public void ViewPersonalInformation(){

        JLabel ID = new JLabel("Enter ID :");
        ID.setBounds(120,200,130,20);
        JTextField idfield = new JTextField();
        idfield.setBounds(300,200,130,20);
        FButton button1 = new FButton();
        button1.setBounds(300,230,100,40);
        button1.setFillOriginal(Color.BLACK);
        button1.setForeground(Color.white);
        button1.setFillOver(new Color(78, 79, 235));
        button1.setText("Submit");
        greyPanel.add(button1);

        String[] columnNames = {"Account ID", "First Name", "Last Name", "CNIC","Email-Id","Contact no","Account Balance","Username"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setAutoCreateColumnsFromModel(true);
        table.setShowGrid(true);
        table.setBounds(10,250,870,80);
        table.setForeground(Color.black);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 380, 870, 80);
        scrollPane.setBackground(Color.black);

        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLACK); // Change header background color
        header.setForeground(Color.WHITE);


        //scrollPane.setBackground(new Color(102,153,204));

        greyPanel.add(ID);
        greyPanel.add(idfield);
        greyPanel.add(button1);
        greyPanel.add(scrollPane);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(idfield.getText().isEmpty())){
                Customer  customer= customerDao.searchCustomerByCustomerID(Integer.parseInt(idfield.getText()));


                String[] data = {String.valueOf(customer.getAccountno()),customer.getFirstName(),customer.getLastName(),customer.getCNIC(),
                     customer.getEmail(),customer.getPhoneNo(),customer.getUsername()};
                      tableModel.addRow(data);

                }else {
                    idfield.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });



    }
    public void UpdateAccount(){
        //dialog Box
        DialogBox db = new DialogBox();
        db.setSize(900,600);
        db.greyPanel.setBounds(0,100,900,500);
        db.bluePanel.setBounds(0,0,900,100);
        db.setTitle("Update Information");
        JLabel ID = db.createLabel("Enter Account ID :");
        ID.setBounds(120,40,130,20);
        JTextField idfield = db.createTextField();
        idfield.setBounds(300,40,130,20);

        JLabel CNIC = db.createLabel("Enter CNIC:");
        CNIC.setBounds(120, 80, 130, 20);
        JTextField cnicField = db.createTextField();
        cnicField.setBounds(300, 80, 130, 20);

        JLabel current = db.createLabel("Enter current:");
        current.setBounds(330, 180, 130, 20);
        JTextField currentField = db.createTextField();
        currentField.setBounds(430, 180, 130, 20);

        JLabel neW = db.createLabel("Enter new :");
        neW.setBounds(330, 240, 130, 20);
        JTextField newField = db.createTextField();
        newField.setBounds(430, 240, 130, 20);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"First name", "Phone number", "Username", "Password"});
        comboBox.setBounds(100, 180, 200, 30);
        comboBox.setForeground(Color.white);
        comboBox.setBackground(new Color(15,86,186));
        comboBox.setEditable(false);

        JButton button1 = db.createJButton("Update");
        button1.setBounds(440,340,130,30);
        button1.setBorder(BorderFactory.createEtchedBorder());

        db.greyPanel.add(ID);
        db.greyPanel.add(idfield);
        db.greyPanel.add(cnicField);
        db.greyPanel.add(CNIC);
        db.greyPanel.add(button1);
        db.greyPanel.add(comboBox);
        db.greyPanel.add(current);
        db.greyPanel.add(currentField);
        db.greyPanel.add(neW);
        db.greyPanel.add(newField);
        db.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(idfield.getText().isEmpty()&&cnicField.getText().isEmpty()&&newField.getText().isEmpty()&&currentField.getText().isEmpty())){
                    if (e.getSource()==button1 ){
                        String msg = comboBox.getItemAt(comboBox.getSelectedIndex());
                        if (msg=="First Name"){
                            customerDao.updateCustomerInfo(1,newField.getText(), idfield.getText(), cnicField.getText());
                        }if (msg=="Username"){
                            customerDao.updateCustomerInfo(2,newField.getText(), idfield.getText(), cnicField.getText());
                        } else if (msg == "Phone number") {
                            customerDao.updateCustomerInfo(3,newField.getText(), idfield.getText(), cnicField.getText());
                        }else {
                            customerDao.updateCustomerInfo(4,newField.getText(), idfield.getText(), cnicField.getText());
                        }
                    }

                }
                else{
                    idfield.setBorder(BorderFactory.createLineBorder(Color.red));
                    cnicField.setBorder(BorderFactory.createLineBorder(Color.red));
                    currentField.setBorder(BorderFactory.createLineBorder(Color.red));
                    newField.setBorder(BorderFactory.createLineBorder(Color.red));
                }
            }
        });
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
    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255,255,255));
        return separator;
    }
    public static void main(String[] args) {
    }
    }
