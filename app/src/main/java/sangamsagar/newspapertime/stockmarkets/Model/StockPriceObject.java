package sangamsagar.newspapertime.stockmarkets.Model;
/*StockPriceObject stockPriceObject = new StockPriceObject(stkexchg,exchange,lastprice,author,percentage,direction
                      ,open,high,low,prevclose,yearlyhigh,yearlylow,ytd,lastupdated);*/
public class StockPriceObject {

    String comapny,price,change,percentchange;

   public StockPriceObject()
   {

   }

    public String getComapny() {
        return comapny;
    }

    public String getPrice() {
        return price;
    }

    public String getChange() {
        return change;
    }

    public String getPercentchange() {
        return percentchange;
    }

    public  StockPriceObject(String comapny, String price, String change, String percentchange)
   {
    this.comapny= comapny;
    this.price= price;
    this.change= change;
    this.percentchange= percentchange;
   }
}
