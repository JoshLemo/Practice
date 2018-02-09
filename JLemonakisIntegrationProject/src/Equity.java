public class Equity {
  private String symbol;
  private String name;

  public Equity(String symbol, String name, String price) {
    this.symbol = symbol;
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public double getPrice() {
    double price = -1.0;
    String html = readHTML(symbol);
    if (html != null)
      price = priceOf(symbol, html);

    return price;
  }

  public String getName() {
    return name;
  }

  /* support methods for the screen scrape to get realtime prices */

  private static String readHTML(String symbol) {
    In page = new In("http://finance.yahoo.com/quote/" + symbol);
    String html = page.readAll();
    if (html.contains("<title></title>"))
      return null;
    else
      return html;
  }

  public static double priceOf(String symbol, String html) {
    int p = html.indexOf("price.0", 0); // "price.0" index
    int from = html.indexOf(">", p); // ">" index
    int to = html.indexOf("</span>", from); // "</span>" index
    String price = html.substring(from + 1, to);

    // remove any comma separators
    return Double.parseDouble(price.replaceAll(",", ""));
  }

}
