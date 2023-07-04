class Truck extends Product {
    private int loadCapacity;
    private int engineCapacity;

    public Truck(String name, String omschrijving, double rentalPrice, double insurancePrice, boolean available, boolean verhuurd, int loadCapacity, int engineCapacity) {
        super(name, omschrijving, rentalPrice, insurancePrice, available, verhuurd);
        this.loadCapacity = loadCapacity;
        this.engineCapacity = engineCapacity;
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
    public String getProductType() {
        return "Truck";
    }

    @Override
    protected void displaySpecificDetails() {
        System.out.println("Laadvermogen: " + loadCapacity);
        System.out.println("Motorinhoud: " + engineCapacity);
    }

    protected double calculateRentalPrice(double rentalPrice) {
        return rentalPrice;
    }
    @Override
    protected double calculateInsurancePrice(double insurancePrice) {
        return insurancePrice;
    }
}