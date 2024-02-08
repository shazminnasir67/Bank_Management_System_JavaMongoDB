
package bank_management_system.Manager;

import bank_management_system.Components.*;
import bank_management_system.CustomerModule.GUISignIn;
import bank_management_system.CustomerModule.SignUpScreen;
import bank_management_system.Dao.*;
import bank_management_system.MainScreen;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author HOME
 */
public class AdminMain extends javax.swing.JFrame {
    private JPanel mainPanel;
    private JPanel bluePanel;
    private CustomerDao customerDao = new CustomerDao();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private AccountDao accountDao = new AccountDao();
    private LoanDao loanDao = new LoanDao();
    private TransactionDao transactionDao = new TransactionDao();
    /**
     * Creates new form AdminMain
     */
    public AdminMain() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jSeparator1 = new JSeparator();
        jButton2 = new JButton();
        jSeparator2 = new JSeparator();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jSeparator3 = new JSeparator();
        jSeparator4 = new JSeparator();
        jSeparator5 = new JSeparator();
        jSeparator6 = new JSeparator();
        jSeparator7 = new JSeparator();
        JTab = new JTabbedPane();
        jPanel2 = new JPanel();
        roundPanel1 = new RoundPanel();
        progress1 = new Progress();
        progress2 = new Progress();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        roundPanel2 = new RoundPanel();
        lineChart1 = new LineChart();
        roundPanel3 = new RoundPanel();
        chart1 = new Chart();
        jPanel3 = new JPanel();
        roundPanel5 = new RoundPanel();
        jScrollPane1 = new JScrollPane();
        EmployeeTable = new JTable();
        fButton1 = new FButton();
        AddCustomer = new FButton();
        DeleteCustomer = new FButton();
        label1 = new Label();
        roundPanel8 = new RoundPanel();
        jLabel5 = new JLabel();
        fButton3 = new FButton();
        jComboBox2 = new JComboBox<>();
        jPanel4 = new JPanel();
        roundPanel6 = new RoundPanel();
        jLabel4 = new JLabel();
        fButton2 = new FButton();
        jComboBox1 = new JComboBox<>();
        roundPanel7 = new RoundPanel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        fButton8 = new FButton();
        fButton9 = new FButton();
        fButton10 = new FButton();
        label2 = new Label();
        jPanel5 = new JPanel();
        roundPanel9 = new RoundPanel();
        jLabel6 = new JLabel();
        fButton4 = new FButton();
        jComboBox3 = new JComboBox<>();
        roundPanel10 = new RoundPanel();
        jScrollPane3 = new JScrollPane();
        jTable3 = new JTable();
        fButton11 = new FButton();
        fButton12 = new FButton();
        fButton13 = new FButton();
        label3 = new Label();
        jPanel8 = new JPanel();
        roundPanel11 = new RoundPanel();
        jLabel7 = new JLabel();
        fButton5 = new FButton();
        jComboBox4 = new JComboBox<>();
        roundPanel12 = new RoundPanel();
        jScrollPane4 = new JScrollPane();
        jTable4 = new JTable();
        fButton14 = new FButton();
        fButton15 = new FButton();
        fButton16 = new FButton();
        label4 = new Label();
        jPanel9 = new JPanel();
        roundPanel13 = new RoundPanel();
        lineChart2 = new LineChart();
        roundPanel4 = new RoundPanel();
        chart2 = new Chart();
        roundPanel14 = new RoundPanel();
        progress3 = new Progress();
        progress4 = new Progress();
        progress5 = new Progress();
        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        setMinimumSize(new Dimension(1180, 650));
        setPreferredSize(new Dimension(1180, 680));
        setResizable(false);
        getContentPane().setLayout(new AbsoluteLayout());

        jPanel1.setBackground(new Color(0, 0, 0));
        jPanel1.setLayout(new AbsoluteLayout());

