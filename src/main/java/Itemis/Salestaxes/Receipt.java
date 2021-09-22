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
        System.out.println("\n\n\nAUSGABE-----------------------------------------------\n\n\n\n");
    }

}