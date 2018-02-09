public class Account {
  private String name; // instance variable
  private double balance; // instance variable
  private Holding[] holdings; // instance variable

  // Account constructor that receives two parameters
  public Account(String name, double balance) {
    this.name = name; // assign name to instance variable name

    // validate that the balance is greater than 0.0; if it's not,
    // instance variable balance keeps its default initial value of 0.0
    if (balance > 0.0) // if the balance is valid
      this.balance = balance; // assign it to instance variable balance
  }

  // method that deposits (adds) only a valid amount to the balance
  public void deposit(double depositAmount) {
    if (depositAmount > 0.0) // if the depositAmount is valid
      balance = balance + depositAmount; // add it to the balance
  }

  // method that withdraws (subtracts) only a valid amount from the balance
  public void withdraw(double withdrawAmount) {
    if (withdrawAmount < balance) // if the withdrawAmount is valid
      balance = balance - withdrawAmount; // subtract it from the balance
    else
      System.out.printf("The withdraw amount exceeds available balance.%n%n");
  }

  // method returns the account balance
  public double getBalance() {
    return balance;
  }

  // method that set the name
  public void setName(String name) {
    this.name = name;
  }

  // method that returns the name
  public String getName() {
    return name; // give value of name back to caller
  } // end method getName

  public Holding[] getHoldings() {
    return holding;
  }


} // end class Account
