class Drill extends Product {
    private String brand;
    private String type;

    public Drill(String name, String omschrijving, double rentalPrice, double insurancePrice, boolean available, boolean verhuurd, String brand, String type) {
        super(name, omschrijving, rentalPrice, insurancePrice, available, verhuurd);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String getProductType() {
        return "Drill";
    }
    @Override
    public boolean isAvailable() {
        if (verhuurd) {
            return false; // Si el coche está alquilado
        } else {
            return true; // Si no está alquilado
        }
    }
    @Override
    protected double calculateRentalPrice(double rentalPrice) {
        return rentalPrice;
    }

    @Override
    protected double calculateInsurancePrice(double insurancePrice) {
        return insurancePrice;
    }
    @Override
    protected void displaySpecificDetails() {
        System.out.println("Merk: " + brand);
        System.out.println("Type: " + type);
    }

}