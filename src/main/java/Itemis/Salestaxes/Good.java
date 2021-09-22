package Itemis.Salestaxes;

public class Good {

    private Double price;
    private String type;
    private Boolean imported;

    public Good(Double price, String type, Boolean imported) {
        this.price = price;
        this.type = type;
        this.imported = imported;
    }

    public Double getPrice() {
        return price;
    }

    // Calculate Taxes
    public Double calculateTaxesPrice() {
        if (type.equals("Book") || type.equals("Food") || type.equals("MedicalProduct")) {
            if (imported == true)
                return roundDouble((5 * price / 100) + price, 2);
            return price;
        } else if (imported == true) {
            return roundDouble((15 * price / 100) + price, 2);
        }
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
