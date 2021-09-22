package Itemis.Salestaxes.Products;

public class FoodProduct extends Good {

    public FoodProduct(Double price, Boolean imported) {
        super(price, imported);
    }

    public FoodProduct(Double price) {
        super(price);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((5 * super.getPrice() / 100) + super.getPrice(), 2);
        return super.getPrice();
    }
}
