class Truck extends Product {
    private int loadCapacity;
    private int engineCapacity;

    public Truck(String name, double rentalPrice, double insurancePrice, int loadCapacity, int engineCapacity) {
        super(name, rentalPrice, insurancePrice);
        this.loadCapacity = loadCapacity;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getProductType() {
        return "Truck";
    }
    @Override
    public boolean isAvailable() {
        return true;
    }

    protected double calculateRentalPrice(int days) {
        return rentalPrice * days;
    }

    @Override
    protected double calculateInsurancePrice(int days) {
        return insurancePrice * days;
    }
    @Override
    public void displayDetails() {
        System.out.println("Truck: " + name);
        System.out.println("Load Capacity: " + loadCapacity + " kg");
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
        System.out.println("Rental Price: " + rentalPrice + " euro/day");
        System.out.println("Insurance Price: " + insurancePrice + " euro/day");
        System.out.println();
    }
}