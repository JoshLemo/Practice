import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // create a scanner object for input
    Scanner input = new Scanner(System.in);

    // create an array of equity objects and get some equities setup
    Equity[] equity = new Equity[5];
    // from equity.class
    // public equity(String symbol, String name, int shares, String datePurchased,
    // double perSharePrice)

    // constructor
    equity[0] = new Equity("AAPL", "Apple Inc.", 500, "10/20/2015", 113.77);
    equity[1] = new Equity("AMZN", "Amazon.com", 100, "10/20/2015", 560.88);
    equity[2] = new Equity("GOOG", "Alphabet Inc.", 100, "10/20/2015", 650.28);
    equity[3] = new Equity("NVDA", "Nvidia Inc.", 500, "10/20/2015", 27.77);

    // display equities
    for (int i = 0; i < 4; i++)
      System.out.println(equity[i]);
  }
}
