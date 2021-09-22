package Itemis.Salestaxes;

import java.util.List;

import Itemis.Salestaxes.Products.Good;

public class Receipt {
    private List<Good> goods;
    private Double total;
    private Double salesTaxes;

    public Receipt(List<Good> goods) {
        this.goods = goods;
        total = calculateTotalWithTaxes() / 100;
        salesTaxes = (calculateTotalWithTaxes() - calculateTotalWithoutTaxes()) / 100;
    }

    private Double calculateTotalWithTaxes() {
        return goods.stream().mapToDouble(good -> good.calculateTaxesPrice() * 100).sum();
    }

    private Double calculateTotalWithoutTaxes() {
        return goods.stream().mapToDouble(good -> good.getPrice() * 100).sum();
    }

    public Double getTotal() {
        return total;
    }

    public Double getTotalTaxes() {
        return salesTaxes;
    }

    public void print() {
        System.out.println("Output: ");
        for (int i = 0; i < goods.size(); i++) {
            System.out.println("> " + goods.get(i).getQuantity() + " " + goods.get(i).getName() + " at "
                    + goods.get(i).calculateTaxesPrice());

        }
        System.out.println("> Sales Taxes: " + salesTaxes);
        System.out.println("> Total: " + total + "\n");
    }

}