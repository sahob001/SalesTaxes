package Itemis.Salestaxes;

import java.util.List;

public class SalesTaxesCalculator {
    private List<Good> goods;

    public SalesTaxesCalculator(List<Good> goods) {
        this.goods = goods;
    }

    public Double getTotalPrice() {
        return ((goods.stream().mapToDouble(good -> good.calculateTaxesPrice()).sum()) * 100) / 100;
    }
}