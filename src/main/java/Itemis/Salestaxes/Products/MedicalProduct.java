package Itemis.Salestaxes.Products;

public class MedicalProduct extends Good {

    public MedicalProduct(Double price, Boolean imported, String name, int quantity) {
        super(price, imported, name, quantity);
    }

    public MedicalProduct(Double price, String name, int quantity) {
        super(price, name, quantity);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((5 * super.getPrice() / 100) + super.getPrice(), 2) * getQuantity();
        return super.getPrice() * getQuantity();
    }
}
