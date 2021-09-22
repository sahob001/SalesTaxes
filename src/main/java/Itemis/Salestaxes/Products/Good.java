package Itemis.Salestaxes.Products;

public abstract class Good {

    private Double price;
    private Boolean imported;
    private String name;
    private int quantity;

    public Good(Double price, Boolean imported, String name, int quantity) {
        this.price = price;
        this.imported = imported;
        this.name = name;
        this.quantity = quantity;
    }

    public Good(Double price, String name, int quantity) {
        this.price = price;
        imported = false;
        this.name = name;
        this.quantity = quantity;

    }

    public Double getPrice() {
        return price;
    }

    public Boolean getImported() {
        return imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    // Calculate Taxes
    public abstract Double calculateTaxesPrice();

    // round by decimal places
    public Double roundDouble(final Double number, final int decimalPlaces) {
        Double precision = 1.0;
        for (int i = 0; i < decimalPlaces; i++, precision *= 10)
            ;
        return ((int) (number * precision + 0.5) / precision);
    }
}