        jButton1.setBackground(new Color(0, 0, 0));
        jButton1.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-dashboard-30.png"))); // NOI18N
        jButton1.setText("Dashboard");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setIconTextGap(6);
        jButton1.setMargin(new Insets(4, 14, 3, 14));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new AbsoluteConstraints(10, 30, 220, 50));

        jSeparator1.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator1, new AbsoluteConstraints(240, 133, 2, 10));

        jButton2.setBackground(new Color(0, 0, 0));
        jButton2.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton2.setForeground(new Color(255, 255, 255));
        jButton2.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-customer-26.png"))); // NOI18N
        jButton2.setText("Customer");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setIconTextGap(6);
        jButton2.setMargin(new Insets(4, 14, 3, 14));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new AbsoluteConstraints(10, 100, 200, 40));

        jSeparator2.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator2, new AbsoluteConstraints(20, 390, 210, 10));

        jButton3.setBackground(new Color(0, 0, 0));
        jButton3.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-employee-30.png"))); // NOI18N
        jButton3.setText("Employee");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setIconTextGap(6);
        jButton3.setMargin(new Insets(4, 14, 3, 14));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new AbsoluteConstraints(10, 160, 190, 40));

        jButton4.setBackground(new Color(0, 0, 0));
        jButton4.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton4.setForeground(new Color(255, 255, 255));
        jButton4.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-loan-30.png"))); // NOI18N
        jButton4.setText(" Loans");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
        jButton4.setIconTextGap(6);
        jButton4.setMargin(new Insets(4, 10, 3, 14));
        jButton4.setName("LoanButton"); // NOI18N
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new AbsoluteConstraints(20, 220, 160, 40));

        jButton5.setBackground(new Color(0, 0, 0));
        jButton5.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton5.setForeground(new Color(255, 255, 255));
        jButton5.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-transactions-30.png"))); // NOI18N
        jButton5.setText("Transactions");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setIconTextGap(6);
        jButton5.setMargin(new Insets(4, 14, 3, 14));
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new AbsoluteConstraints(40, 280, 170, 40));

        jButton6.setBackground(new Color(0, 0, 0));
        jButton6.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton6.setForeground(new Color(255, 255, 255));
        jButton6.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-report-30.png"))); // NOI18N
        jButton6.setText("Report");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setIconTextGap(6);
        jButton6.setMargin(new Insets(4, 14, 3, 14));
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new AbsoluteConstraints(10, 340, 170, 40));

        jButton7.setBackground(new Color(0, 0, 0));
        jButton7.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        jButton7.setForeground(new Color(255, 255, 255));
        jButton7.setIcon(new ImageIcon(getClass().getResource("/bank_management_system/Icons/icons8-logout-30.png"))); // NOI18N
        jButton7.setText("Logout");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new AbsoluteConstraints(20, 590, 200, 35));

        jSeparator3.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator3, new AbsoluteConstraints(20, 270, 210, 11));

        jSeparator4.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator4, new AbsoluteConstraints(20, 330, 210, 11));

        jSeparator5.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator5, new AbsoluteConstraints(20, 210, 210, 11));

        jSeparator6.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator6, new AbsoluteConstraints(20, 150, 210, 11));

        jSeparator7.setBackground(new Color(255, 255, 255));
        jPanel1.add(jSeparator7, new AbsoluteConstraints(20, 90, 210, 11));

        getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 250, 690));

        JTab.setBackground(new Color(255, 255, 255));
        JTab.setName("JTab"); // NOI18N
        JTab.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                JTabStateChanged(evt);
            }
        });

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setLayout(new AbsoluteLayout());

        roundPanel1.setBackground(new Color(51, 51, 51));
        roundPanel1.setLayout(new AbsoluteLayout());
        roundPanel1.add(progress1, new AbsoluteConstraints(30, 70, -1, 130));
        roundPanel1.add(progress2, new AbsoluteConstraints(210, 70, -1, 130));

        jLabel1.setBackground(new Color(51, 51, 51));
        jLabel1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Total Loan Lended");
        roundPanel1.add(jLabel1, new AbsoluteConstraints(230, 30, 140, -1));

        jLabel2.setBackground(new Color(51, 51, 51));
        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Total Bank Accounts");
        roundPanel1.add(jLabel2, new AbsoluteConstraints(30, 30, 140, -1));

        jPanel2.add(roundPanel1, new AbsoluteConstraints(10, 10, 380, 240));

        roundPanel2.setBackground(new Color(51, 51, 51));
        roundPanel2.setLayout(new AbsoluteLayout());
        roundPanel2.add(lineChart1, new AbsoluteConstraints(0, 0, 490, 240));

        jPanel2.add(roundPanel2, new AbsoluteConstraints(397, 10, 510, 240));

        roundPanel3.setBackground(new Color(51, 51, 51));

        GroupLayout roundPanel3Layout = new GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
                roundPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(chart1, GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
                roundPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart1, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(roundPanel3, new AbsoluteConstraints(10, 260, 900, 380));

        JTab.addTab("Dashboard", jPanel2);

        jPanel3.setBackground(new Color(255, 255, 255));
        jPanel3.setFocusCycleRoot(true);
        jPanel3.setLayout(new AbsoluteLayout());

        roundPanel5.setBackground(new Color(204, 204, 255));
        roundPanel5.setLayout(new AbsoluteLayout());

        jScrollPane1.setBackground(new Color(255, 255, 255));

        EmployeeTable.setAutoCreateRowSorter(true);
        EmployeeTable.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "EmpID", "First Name", "Salary", "Email", "Username ", "Password", "Job Title","HireDate"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.setGridColor(new Color(153, 153, 153));
        EmployeeTable.setShowGrid(true);
        EmployeeTable.setRowHeight(30);
        jScrollPane1.setViewportView(EmployeeTable);

        roundPanel5.add(jScrollPane1, new AbsoluteConstraints(10, 170, 870, 250));
        fButton8.setText("Add");
        fButton8.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel5.add(fButton8, new AbsoluteConstraints(620, 10, 80, 40));

        fButton9.setText("Edit");
        fButton9.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel5.add(fButton9, new AbsoluteConstraints(700, 10, 80, 40));

        fButton10.setText("Delete");
        fButton10.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel5.add(fButton10, new AbsoluteConstraints(780, 10, 80, 40));

        fButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = EmployeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    int empID = (int) EmployeeTable.getValueAt(selectedRow, 0);
                    employeeDAO.deleteEmployee(empID);
                }
                JOptionPane.showMessageDialog(new JPanel(),"Employee deleted successfully.");
            }
        });
        roundPanel7.setBackground(new Color(204, 204, 255));
        roundPanel7.setLayout(new AbsoluteLayout());
        EmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        fButton1.setText("Edit");
        fButton1.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel7.add(fButton1, new AbsoluteConstraints(700, 10, 80, 40));
        fButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        employeeDAO.updateCellValue(EmployeeTable);
                    }
                });


            }
        });


        AddCustomer.setText("Add");
        AddCustomer.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel7.add(AddCustomer, new AbsoluteConstraints(620, 10, 80, 40));

        DeleteCustomer.setText("Delete");
        DeleteCustomer.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel7.add(DeleteCustomer, new AbsoluteConstraints(780, 10, 80, 40));

        DeleteCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable2.getSelectedRow();

                if (selectedRow != -1) {
                    int custID = (int) jTable2.getValueAt(selectedRow, 0);
                    customerDao.deleteCustomer(custID);
                }
                JOptionPane.showMessageDialog(new JPanel(),"Customer deleted successfully.");
            }
        });

        label1.setFont(new Font("Ebrima", 1, 24)); // NOI18N
        label1.setText("EMPLOYEE DATA");
        roundPanel5.add(label1, new AbsoluteConstraints(50, 40, 310, 60));

        jPanel3.add(roundPanel5, new AbsoluteConstraints(10, 190, 890, 440));

        roundPanel8.setBackground(new Color(134, 93, 255));
        roundPanel8.setLayout(new AbsoluteLayout());

        jLabel5.setFont(new Font("Ebrima", 1, 18)); // NOI18N
        jLabel5.setText("Enter Employee ");
        roundPanel8.add(jLabel5, new AbsoluteConstraints(80, 70, -1, -1));

        fButton3.setText("Search");
        fButton3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        roundPanel8.add(fButton3, new AbsoluteConstraints(590, 60, 140, 40));
        JTextField emplsearch = new JTextField(" ");
        emplsearch.setBackground(Color.WHITE);
        emplsearch.setBorder(null);
        emplsearch.setFocusable(true);
        emplsearch.setCaretPosition(0);

        roundPanel8.add(emplsearch, new AbsoluteConstraints(350, 70, 150, 30));

        fButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeDAO.searchEmployees(EmployeeTable,jComboBox2.getSelectedIndex(),String.valueOf(emplsearch.getText()));

            }
        });

        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ID", "Name", "User Name", "Last Name", "Job Title" }));
        jComboBox2.setBorder(null);
        roundPanel8.add(jComboBox2, new AbsoluteConstraints(230, 70, 110, 30));

        jPanel3.add(roundPanel8, new AbsoluteConstraints(10, 10, 890, 170));

        JTab.addTab("Employee", jPanel3);

        jPanel4.setBackground(new Color(255, 255, 255));
        jPanel4.setLayout(new AbsoluteLayout());

        roundPanel6.setBackground(new Color(134, 93, 255));
        roundPanel6.setLayout(new AbsoluteLayout());

        jLabel4.setFont(new Font("Ebrima", 1, 18)); // NOI18N
        jLabel4.setText("Enter Customer");
        roundPanel6.add(jLabel4, new AbsoluteConstraints(80, 70, -1, -1));

        fButton2.setText("Search");
        fButton2.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        roundPanel6.add(fButton2, new AbsoluteConstraints(590, 60, 140, 40));

        JTextField custsearch = new JTextField();
        custsearch.setBackground(Color.WHITE);
        custsearch.setBorder(null);
        custsearch.setFocusable(true);
        custsearch.setCaretPosition(0);
        roundPanel6.add(custsearch , new AbsoluteConstraints(350, 70, 150, 30));
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ID", "First Name", "Last Name","User Name" }));
        jComboBox1.setBorder(null);
        jComboBox1.setPreferredSize(new Dimension(90, 16));
        roundPanel6.add(jComboBox1, new AbsoluteConstraints(230, 70, 110, 30));
        fButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerDao.searchCustomers(jTable2,jComboBox1.getSelectedIndex(),String.valueOf(custsearch.getText()));
            }
        });

        jPanel4.add(roundPanel6, new AbsoluteConstraints(10, 10, 890, 170));



        jScrollPane2.setBackground(new Color(255, 255, 255));

        jTable2.setAutoCreateRowSorter(true);

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "CUSTID", "First Name", "Last Name", "Email", "Username ", "Password", "Gender", "CNIC"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, true
            };


        });
        jTable2.setGridColor(new Color(153, 153, 153));
        jTable2.setShowGrid(true);
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);


        roundPanel7.add(jScrollPane2, new AbsoluteConstraints(10, 180, 870, 240));



        label2.setFont(new Font("Ebrima", 1, 24)); // NOI18N
        label2.setText("CUSTOMER DATA ");
        roundPanel7.add(label2, new AbsoluteConstraints(50, 40, 310, 60));

        jPanel4.add(roundPanel7, new AbsoluteConstraints(10, 190, 890, 440));

        JTab.addTab("Customer", jPanel4);

        jPanel5.setBackground(new Color(255, 255, 255));
        jPanel5.setLayout(new AbsoluteLayout());

        roundPanel9.setBackground(new Color(134, 93, 255));
        roundPanel9.setLayout(new AbsoluteLayout());

        jLabel6.setFont(new Font("Ebrima", 1, 18)); // NOI18N
        jLabel6.setText("Enter  Loan");
        roundPanel9.add(jLabel6, new AbsoluteConstraints(120, 70, -1, -1));

        fButton4.setText("Search");
        fButton4.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        roundPanel9.add(fButton4, new AbsoluteConstraints(590, 60, 140, 40));

        JTextField LoanSearch  = new JTextField(" ");
        LoanSearch.setBackground(Color.WHITE);
        LoanSearch.setBorder(null);
        LoanSearch.setCaretPosition(0);

        roundPanel9.add(LoanSearch ,new AbsoluteConstraints(350, 70, 150, 30));

        fButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loanDao.searchLoans(jTable3,jComboBox3.getSelectedIndex(),String.valueOf(LoanSearch.getText()));

            }
        });

        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "ID", "CustID", "AccountID", "Loan Status" }));
        jComboBox3.setBorder(null);
        jComboBox3.setPreferredSize(new Dimension(90, 16));
        roundPanel9.add(jComboBox3, new AbsoluteConstraints(230, 70, 110, 30));

        jPanel5.add(roundPanel9, new AbsoluteConstraints(10, 10, 890, 170));

        roundPanel10.setBackground(new Color(204, 204, 255));
        roundPanel10.setLayout(new AbsoluteLayout());

        jScrollPane3.setBackground(new Color(255, 255, 255));

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "LoanID", "AccountID", "CustID", "Amount", "Interest Rate", "Terms", "Start Date", "End Date", "Status"
                }
        ) {
        });

        jTable3.setGridColor(new Color(153, 153, 153));
        jTable3.setPreferredSize(new Dimension(600, 180));
        jTable3.setShowGrid(true);
        jTable3.setRowHeight(30);
        jScrollPane3.setViewportView(jTable3);

        roundPanel10.add(jScrollPane3, new AbsoluteConstraints(10, 210, 870, 220));

        fButton11.setText("Add");
        fButton11.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel10.add(fButton11, new AbsoluteConstraints(620, 10, 80, 40));

        fButton12.setText("Edit");
        fButton12.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel10.add(fButton12, new AbsoluteConstraints(700, 10, 80, 40));

        fButton13.setText("Delete");
        fButton13.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel10.add(fButton13, new AbsoluteConstraints(780, 10, 80, 40));

        fButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable3.getSelectedRow();

                if (selectedRow != -1) {
                    int loanID = (int) jTable3.getValueAt(selectedRow, 0);
                    loanDao.deleteLoan(loanID);
                }
                JOptionPane.showMessageDialog(new JPanel(),"Loan deleted successfully.");
            }
        });

        label3.setFont(new Font("Ebrima", 1, 24)); // NOI18N
        label3.setText("LOAN DATA");
        roundPanel10.add(label3, new AbsoluteConstraints(50, 40, 310, 60));

        jPanel5.add(roundPanel10, new AbsoluteConstraints(10, 190, 890, 450));

        JTab.addTab("Loans", jPanel5);

        jPanel8.setBackground(new Color(255, 255, 255));
        jPanel8.setLayout(new AbsoluteLayout());

        roundPanel11.setBackground(new Color(134, 93, 255));
        roundPanel11.setLayout(new AbsoluteLayout());

        jLabel7.setFont(new Font("Ebrima", 1, 18)); // NOI18N
        jLabel7.setText("Enter  Transaction");
        roundPanel11.add(jLabel7, new AbsoluteConstraints(70, 70, -1, 30));

        fButton5.setText("Search");
        fButton5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        roundPanel11.add(fButton5, new AbsoluteConstraints(590, 60, 140, 40));
        JTextField transsearch = new JTextField(" ");
        transsearch.setBackground(Color.WHITE);
        transsearch.setBorder(null);
        transsearch.setFocusable(true);
        transsearch.setCaretPosition(0);

        roundPanel11.add(transsearch, new AbsoluteConstraints(350, 70, 150, 30));

        fButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionDao.searchTransactions(jTable4,jComboBox4.getSelectedIndex(),String.valueOf(transsearch.getText()));

            }
        });

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "ID", "Account ID", "Status", "Category" }));
        jComboBox4.setBorder(null);
        jComboBox4.setPreferredSize(new Dimension(90, 16));
        roundPanel11.add(jComboBox4, new AbsoluteConstraints(230, 70, 110, 30));

        jPanel8.add(roundPanel11, new AbsoluteConstraints(10, 10, 890, 170));

        roundPanel12.setBackground(new Color(204, 204, 255));
        roundPanel12.setLayout(new AbsoluteLayout());

        jScrollPane4.setBackground(new Color(255, 255, 255));
        jTable4.setAutoCreateRowSorter(true);
        jTable4.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "TransID", "AccountNo", "Type", "Amount", "Status ", "from", "To", "Date","Category"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, true
            };

        });
        jTable4.setGridColor(new Color(153, 153, 153));
        jTable4.setShowGrid(true);
        jTable4.setRowHeight(30);
        jScrollPane4.setViewportView(jTable4);


        roundPanel12.add(jScrollPane4, new AbsoluteConstraints(10, 170, 870, 260));

        fButton14.setText("Add");
        fButton14.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel12.add(fButton14, new AbsoluteConstraints(620, 10, 80, 40));

        fButton15.setText("Edit");
        fButton15.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel12.add(fButton15, new AbsoluteConstraints(700, 10, 80, 40));

        fButton16.setText("Delete");
        fButton16.setFont(new Font("Segoe UI Emoji", 1, 14)); // NOI18N
        roundPanel12.add(fButton16, new AbsoluteConstraints(780, 10, 80, 40));

        fButton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable4.getSelectedRow();
                if (selectedRow != -1) {
                    int transID = (int) jTable4.getValueAt(selectedRow, 0);
                    transactionDao.deleteTransaction(transID);
                }
                JOptionPane.showMessageDialog(new JPanel(),"Transaction Record deleted successfully.");
            }
        });
        AddCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpScreen singnup = new SignUpScreen();
                singnup.setVisible(true);
                // JOptionPane.showMessageDialog(new JPanel(),"Customer Record added successfully.");
                setLayout(null);
            }
        });

        label4.setFont(new Font("Ebrima", 1, 24)); // NOI18N
        label4.setText("TRANSACTION DATA");
        roundPanel12.add(label4, new AbsoluteConstraints(50, 40, 310, 60));

        jPanel8.add(roundPanel12, new AbsoluteConstraints(10, 190, 890, 450));

        JTab.addTab("Transactions", jPanel8);

        jPanel9.setBackground(new Color(255, 255, 255));
        jPanel9.setLayout(new AbsoluteLayout());

        roundPanel13.setBackground(new Color(51, 51, 51));
        roundPanel13.setLayout(new AbsoluteLayout());
        roundPanel13.add(lineChart2, new AbsoluteConstraints(10, 10, 600, 210));

        jPanel9.add(roundPanel13, new AbsoluteConstraints(10, 10, 620, 260));

        roundPanel4.setBackground(new Color(51, 51, 51));
        roundPanel4.setLayout(new AbsoluteLayout());
        roundPanel4.add(chart2, new AbsoluteConstraints(0, 0, 620, 360));

        jPanel9.add(roundPanel4, new AbsoluteConstraints(10, 280, 620, 360));

        roundPanel14.setBackground(new Color(51, 51, 51));
        roundPanel14.setLayout(new AbsoluteLayout());
        roundPanel14.add(progress3, new AbsoluteConstraints(60, 60, -1, 130));
        roundPanel14.add(progress4, new AbsoluteConstraints(60, 230, -1, 130));
        roundPanel14.add(progress5, new AbsoluteConstraints(60, 400, -1, 130));

        FButton fButton33 = new FButton();
        fButton33.setText("Generate Report");
        fButton33.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        roundPanel14.add(fButton33, new AbsoluteConstraints(60, 560, 150, 40));

        jLabel3.setBackground(new Color(51, 51, 51));
        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Customers with Loan Application");
        jLabel3.setHorizontalTextPosition(SwingConstants.CENTER);
        roundPanel14.add(jLabel3, new AbsoluteConstraints(30, 370, 200, -1));

        jLabel8.setBackground(new Color(51, 51, 51));
        jLabel8.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("Loan Paid");
        jLabel8.setHorizontalTextPosition(SwingConstants.CENTER);
        roundPanel14.add(jLabel8, new AbsoluteConstraints(90, 10, 80, -1));

        jLabel9.setBackground(new Color(51, 51, 51));
        jLabel9.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setText("Loan Amount Pending");
        jLabel9.setHorizontalTextPosition(SwingConstants.CENTER);
        roundPanel14.add(jLabel9, new AbsoluteConstraints(50, 200, 190, -1));


        jPanel9.add(roundPanel14, new AbsoluteConstraints(640, 10, 270, 630));

        JTab.addTab("Report", jPanel9);

        getContentPane().add(JTab, new AbsoluteConstraints(250, -30, 1020, 680));
        JTab.getAccessibleContext().setAccessibleName("JTab");

        progress1.setValue(AccountDao.getAccountCount(null));
        progress2.setValue(LoanDao.countLoanAccounts());
        progress1.setBackground(new Color(78, 79, 235));
        progress2.setBackground(new Color(78, 79, 235));
        progress1.setForeground(new Color(215, 187, 245));
        progress2.setForeground(new Color(215, 187, 245));
        progress1.start();
        progress2.start();

        chart1.addLegend("Saving Acc",new Color(78, 79, 235),new Color(215, 187, 245));
        chart1.addLegend("Current Acc",new Color(11, 102, 106),new Color(151, 254, 237));
        chart1.addLegend("Credit Card Acc",new Color(210, 39, 121),new Color(255, 0, 142));
        AccountDao accountDao1 = new AccountDao();
        chart1.addData(new ModelChart("January", new double[]{accountDao1.getAccountCountByMonthAndType(1,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.addData(new ModelChart("February",  new double[]{accountDao1.getAccountCountByMonthAndType(2,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.addData(new ModelChart("March", new double[]{accountDao1.getAccountCountByMonthAndType(3,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.addData(new ModelChart("April", new double[]{accountDao1.getAccountCountByMonthAndType(4,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.addData(new ModelChart("May", new double[]{accountDao1.getAccountCountByMonthAndType(5,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.addData(new ModelChart("June", new double[]{accountDao1.getAccountCountByMonthAndType(6,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart1.start();

        lineChart1.addLegend("Income", new Color(210, 39, 121),new Color(255, 0, 142));
        lineChart1.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart1.addLegend("Profit", new Color(11, 102, 106),new Color(151, 254, 237));
        lineChart1.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        lineChart1.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        lineChart1.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        lineChart1.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        lineChart1.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        lineChart1.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        lineChart1.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        lineChart1.start();

        chart2.addLegend("Saving Acc",new Color(78, 79, 235),new Color(215, 187, 245));
        chart2.addLegend("Current Acc",new Color(11, 102, 106),new Color(151, 254, 237));
        chart2.addLegend("Credit Card Acc",new Color(210, 39, 121),new Color(255, 0, 142));
        chart2.addData(new ModelChart("January", new double[]{accountDao1.getAccountCountByMonthAndType(1,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.addData(new ModelChart("February",  new double[]{accountDao1.getAccountCountByMonthAndType(2,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.addData(new ModelChart("March", new double[]{accountDao1.getAccountCountByMonthAndType(3,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.addData(new ModelChart("April", new double[]{accountDao1.getAccountCountByMonthAndType(4,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.addData(new ModelChart("May", new double[]{accountDao1.getAccountCountByMonthAndType(5,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.addData(new ModelChart("June", new double[]{accountDao1.getAccountCountByMonthAndType(6,"Savings"),accountDao1.getAccountCountByMonthAndType(1,"Checking"),accountDao1.getAccountCountByMonthAndType(1,"Credit Card")}));
        chart2.start();

        lineChart2.addLegend("Income", new Color(210, 39, 121),new Color(255, 0, 142));
        lineChart2.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
        lineChart2.addLegend("Profit", new Color(11, 102, 106),new Color(151, 254, 237));
        lineChart2.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        lineChart2.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        lineChart2.addData(new ModelChart("February", new double[]{600, 750, 90, 150}));
        lineChart2.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        lineChart2.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        lineChart2.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        lineChart2.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        lineChart2.start();

        fButton33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(new JPanel(),"Report Generated successfully.");
            }
        });








        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);


    }//GEN-LAST:event_jButton7ActionPerformed

    private void JTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JTabStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_JTabStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(2);
        customerDao.loadCustomers(jTable2);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(1);
        employeeDAO.extractEmployeesIntoTable(EmployeeTable);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(3);
        loanDao.extractLoansIntoTable(jTable3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(4);
        transactionDao.extractTransactionsIntoTable(jTable4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(5);
        progress3.setValue(LoanDao.countClosedLoans());
        progress3.setBackground(new Color(78, 79, 235));
        progress3.setForeground(new Color(215, 187, 245));
        progress3.start();

        progress4.setValue( LoanDao.calculatePendingLoanAmount());
        progress4.setBackground(new Color(78, 79, 235));
        progress4.setForeground(new Color(215, 187, 245));
        progress4.start();
        System.out.println(LoanDao.countLoanAccounts()%CustomerDao.countTotalCustomers());
        progress5.setValue(LoanDao.countLoanAccounts()%CustomerDao.countTotalCustomers());
        progress5.setBackground(new Color(78, 79, 235));
        progress5.setForeground(new Color(215, 187, 245));
        progress5.start();

    }
    //GEN-LAST:event_jButton6ActionPerformed
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JTab.setSelectedIndex(5);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {new AdminMain().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTab;
    private bank_management_system.Components.Chart chart1;
    private bank_management_system.Components.Chart chart2;
    private bank_management_system.Components.FButton fButton10;
    private bank_management_system.Components.FButton fButton11;
    private bank_management_system.Components.FButton fButton12;
    private bank_management_system.Components.FButton fButton1;
    private bank_management_system.Components.FButton fButton13;
    private bank_management_system.Components.FButton fButton14;
    private bank_management_system.Components.FButton fButton15;
    private bank_management_system.Components.FButton fButton16;
    private bank_management_system.Components.FButton fButton2;
    private bank_management_system.Components.FButton fButton3;
    private bank_management_system.Components.FButton fButton4;
    private bank_management_system.Components.FButton fButton5;
    private bank_management_system.Components.FButton AddCustomer;
    private bank_management_system.Components.FButton DeleteCustomer;
    private bank_management_system.Components.FButton fButton8;
    private bank_management_system.Components.FButton fButton9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private bank_management_system.Components.LineChart lineChart1;
    private bank_management_system.Components.LineChart lineChart2;
    private bank_management_system.Components.Progress progress1;
    private bank_management_system.Components.Progress progress2;
    private bank_management_system.Components.Progress progress3;
    private bank_management_system.Components.Progress progress4;
    private bank_management_system.Components.Progress progress5;
    private bank_management_system.Manager.RoundPanel roundPanel1;
    private bank_management_system.Manager.RoundPanel roundPanel10;
    private bank_management_system.Manager.RoundPanel roundPanel11;
    private bank_management_system.Manager.RoundPanel roundPanel12;
    private bank_management_system.Manager.RoundPanel roundPanel13;
    private bank_management_system.Manager.RoundPanel roundPanel14;
    private bank_management_system.Manager.RoundPanel roundPanel2;
    private bank_management_system.Manager.RoundPanel roundPanel3;
    private bank_management_system.Manager.RoundPanel roundPanel4;
    private bank_management_system.Manager.RoundPanel roundPanel5;
    private bank_management_system.Manager.RoundPanel roundPanel6;
    private bank_management_system.Manager.RoundPanel roundPanel7;
    private bank_management_system.Manager.RoundPanel roundPanel8;
    private bank_management_system.Manager.RoundPanel roundPanel9;

    // End of variables declaration//GEN-END:variables
}
