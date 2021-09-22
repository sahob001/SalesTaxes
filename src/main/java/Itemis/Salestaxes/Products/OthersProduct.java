package Itemis.Salestaxes.Products;

public class OthersProduct extends Good {

    public OthersProduct(Double price, Boolean imported, String name, int quantity) {
        super(price, imported, name, quantity);
    }

    public OthersProduct(Double price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((15 * super.getPrice() / 100) + super.getPrice(), 2) * getQuantity();
        return roundDouble((10 * super.getPrice() / 100) + super.getPrice(), 2) * getQuantity();
    }

}
