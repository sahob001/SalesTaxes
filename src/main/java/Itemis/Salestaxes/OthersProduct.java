package Itemis.Salestaxes;

public class OthersProduct extends Good {

    public OthersProduct(Double price, Boolean imported) {
        super(price, imported);
    }

    public OthersProduct(Double price) {
        super(price);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((15 * super.getPrice() / 100) + super.getPrice(), 2);
        return roundDouble((10 * super.getPrice() / 100) + super.getPrice(), 2);
    }

}
