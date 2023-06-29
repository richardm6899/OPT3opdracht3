class Car extends Product {
        private String brand;
        private int weight;
        private int engineCapacity;

        public Car(String name, double rentalPrice, double insurancePrice, String brand, int weight, int engineCapacity) {
            super(name, rentalPrice, insurancePrice);
            this.brand = brand;
            this.weight = weight;
            this.engineCapacity = engineCapacity;
        }

        @Override
        public String getProductType() {

            return "Car";
        }

        @Override
        public void displayDetails() {
            System.out.println("Car: " + name);
            System.out.println("Brand: " + brand);
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Engine Capacity: " + engineCapacity + " cc");
            System.out.println("Rental Price: " + rentalPrice + " euro/day");
            System.out.println("Insurance Price: " + insurancePrice + " euro/day");
            System.out.println();
        }
    @Override
    public boolean isAvailable() {
            return true;
    }

    }
