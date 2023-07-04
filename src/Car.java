class Car extends Product {
        private String brand;
        private int weight;
        private int engineCapacity;

        public Car(String name, String omschrijving, double rentalPrice, double insurancePrice, boolean available, boolean verhuurd, String brand, int weight, int engineCapacity) {
            super(name, omschrijving, rentalPrice, insurancePrice, available, verhuurd);
            this.brand = brand;
            this.weight = weight;
            this.engineCapacity = engineCapacity;
        }


    @Override
    public boolean isAvailable() {
        if (verhuurd) {
            return false;
        } else {
            return true;
        }
    }

    @Override
        public String getProductType() {

            return "Car";
        }
    @Override
    protected void displaySpecificDetails() {
        System.out.println("Merk: " + brand);
        System.out.println("Gewicht: " + weight + " kg");
        System.out.println("Motorinhoud: " + engineCapacity + " cc");
    }



    @Override
    protected double calculateRentalPrice(double rentalPrice) {
        return rentalPrice;
    }

    @Override
    protected double calculateInsurancePrice(double insurancePrice) {
        return insurancePrice;
    }


    }
