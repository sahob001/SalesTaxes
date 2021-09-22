package Itemis.Salestaxes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SalesTaxesCalculatorTests {

    @Test
    void PriceOfOneGoodWithTaxes() {
        Good good1 = new Good(12.49, "Book", false);
        assertEquals(12.49, good1.calculateTaxesPrice());

        Good good2 = new Good(14.99, "Other", false);
        assertEquals(16.49, good2.calculateTaxesPrice());

        Good good3 = new Good(0.85, "Food", false);
        assertEquals(0.85, good3.calculateTaxesPrice());

        Good good4 = new Good(10.00, "Food", true);
        assertEquals(10.50, good4.calculateTaxesPrice());

        Good good5 = new Good(47.50, "Other", true);
        assertEquals(54.63, good5.calculateTaxesPrice());

        Good good6 = new Good(27.99, "Other", true);
        assertEquals(32.19, good6.calculateTaxesPrice());

        Good good7 = new Good(18.99, "Other", false);
        assertEquals(20.89, good7.calculateTaxesPrice());

        Good good8 = new Good(9.75, "MedicalProduct", false);
        assertEquals(9.75, good8.calculateTaxesPrice());

        Good good9 = new Good(11.25, "Food", true);
        assertEquals(11.81, good9.calculateTaxesPrice());
    }

    @Test
    void PriceOfGoodsWithTaxes() {
        SalesTaxesCalculator goodsList1 = new SalesTaxesCalculator(Arrays.asList(new Good(12.49, "Book", false),
                new Good(14.99, "Music", false), new Good(0.85, "Food", false)));
        assertEquals(29.83, goodsList1.getTotalPrice());

        SalesTaxesCalculator goodsList2 = new SalesTaxesCalculator(
                Arrays.asList(new Good(10.00, "Food", true), new Good(47.50, "Other", true)));
        assertEquals(65.13, goodsList2.getTotalPrice());

        SalesTaxesCalculator goodsList3 = new SalesTaxesCalculator(
                Arrays.asList(new Good(27.99, "Other", true), new Good(18.99, "Other", false),
                        new Good(9.75, "MedicalProduct", false), new Good(11.25, "Food", true)));
        assertEquals(74.64, goodsList3.getTotalPrice());
    }
}
