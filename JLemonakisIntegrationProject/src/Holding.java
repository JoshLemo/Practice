/***********************************************
 * Jim Barrell COP 2800 Fall 2016 MidTerm: Holding.java October 20, 2016 Florida Southwestern State
 * College
 ***********************************************/

public class Holding {
  private Equity equity; // instance variable for equity
  private int shares; // number of shares
  private String datePurchased;
  private double purchasePrice; // total price paid
  private String dateSold; // null if not sold
  private double salePrice; // total sale proceeds
  private Boolean active; // true while equities held. False if not.

  public Holding(String symbol, String name, int shares, String datePurchased, double perSharePrice) // constructor
  {
    equity = new Equity(symbol, name);
    // this.equity = equity;
    this.shares = shares;
    this.datePurchased = datePurchased;
    this.purchasePrice = shares * perSharePrice;
    this.active = true;
  }

  public String showHolding() {
    String stmt = "";
    stmt += equity.getName() + " (" + equity.getSymbol() + ") ";
    stmt += getShares() + " shares @ " + String.format("$%.2f", equity.getPrice());
    stmt += " Total: " + String.format("$%.2f", getCurrentBalance());
    stmt += " Net: " + String.format("$%.2f", getCurrentGainOrLoss());
    stmt += String.format(" %.1f", (getCurrentGainOrLoss() / purchasePrice) * 100) + "%";

    return stmt;
  }

  // method to sell the holding object
  public double sellHolding(String dateSold, double salePrice) {
    this.dateSold = dateSold;
    this.salePrice = salePrice;
    this.active = false;
    return getCurrentGainOrLoss();
  }

  public int getShares() {
    return shares;
  }

  public double getCurrentEquityPrice() // price of one share
  {
    return equity.getPrice();
  }

  public double getCurrentBalance() {
    return equity.getPrice() * shares;
  }

  public double getInitialCost() {
    return purchasePrice;
  }

  public double getCurrentGainOrLoss() {
    if (isActive())
      return getCurrentBalance() - getInitialCost();
    else
      return purchasePrice - salePrice;
  }

  public Boolean isActive() {
    return active;
  }
}
