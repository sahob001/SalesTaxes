package Itemis.Salestaxes.Products;

public class BookProduct extends Good {

    public BookProduct(Double price, Boolean imported, String name, int quantity) {
        super(price, imported, name, quantity);
    }

    public BookProduct(Double price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble(((5 * super.getPrice() / 100)) + (super.getPrice()), 2) * getQuantity();
        return super.getPrice() * super.getQuantity();
    }
}
