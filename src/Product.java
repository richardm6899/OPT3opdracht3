import java.util.Scanner;

abstract class Product {
        protected String name;
    protected double rentalPrice;
    protected double insurancePrice;
            protected boolean available;
            protected boolean verhuurd;
            protected String omschrijving;

    public String getOmschrijving() {
        return omschrijving;
    }



            public Product(String name, String omschrijving, double rentalPrice, double insurancePrice, boolean available, boolean verhuurd) {
                this.name = name;
                this.omschrijving = omschrijving;
                this.rentalPrice = rentalPrice;
                this.insurancePrice = insurancePrice;
                this.available = available;
                this.verhuurd = verhuurd;
            }

        public String getName() {
            return name;
        }

        public abstract boolean isAvailable();


            public abstract String getProductType();


        public final void displayProductDetails() {
            System.out.println("Product Details: ");
            displayHeader();
            displaySpecificDetails();
            displayFooter();
        }
        protected abstract void displaySpecificDetails();
        private void displayHeader(){
            System.out.println("Product: " + getName());
            System.out.println("Omschrijvinng: " + getOmschrijving());
            System.out.println("Huurprijs: " + getRentalPrice() + " euro/day");
            System.out.println("Verzekeringprijs: " + getInsurancePrice() + " euro/day");
            System.out.println("Availability: " + isAvailable());
        }
    private void displayFooter() {
        System.out.println("----------------------");
    }
        public void verhuren(Medewerker medewerker, Klant klant) {
            if (verhuurd) {
                System.out.println("Dit product is verhuurd door medewerker: " + medewerker.getUsername() + " en klant: " + klant.getVoornaam() + " " + klant.getAchternaam());
            }
            else if(!verhuurd) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Is het product verzekerd? (ja/nee): ");
                String verzekeren = scanner.nextLine();

                boolean isVerzekerd = verzekeren.equalsIgnoreCase("ja");

                double huurprijsPerDag = calculateRentalPrice(rentalPrice);
                double totaleHuurprijs = huurprijsPerDag;

                if (isVerzekerd) {
                    double verzekeringsprijsPerDag = calculateInsurancePrice(insurancePrice);
                    totaleHuurprijs += verzekeringsprijsPerDag;
                }

                System.out.print("Vul de naam van de klant in: ");
                String klantNaam = scanner.nextLine();

                System.out.println("Product is verhuurd aan klant: " + klantNaam);
                System.out.println("Totale huurprijs per dag: " + totaleHuurprijs);
                System.out.println("Verhuren? ");
                String verhuurd = scanner.nextLine();
                boolean verhuren = verhuurd.equalsIgnoreCase("ja");
                if (verhuren){
                    isAvailable();
                    System.out.println("Uw transactie is voldaan!");
                }
            }
        }


        protected abstract double calculateRentalPrice(double rentalPrice);

        protected abstract double calculateInsurancePrice(double insurancePrice);

    public void setVerhuurd(boolean verhuurd) {
        this.verhuurd = verhuurd;
    }
    public double getInsurancePrice() {
        return insurancePrice;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
}
