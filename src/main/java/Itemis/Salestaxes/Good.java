package Itemis.Salestaxes;

public class Good {

    private Double price;
    private String type;

    public Good(Double price, String type) {
        this.price = price;
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    // Calculate Taxes
    public Double calculateTaxesPrice() {
        if (type.equals("Book") || type.equals("Food") || type.equals("MedicalProduct"))
            return price;
        return roundDouble((10 * price / 100) + price, 2);
    }

    // round by decimal places
    public Double roundDouble(final Double number, final int decimalPlaces) {
        Double precision = 1.0;
        for (int i = 0; i < decimalPlaces; i++, precision *= 10)
            ;
        return ((int) (number * precision + 0.5) / precision);
    }
}
