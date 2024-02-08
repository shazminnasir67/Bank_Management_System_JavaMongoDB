package bank_management_system.CustomerModule;

public class Loan {
    private int loanId;           // Unique loan identifier
    private String loanType;      // Type of loan (e.g., Personal, Home, Auto)
    private double loanAmount;    // The loan amount requested by the customer
    private double interestRate;  // Annual interest rate for the loan
    private int termMonths;       // Loan term in months
    private String loanStatus;    // Loan status (e.g., Approved, Pending, Rejected)
   // private Customer customer;    // Reference to the customer who applied for the loan

    // Constructors
    public Loan(int loanId, String loanType, double loanAmount, double interestRate, int termMonths, String loanStatus) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.loanStatus = loanStatus;
       // this.customer = customer;
    }

    // Getters and setters
    public int getLoanId() {
        return loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

//    public CustomerBMS getCustomer() {
//        return new CustomerBMS();
//    }
//
//    public void setCustomer(CustomerBMS customer) {
//        this.customer = customer;
//    }
}

