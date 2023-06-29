
abstract class Product {
    protected String name;
        protected double rentalPrice;
        protected double insurancePrice;

        public Product(String name, double rentalPrice, double insurancePrice) {
            this.name = name;
            this.rentalPrice = rentalPrice;
            this.insurancePrice = insurancePrice;
        }

    public String getName() {
        return name;
    }

    public abstract boolean isAvailable();


        public abstract String getProductType();

        public String getShortDescription() {
        return "Name: " + name;
    }

    public void displayDetails() {
        System.out.println("Product Details:");
        System.out.println("Name: " + name);
        System.out.println("Rental Price: " + rentalPrice + " euro/day");
        System.out.println("Insurance Price: " + insurancePrice + " euro/day");
        System.out.println();
    }

    final public double calculateTotalPrice(boolean isInsured, int days) {
        double totalPrice = calculateRentalPrice(days);
        if (isInsured) {
            totalPrice += calculateInsurancePrice(days);
        }
        return totalPrice;
    }

    protected abstract double calculateRentalPrice(int days);

    protected abstract double calculateInsurancePrice(int days);
}