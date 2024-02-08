package bank_management_system.CustomerModule;

public class Customer {


    public String getEmail() {
        return Email;
    }

    private String FirstName;
    private String LastName;
    private int Accountno;
    private String CNIC;
    private String PhoneNo;
    private String AccountType;

    private String Passoword;
    private String Email;

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAccountno() {
        return Accountno;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }



    public String getUsername() {
        return Username;
    }

    public String getPassoword() {
        return Passoword;
    }

    public int getCUSTID() {
        return CUSTID;
    }

    public void setCUSTID(int CUSTID) {
        this.CUSTID = CUSTID;
    }

    private int CUSTID;

    public double getbalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAccountno(int accountno) {
        Accountno = accountno;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }



    public void setUsername(String username) {
        Username = username;
    }

    private String Username;


    public double getBalance() {
        return balance;
    }

    public void setPassoword(String passoword) {
        Passoword = passoword;
    }


    public String getGender() {
        return gender;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public Customer() {

    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }



}
