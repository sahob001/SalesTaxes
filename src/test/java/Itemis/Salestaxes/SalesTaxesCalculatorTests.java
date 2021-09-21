package Itemis.Salestaxes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SalesTaxesCalculatorTests {

    @Test
    void PriceOfOneGoodWithTaxes() {
        Good good1 = new Good(12.49, "Book");
        assertEquals(12.49, good1.calculateTaxesPrice());
        Good good2 = new Good(14.99, "Music");
        assertEquals(16.49, good2.calculateTaxesPrice());
        Good good3 = new Good(0.85, "Food");
        assertEquals(0.85, good3.calculateTaxesPrice());
    }

    @Test
    void PriceOfGoodsWithTaxes() {
        SalesTaxesCalculator goodsList = new SalesTaxesCalculator(
                Arrays.asList(new Good(12.49, "Book"), new Good(14.99, "Music"), new Good(0.85, "Food")));
        assertEquals(29.83, goodsList.getTotalPrice());
    }
}
