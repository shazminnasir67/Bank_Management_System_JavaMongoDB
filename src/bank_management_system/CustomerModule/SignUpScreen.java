package bank_management_system.CustomerModule;

import bank_management_system.Components.FButton;
import bank_management_system.Components.GradientPanel;
import bank_management_system.Dao.AccountDao;
import bank_management_system.Dao.CustomerDao;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JPanel greyPanel;
    private JLabel signUpLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel usernameLabel;
    private JLabel cnicLabel;
    private JLabel phoneLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel addressLabel;
    private JLabel genderLabel;
    private JLabel dob;
    private JLabel emailLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton signUpButton;
    private JButton ClearButton;
    private JSeparator separator1;
    private JSeparator separator2;
    private JSeparator separator3;
    private JSeparator separator4;
    private JSeparator separator5;
    private JSeparator separator6;
    private JSeparator separator7;
    private JSeparator separator8;
    private JSeparator separator9;

    public SignUpScreen() {
        initComponents();


    }

    public static boolean StringValidation(String password) {
        boolean valid = false;
        int numofletter = 0;
        int numofdigit = 0;
        if (password.length() <= 25) {
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (Character.isLetter(ch) || Character.isDigit(ch) || password.contains("@") || password.contains(".")) {
                    if (Character.isDigit(ch)) {
                        numofdigit++;

                    } else {
                        numofletter++;

                    }
                } else {
                    System.out.println("Donot contains letters or digits only ");
                    break;
                }
            }
        } else {
            System.out.println(" Length is not valid ");
        }
        if (numofdigit >= 2 && numofletter >= 4) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    private boolean validateInput(String text, int option) {
        boolean check = true;
        String inputText = text;
        switch (option) {
            case 1:
                String regexPattern = ".*\\d.*";
                // Create the Pattern object
                Pattern pattern = Pattern.compile(regexPattern);
                // Create the Matcher object
                Matcher matcher = pattern.matcher(inputText);
                // Check if the input text matches the pattern
                if (matcher.find()) {
                    check = true;
                }
                break;
        }

        return check;
    }

    private boolean isValidName(String name) {
        if (name.isEmpty()) {
            return false; // Empty name is invalid
        } else {
            int l = 0;
            try {
                while (l != name.length()) {
                    char c = name.charAt(l);
                    if (Character.isAlphabetic(c)) {

                    } else {
                        return false;
                    }
                    l++;
                }
            } catch (NumberFormatException e) {
            }

        }

        // Regular expression pattern for alphabetic characters or spaces
        String regexPattern = "^[a-zA-Z ]+$";

        return name.matches(regexPattern);
    }

    private boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            return false; // Empty email is invalid
        } else {
            int numofletter = 0;
            int numofdigit = 0;
            for (int i = 0; i < email.length(); i++) {
                char ch = email.charAt(i);
                if (email.length() <= 25 && (Character.isLetter(ch) || Character.isDigit(ch) || email.contains("@") || email.contains(".")) && email.contains("@") && email.endsWith(".com")) {
                    if (Character.isDigit(ch)) {
                        numofdigit++;
                    } else {
                        numofletter++;
                    }
                } else {
                    return false;
                }
            }
            if (numofdigit >= 2 && numofletter >= 4) {
                return true;
            } else {
                return false;
            }

        }
    }

    private boolean isValidPassword(String password, String newpass) {
        boolean valid = false;
        if (password.isEmpty() || newpass.isEmpty()) {
            valid = false;
        }
        int x = password.length();
        if ((x >= 8 && x < 20) && (newpass.equals(password))) {
            valid = true;
        }

        return valid;
    }

    private boolean isValidPhoneno(String mobilenumber) {
        boolean valid = false;
        if (mobilenumber.isEmpty()) {
            valid = false;
        } else {
            int i = 0;
            while (mobilenumber.length() == 11 && i != mobilenumber.length()) {
                System.out.println(mobilenumber.length());
                char x = mobilenumber.charAt(i);
                if (!(Character.isDigit(x))) {
                    valid = false;
                    break;
                } else {
                    valid = true;
                }
                i++;

            }
        }
        return valid;
    }

    private boolean isValidCnic(String cnic) {
        boolean valid = false;
        int i = 0;
        while (cnic.length() == 13 && i != cnic.length()) {
            System.out.println(i);
            char x = cnic.charAt(i);
            if (!(Character.isDigit(x))) {
                valid = false;
                break;
            } else {
                valid = true;
            }
            i++;

        }
        return valid;
    }

    //Adding details to the list /excel sheet
    public static int newAccountNumber =0;


    private void initComponents() {
                setTitle("Sign Up");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1160, 650));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0,0 , 0));
        bluePanel.setBounds(0, 0, 400, 650);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);
        JLabel iconLabel = new JLabel(new ImageIcon("src/bank_management_system/Icons/Blue Modern Up Chart Illustration Investment Company Logo.png")); // Replace with the actual path to your icon
        iconLabel.setBounds(0, 100, 400, 400); // Set the position and size of the icon label
        bluePanel.add(iconLabel);

        FButton Back = new FButton();
        Back.setBounds(20,20,100,40);
        Back.setFillOriginal(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setFillOver(new Color(78, 79, 235));
        Back.setText("Back");
        bluePanel.add(Back);

        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235));
        greyPanel.setBounds(400, 0, 760, 650);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);
        mainPanel.add(greyPanel);

        signUpLabel = new JLabel("Sign Up Account");
        signUpLabel.setForeground(Color.WHITE);
        signUpLabel.setFont(new Font("Arial", Font.BOLD, 28));
        signUpLabel.setBounds(0, 20, 650, 40);
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greyPanel.add(signUpLabel);

        firstNameLabel = createLabel("First Name:");
        firstNameLabel.setBounds(50, 80, 200, 30);
        greyPanel.add(firstNameLabel);

        JTextField firstNameTextField = createTextField();
        String name = firstNameTextField.getText();
        firstNameTextField.setBounds(260, 80, 300, 30);
        greyPanel.add(firstNameTextField);


        lastNameLabel = createLabel("Last Name:");
        lastNameLabel.setBounds(50, 130, 200, 30);
        greyPanel.add(lastNameLabel);

        JTextField lastNameTextField = createTextField();
        String lastname = lastNameTextField.getText();
        lastNameTextField.setBounds(260, 130, 300, 30);
        greyPanel.add(lastNameTextField);

        usernameLabel = createLabel("Username:");
        usernameLabel.setBounds(50, 180, 200, 30);
        greyPanel.add(usernameLabel);

        JTextField usernameTextField = createTextField();
        String username = usernameTextField.getText();
        usernameTextField.setBounds(160, 180, 150, 30);
        greyPanel.add(usernameTextField);


        dob = createLabel("Date of Birth: ");
        dob.setBounds(330,180,200,30);
        greyPanel.add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1940);
        dateChooser.getJCalendar().setMinSelectableDate(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR, 2005);
        dateChooser.getJCalendar().setMaxSelectableDate(calendar2.getTime());

        dateChooser.setBounds(430,180,150,24);
        greyPanel.add(dateChooser);

        cnicLabel = createLabel("CNIC:");
        cnicLabel.setBounds(50, 230, 200, 30);
        greyPanel.add(cnicLabel);

        JTextField cnicTextField = createTextField();
        cnicTextField.setBounds(260, 230, 300, 30);
        greyPanel.add(cnicTextField);

        phoneLabel = createLabel("Phone No:");

        phoneLabel.setBounds(50, 280, 200, 30);
        greyPanel.add(phoneLabel);

        JTextField phoneTextField = createTextField();
        phoneTextField.setBounds(260, 280, 300, 30);
        greyPanel.add(phoneTextField);

        passwordLabel = createLabel("Create Password:");
        passwordLabel.setBounds(50, 330, 200, 30);
        greyPanel.add(passwordLabel);

        JPasswordField passwordField = createPasswordField();
        passwordField.setBounds(260, 330, 300, 30);
        greyPanel.add(passwordField);

        confirmPasswordLabel = createLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(50, 380, 200, 30);
        greyPanel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = createPasswordField();
        confirmPasswordField.setBounds(260, 380, 300, 30);
        greyPanel.add(confirmPasswordField);

        emailLabel = createLabel("Email Id:");
        emailLabel.setBounds(50, 430, 200, 30);
        greyPanel.add(emailLabel);

        JTextField emailTextField = createTextField();
        emailTextField.setBounds(260, 430, 300, 30);
        greyPanel.add(emailTextField);

        addressLabel = createLabel("Account Type :");
        addressLabel.setBounds(50, 480, 200, 30);
        greyPanel.add(addressLabel);

        JComboBox<String> accountTypeComboBox = new JComboBox<>(new Vector<>(List.of("Savings Account", "Checking Account", "Credit Card Account")));
        accountTypeComboBox.setBounds(260, 480, 300, 30);
        accountTypeComboBox.setOpaque(false);
        accountTypeComboBox.setBackground(Color.black);
        accountTypeComboBox.setForeground(Color.white);
        greyPanel.add(accountTypeComboBox);

        genderLabel = createLabel("Gender:");
        genderLabel.setBounds(50, 530, 200, 30);
        genderLabel.setForeground(Color.WHITE);
        greyPanel.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setForeground(Color.WHITE);
        maleRadioButton.setOpaque(false);
        maleRadioButton.setBounds(260, 530, 80, 30);
        greyPanel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setForeground(Color.WHITE);
        femaleRadioButton.setOpaque(false);
        femaleRadioButton.setBounds(350, 530, 100, 30);
        greyPanel.add(femaleRadioButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        String selectedGender = null;

        if (maleRadioButton.isSelected()) {
            selectedGender = maleRadioButton.getText();
        } else if (femaleRadioButton.isSelected()) {
            selectedGender = femaleRadioButton.getText();
        }


        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(160, 580, 120, 30);
        signUpButton.setBackground(new Color(0,0,0));
        signUpButton.setForeground(Color.white);
        signUpButton.setBorder(BorderFactory.createEtchedBorder());
        greyPanel.add(signUpButton);

        ClearButton = new JButton("Clear");
        ClearButton.setBackground(new Color(0,0,0));
        ClearButton.setForeground(Color.white);
        ClearButton.setBounds(360,580,120,30);
        greyPanel.add(ClearButton);

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameTextField.setText(null);
                lastNameTextField.setText(null);
                passwordField.setText(null);
                confirmPasswordField.setText(null);
                usernameTextField.setText(null);
                phoneTextField.setText(null);
                cnicTextField.setText(null);
                dateChooser.setDate(null);
            }
        });

        String finalSelectedGender = selectedGender;
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform signup action here
                boolean isname  = isValidName(firstNameTextField.getText());
                boolean islname = isValidName(lastNameTextField.getText());
                boolean isemail = isValidEmail(emailTextField.getText());
                boolean iscnic = isValidCnic(cnicTextField.getText());
                boolean isphoneno = isValidPhoneno(phoneTextField.getText());
                newAccountNumber =  (int) ((Math.random() * (99999 - 11111)) + 11111);
                CardNumberGenerator cardno = new CardNumberGenerator();
                CustomerIDGenerator cust = new CustomerIDGenerator();
                int CUST = cust.generateCustomerID();
                boolean ispassword = isValidPassword(new String(passwordField.getPassword()),new String(confirmPasswordField.getPassword()));
                if(isname || isemail||iscnic||ispassword||isphoneno){
                    if (!isemail){
                        emailTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                    }else {
                        emailTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                    if ((!iscnic)) {
                        cnicTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                    } else {
                        cnicTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                    if ((!isphoneno)) {
                        phoneTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                    } else {
                        phoneTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                    if (!isname){
                        firstNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    }else {
                        firstNameTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                    if (!islname){
                        lastNameTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    }else {
                        lastNameTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                    if (!ispassword){
                        passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                        confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    }else {
                        passwordField.setBorder(BorderFactory.createLineBorder(Color.green));
                        confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.green));
                    }
                }
                if (isname && isemail&&iscnic&&ispassword&&isphoneno){
                    double balance = 0.0;
                    //createAccount(firstNameTextField.getText(), lastNameTextField.getText(),cnicTextField.getText(),phoneTextField.getText(),usernameTextField.getText(),emailTextField.getText(),String.valueOf(passwordField.getPassword()));
                    JOptionPane.showMessageDialog(null,"Sign Up Successfully");
                    Customer c = new Customer();
                    c.setGender(finalSelectedGender);
                    c.setPassoword(String.valueOf(passwordField.getPassword()));
                    c.setCUSTID(CUST);
                    c.setPhoneNo(phoneTextField.getText());
                    c.setAccountno(newAccountNumber);
                    c.setCNIC(cnicTextField.getText());
                    c.setLastName(lastNameTextField.getText());
                    c.setAccountType((String) accountTypeComboBox.getSelectedItem());
                    c.setFirstName(firstNameTextField.getText());
                    c.setUsername(usernameTextField.getText());
                    c.setEmail(emailTextField.getText());

                    CustomerDao customer =  new CustomerDao();
                    try {
                        System.out.println(customer.createCustomer(c));
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    Account acc = new Account();
                    acc.setAccountId(newAccountNumber);
                    acc.setFirstName(firstNameTextField.getText());
                    acc.setLastName(lastNameTextField.getText());
                    acc.setBalance(balance);
                    acc.setCardNumber(cardno.generateCardNumber());
                    acc.setAccounttype((String) accountTypeComboBox.getSelectedItem());
                    acc.setCustid(CUST);
                    AccountDao account = new AccountDao();
                    System.out.println(account.createAccount(acc)+"Account Created!");
                    SwingUtilities.invokeLater(() -> {
                        GUISignIn signIn = new GUISignIn();
                        signIn.setVisible(true);

                    });

                }


            }
        });

        separator1 = createSeparator();
        separator1.setBounds(50, 110, 510, 10);
        greyPanel.add(separator1);

        separator2 = createSeparator();
        separator2.setBounds(50, 160, 510, 10);
        greyPanel.add(separator2);

        separator3 = createSeparator();
        separator3.setBounds(50, 210, 510, 10);
        greyPanel.add(separator3);

        separator4 = createSeparator();
        separator4.setBounds(50, 260, 510, 10);
        greyPanel.add(separator4);

        separator5 = createSeparator();
        separator5.setBounds(50, 310, 510, 10);
        greyPanel.add(separator5);

        separator6 = createSeparator();
        separator6.setBounds(50, 360, 510, 10);
        greyPanel.add(separator6);

        separator7 = createSeparator();
        separator7.setBounds(50, 410, 510, 10);
        greyPanel.add(separator7);

        separator8 = createSeparator();
        separator8.setBounds(50, 460, 510, 10);
        greyPanel.add(separator8);

        separator9 = createSeparator();
        separator9.setBounds(50, 510, 510, 10);
        greyPanel.add(separator9);



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

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setOpaque(false);
        textField.setBorder(null);
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        return passwordField;
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(255, 255, 255));
        return separator;
    }

    public static void main(String[] args) {

    }
}
