package Itemis.Salestaxes.Products;

public class FoodProduct extends Good {

    public FoodProduct(Double price, Boolean imported, String name, int quantity) {
        super(price, imported, name, quantity);
    }

    public FoodProduct(Double price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((5 * super.getPrice() / 100) + super.getPrice(), 2) * getQuantity();
        return super.getPrice() * getQuantity();
    }
}
