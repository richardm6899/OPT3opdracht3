class Drill extends Product {
    private String brand;
    private String type;

    public Drill(String name, double rentalPrice, double insurancePrice, String brand, String type) {
        super(name, rentalPrice, insurancePrice);
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String getProductType() {
        return "Drill";
    }
    @Override
    public boolean isAvailable() {
        return true;
    }
    @Override
    protected double calculateRentalPrice(int days) {
        return rentalPrice * days;
    }

    @Override
    protected double calculateInsurancePrice(int days) {
        return insurancePrice * days;
    }
    @Override
    public void displayDetails() {
        System.out.println("Drill: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
        System.out.println("Rental Price: " + rentalPrice + " euro/day");
        System.out.println("Insurance Price: " + insurancePrice + " euro/day");
        System.out.println();
    }
}