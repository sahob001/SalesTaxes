package Itemis.Salestaxes;

public class MedicalProduct extends Good {

    public MedicalProduct(Double price, Boolean imported) {
        super(price, imported);
    }

    public MedicalProduct(Double price) {
        super(price);
    }

    @Override
    public Double calculateTaxesPrice() {
        if (super.getImported() == true)
            return roundDouble((5 * super.getPrice() / 100) + super.getPrice(), 2);
        return super.getPrice();
    }
}
