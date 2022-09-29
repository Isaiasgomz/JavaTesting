package platzi.JavaTesting.Discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorTest{
    @Test
    public void total_zero_when_there_are_prices(){
        PriceCalculator priceCalculator = new PriceCalculator();
        assertThat(PriceCalculator.getTotal(), is(0.0));
    }

    @Test
    public void return_total_sum_prices(){
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrices(30.0);
        priceCalculator.addPrices(90.0);
        assertThat(priceCalculator.getTotal(), is(120.0));
    }

    @Test
    public void aply_discount_to_prices(){
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrices(50.0);
        priceCalculator.addPrices(100.0);
        priceCalculator.addPrices(150.0);

        priceCalculator.setDiscount(50.0);

        assertThat(priceCalculator.getTotal(), is(150.0));
    }


}