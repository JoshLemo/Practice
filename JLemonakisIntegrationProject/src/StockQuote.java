/******************************************************************************
 * Compilation: javac StockQuote.java Execution: java StockQuote symbol Dependencies: In.java,
 * StdOut.java http://introcs.cs.princeton.edu/java/31datatype/StockQuote.java.html Copyright ©
 * 2000–2011, Robert Sedgewick and Kevin Wayne. Last updated: Tue Aug 30 09:58:33 EDT 2016.
 *
 * Print the stock price of the stock with the given symbol. Screen scrapes http://finance.yahoo.com
 * to get the current price and associated information.
 *
 * Warning: if Yahoo updates the format of their page, this program also needs to be updated.
 *
 * % java StockQuote GOOG 744.0 Alphabet Inc. Wed Jul 27 12:19:16 PDT 2016
 *
 * % java StockQuote AAPL 103.78 Apple Inc. Wed Jul 27 12:19:21 PDT 2016
 * 
 * % java StockQuote IBM 162.29 International Business Machines Corporation Wed Jul 27 12:19:26 PDT
 * 2016
 *
 * % java StockQuote MSFT 56.46 Microsoft Corporation Wed Jul 27 12:19:30 PDT 2016
 *
 ******************************************************************************/



public class StockQuote {

  // Given symbol, get HTML
  private static String readHTML(String symbol) {
    In page = new In("http://finance.yahoo.com/quote/" + symbol);
    String html = page.readAll();
    if (html.contains("<title></title>"))
      return null;
    else
      return html;
  }

  // Given symbol, get current stock price.
  public static double priceOf(String symbol) {
    String html = readHTML(symbol);
    int p = html.indexOf("price.0", 0); // "price.0" index
    int from = html.indexOf(">", p); // ">" index
    int to = html.indexOf("</span>", from); // "</span>" index
    String price = html.substring(from + 1, to);

    // remove any comma separators
    return Double.parseDouble(price.replaceAll(",", ""));
  }

  // Given symbol, get current stock price.
  // data-reactid=".1v4u1lfwu8k.0.$0.0.0.3.1.$main-0-Quote-Proxy.$main-0-Quote.0.1.0.$price.0">65.35</span>
  // price.0">65.35</span>
  public static double priceOf(String symbol, String html) {
    int p = html.indexOf("price.0", 0); // "price.0" index
    int from = html.indexOf(">", p); // ">" index
    int to = html.indexOf("</span>", from); // "</span>" index
    String price = html.substring(from + 1, to);

    // remove any comma separators
    return Double.parseDouble(price.replaceAll(",", ""));
  }

  // Given symbol, get current stock name.
  // <title>NVDA : Summary for NVIDIA Corporation - Yahoo Finance</title>//
  public static String nameOf(String symbol, String html) {
    /*
     * Due to Yahoo changes: the following 3 lines changed 10/13/2016 by Jim Barrell from: int p =
     * html.indexOf("symbol.$companyName", 0); int from = html.indexOf(">", p); int to =
     * html.indexOf("</h6>", from); to:
     */
    int p = html.indexOf("<title>" + symbol + " : Summary for ", 0);
    int from = html.indexOf("for ", p) + 3;
    int to = html.indexOf("- Yahoo Finance", from);
    String name = html.substring(from + 1, to);
    return name;
  }

  // Given symbol, get current date.
  // <!-- bf1-sdarlaws-020.adx.bf1.yahoo.com Thu Oct 13 19:57:50 PDT 2016 --> //
  public static String dateOf(String symbol, String html) {
    int p = html.indexOf("adx.bf1.yahoo.com", 0);
    int from = html.indexOf(" ", p);
    int to = html.indexOf("-->", from);
    String date = html.substring(from + 1, to);
    return date;
  }


  public static void main(String[] args) {
    String symbol = args[0];
    String html = readHTML(symbol);
    if (html == null)
      StdOut.println("Invalid symbol: " + symbol);
    else {
      StdOut.println(priceOf(symbol, html));
      StdOut.println(nameOf(symbol, html));
      StdOut.println(dateOf(symbol, html));
    }
  }

}
