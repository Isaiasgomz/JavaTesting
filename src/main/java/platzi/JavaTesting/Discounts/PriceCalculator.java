package platzi.JavaTesting.Discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

   private static List<Double> prices = new ArrayList<>();

   private static     double discount = 0.0;


   public static double getTotal(){

       Double result = 0.0;

       for ( Double price: prices) {
            result+= price;
       }

       return result * ( (100 - discount ) / 100);

   }


   public void addPrices(Double price){
       prices.add(price);
   }

   public void setDiscount(Double discount){
       this.discount = discount;
   }
}
