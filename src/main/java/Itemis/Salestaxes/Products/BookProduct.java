package Itemis.Salestaxes.Products;

public class BookProduct extends Good {

    public BookProduct(Double price, Boolean imported) {
        super(price, imported);
    }

    public BookProduct(Double price) {
        super(price);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((5 * super.getPrice() / 100) + super.getPrice(), 2);
        return super.getPrice();
    }
}
