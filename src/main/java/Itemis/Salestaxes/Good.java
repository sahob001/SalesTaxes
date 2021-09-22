package Itemis.Salestaxes;

public abstract class Good {

    private Double price;
    private Boolean imported;

    public Good(Double price, Boolean imported) {
        this.price = price;
        this.imported = imported;
    }

    public Good(Double price) {
        this.price = price;
        imported = false;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getImported() {
        return imported;
    }

    // Calculate Taxes
    abstract Double calculateTaxesPrice();

    // round by decimal places
    public Double roundDouble(final Double number, final int decimalPlaces) {
        Double precision = 1.0;
        for (int i = 0; i < decimalPlaces; i++, precision *= 10)
            ;
        return ((int) (number * precision + 0.5) / precision);
    }
}
