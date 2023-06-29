class CarFactory extends ProductFactory {
    @Override
    public Product createProduct(String name, double rentalPrice, double insurancePrice) {
        return new Car(name, rentalPrice, insurancePrice, "Car Brand", 1500, 2000);
    }
}