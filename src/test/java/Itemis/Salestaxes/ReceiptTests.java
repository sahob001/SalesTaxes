package Itemis.Salestaxes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Itemis.Salestaxes.Products.BookProduct;
import Itemis.Salestaxes.Products.FoodProduct;
import Itemis.Salestaxes.Products.Good;
import Itemis.Salestaxes.Products.MedicalProduct;
import Itemis.Salestaxes.Products.OthersProduct;

public class ReceiptTests {

    private Receipt createReceiptWithGoods(Good... goods) {
        return new Receipt(Arrays.asList(goods));
    }

    @Test
    void priceOfOneGoodWithTaxes() {
        Good good1 = new BookProduct(12.49);
        assertEquals(12.49, good1.calculateTaxesPrice());

        Good good2 = new OthersProduct(14.99);
        assertEquals(16.49, good2.calculateTaxesPrice());

        Good good3 = new FoodProduct(0.85);
        assertEquals(0.85, good3.calculateTaxesPrice());

        Good good4 = new FoodProduct(10.00, true);
        assertEquals(10.50, good4.calculateTaxesPrice());

        Good good5 = new OthersProduct(47.50, true);
        assertEquals(54.63, good5.calculateTaxesPrice());

        Good good6 = new OthersProduct(27.99, true);
        assertEquals(32.19, good6.calculateTaxesPrice());

        Good good7 = new OthersProduct(18.99);
        assertEquals(20.89, good7.calculateTaxesPrice());

        Good good8 = new MedicalProduct(9.75);
        assertEquals(9.75, good8.calculateTaxesPrice());

        Good good9 = new FoodProduct(11.25, true);
        assertEquals(11.81, good9.calculateTaxesPrice());
    }

    @Test
    void totalSalesTaxes() {
        Receipt output1 = createReceiptWithGoods(new BookProduct(12.49), new OthersProduct(14.99),
                new FoodProduct(0.85));
        assertEquals(1.50, output1.getTotalTaxes());
        output1.print();

        Receipt output2 = createReceiptWithGoods(new FoodProduct(10.00, true), new OthersProduct(47.50, true));
        assertEquals(7.63, output2.getTotalTaxes());

        Receipt output3 = createReceiptWithGoods(new OthersProduct(27.99, true), new OthersProduct(18.99),
                new MedicalProduct(9.75), new FoodProduct(11.25, true));
        assertEquals(6.66, output3.getTotalTaxes());
    }

    @Test
    void totalPriceOfReceiptWithTaxes() {
        Receipt output1 = createReceiptWithGoods(new BookProduct(12.49), new OthersProduct(14.99),
                new FoodProduct(0.85));
        assertEquals(29.83, output1.getTotal());

        Receipt output2 = createReceiptWithGoods(new FoodProduct(10.00, true), new OthersProduct(47.50, true));
        assertEquals(65.13, output2.getTotal());

        Receipt output3 = createReceiptWithGoods(new OthersProduct(27.99, true), new OthersProduct(18.99),
                new MedicalProduct(9.75), new FoodProduct(11.25, true));

        assertEquals(74.64, output3.getTotal());
    }
}
