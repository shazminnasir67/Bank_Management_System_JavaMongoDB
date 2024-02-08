package bank_management_system.CustomerModule;

import bank_management_system.Components.FButton;
import bank_management_system.Components.GradientPanel;
import bank_management_system.Dao.CustomerDao;
import bank_management_system.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUISignIn extends JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private JLabel signinLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton signinButton;
    private JSeparator separator1;
    private  JSeparator separator2;
    private JButton forgetpassword;
    private Customer cust;
    public GUISignIn() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sign IN");

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1000, 500));

        bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0, 0, 0));
        bluePanel.setBounds(0, 0, 400, 500);
        bluePanel.setLayout(null);
        mainPanel.add(bluePanel);

        FButton signUpButton = new FButton();
        signUpButton.setBounds(50,400,300,60);
        signUpButton.setFillOriginal(Color.BLACK);
        signUpButton.setForeground(Color.white);
        signUpButton.setFillOver(new Color(78, 79, 235));
        signUpButton.setText("Create New Account");
        bluePanel.add(signUpButton);

        FButton Back = new FButton();
        Back.setBounds(20,20,100,40);
        Back.setFillOriginal(Color.BLACK);
        Back.setForeground(Color.white);
        Back.setFillOver(new Color(78, 79, 235));
        Back.setText("Back");
        bluePanel.add(Back);

        GradientPanel greyPanel = new GradientPanel(new Color(215, 187, 245),new Color(78, 79, 235)); // Using the custom gradient panel
        greyPanel.setBounds(400, 0, 600, 500);  // Updated bounds to remove the gap
        greyPanel.setLayout(null);

        mainPanel.add(greyPanel);

        signinLabel = new JLabel("Sign In Account");
        signinLabel.setForeground(Color.WHITE);
        signinLabel.setFont(new Font("Arial", Font.BOLD, 28));
        signinLabel.setBounds(0, 80, 600, 40);
        signinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greyPanel.add(signinLabel);

        JLabel iconLabel = new JLabel(new ImageIcon("src/bank_management_system/Icons/Blue Modern Up Chart Illustration Investment Company Logo.png")); // Replace with the actual path to your icon
        iconLabel.setBounds(0, 50, 400, 400); // Set the position and size of the icon label
        bluePanel.add(iconLabel);

        usernameLabel = createLabel("Username:");
        usernameLabel.setBounds(50, 180, 200, 30);
        greyPanel.add(usernameLabel);

        JTextField usernameTextField = createTextField();
        usernameTextField.setOpaque(false); // Make the text field
        usernameTextField.setBackground(new Color(215, 187, 245));
        usernameTextField.setBounds(240, 180, 200, 30);
        greyPanel.add(usernameTextField);

        separator1 = createSeparator();
        separator1.setBounds(50, 220, 410, 10);
        greyPanel.add(separator1);

        passwordLabel = createLabel(" Password:");
        passwordLabel.setBounds(50, 250, 200, 30);
        greyPanel.add(passwordLabel);

        JPasswordField passwordField = createPasswordField();
        passwordField.setOpaque(false);
       // passwordField.setBackground(new Color(215, 187, 245));
        passwordField.setBounds(240, 250, 200, 30);
        greyPanel.add(passwordField);
        separator2 = createSeparator();
        separator2.setBounds(50, 280, 410, 10);
        greyPanel.add(separator2);

        forgetpassword = new JButton("Did you Forget Your Password?");
        forgetpassword.setBounds(50,300,210,20);
        forgetpassword.setOpaque(false);
        forgetpassword.setForeground(Color.BLACK);
        forgetpassword.setFont(new Font("Arial", Font.ITALIC, 14));
       forgetpassword.setBackground(new Color(215, 187, 245));
        forgetpassword.setBorder(null);
        greyPanel.add(forgetpassword);

        signinButton = new JButton("Sign In");
        signinButton.setBounds(230, 350, 120, 30);
        signinButton.setForeground(Color.white);
        signinButton.setBackground(new Color(0, 0, 0));
        signinButton.setBorder(BorderFactory.createEtchedBorder());
        greyPanel.add(signinButton);


        CustomerDao customer = new CustomerDao();
        cust = new Customer();
        cust.setUsername(usernameTextField.getText());



        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                cust = new Customer();
                cust.setUsername(username);
                Boolean found1 = customer.authenticateUser(username,password);
                //System.out.println(found);
                if (found1) {
                    usernameTextField.setBorder(BorderFactory.createLineBorder(Color.green));
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.green));
                    JOptionPane.showMessageDialog(null, "You are signed up successfully");
                    SwingUtilities.invokeLater(() -> {
                        Dashboard db = new Dashboard(cust);
                        db.setVisible(true);

                    });
                } else {
                    usernameTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
                }


            }
        });



        forgetpassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField Cnic = new JTextField();
                JTextField Email = new JTextField();
                Object[] message = {
                        "CNIC:", Cnic,
                        "Email Id:", Email
                };

                int option = JOptionPane.showConfirmDialog(null,message,"Please Enter Your CNIC",JOptionPane.OK_CANCEL_OPTION);
                if (option==JOptionPane.OK_OPTION){
                    boolean found = customer.forgotPassword(Cnic.getText(),Email.getText());
                    if (found){
                           // JOptionPane.showMessageDialog(null,"You are signed up successfully");
                            JTextField createpass = new JTextField();
                            JTextField confirmpass = new JTextField();
                            Object[] message1 = {
                                    "Create new password :", createpass,
                                    "Confirm password :", confirmpass
                            };

                            int option1 = JOptionPane.showConfirmDialog(null,message1,"Enter new password",JOptionPane.OK_CANCEL_OPTION);
                            if (option1==JOptionPane.OK_OPTION){
                                if (createpass.getText().equals(confirmpass.getText())){
                                    Boolean b = customer.updatePasswordByCNIC(Cnic.getText(),confirmpass.getText());
                                    if (b){
                                        JOptionPane.showMessageDialog(null,"Password is Updated Successfully you can try your new password !");
                                    }else {
                                        JOptionPane.showMessageDialog(null,"Error your Password is not updated!");
                                    }

                                }
                            }

                        }
                    }

                }

        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                SignUpScreen c = new SignUpScreen();
                c.setVisible(true);
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
               MainScreen mm = new MainScreen();
               mm.setVisible(true);
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

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
//        textField.setBackground(new Color(230, 230, 250));
        textField.setBorder(null);
        return textField;
    }

    private JPasswordField createPasswordField() {
        JPasswordField passwordField = new JPasswordField();
//        passwordField.setBackground(new Color(230, 230, 250));
        passwordField.setBorder(null);
        return passwordField;
    }

    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(0, 0, 0));
        return separator;
    }

    public static void main(String[] args) {
        GUISignIn gui = new GUISignIn();
        gui.setVisible(true);
        System.out.println((int)40.0);
    }
}
