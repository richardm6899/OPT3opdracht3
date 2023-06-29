class DrillFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, double rentalPrice, double insurancePrice) {
        return new Drill(name, rentalPrice, insurancePrice, "Drill Brand", "Type X");
    }
}