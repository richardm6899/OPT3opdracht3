import java.util.List;
import java.util.Scanner;

class Inlogvenster {
    private ProductInventory productInventory;
    private ProductFactory productFactory;
    private ProductObserver productObserver;

    public Inlogvenster(ProductInventory productInventory,ProductFactory productFactory ) {

        this.productInventory = productInventory;
        this.productFactory = productFactory;
        this.productObserver = new ProductOverview();
        this.productInventory.addProductObserver(productObserver);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inlogvenster");
            System.out.print("Gebruikersnaam: ");
            String username = scanner.nextLine();
            System.out.print("Wachtwoord: ");
            String password = scanner.nextLine();

            if (authenticate(username, password)) {
                openMenu(username);
                break;
            } else {
                System.out.println("Ongeldige gebruikersnaam of wachtwoord. Probeer opnieuw.");
            }
        }
    }

    private boolean authenticate(String username, String password) {
        List<Medewerker> medewerkers = productInventory.getMedewerkers();
        for (Medewerker medewerker : medewerkers) {
            if (medewerker.getUsername().trim().equals(username) && medewerker.getPassword().trim().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void openMenu(String username) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.println("Menuvenster voor medewerker: " + username);
            System.out.println("1. Overzicht");
            System.out.println("2. Beheer");
            System.out.println("3. Uitloggen");
            System.out.print("Selecteer een optie: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Product car1 = new Car("Civic", "kleine auto", 50, 0.01, true, false, "Honda", 1000, 50);
                    Product car2 = new Car("SUV", "Grootste auto", 50, 0.01, true, false, "Nissan", 1200, 50);
                    Product car3 = new Car("KUGA", "Lange auto", 50, 0.01, true, false, "FORD", 1100, 50);
                    Product truck1 = new Truck("BigTruck", "Grote vrachtwagen", 0.10, 0.01, false, true, 2000, 10000);
                    Product truck2 = new Truck("FarmersTruck", "Boeren vrachtwagen", 0.10, 0.01, true, true, 4000, 12000);
                    Product truck3 = new Truck("Jumbo", "Lange Vrachtwagen", 0.10, 0.01, true, true, 3000, 12000);
                    Product drill1 = new Drill("DCD791P2-QW", "Kleine boormachine", 5, 1, true, false, "DeWalt", "Type 2");
                    Product drill2 = new Drill("DHR243ZJW", "Grote boormachine", 5, 1, false, true, "Makita", "Type 3");
                    Product drill3 = new Drill("PBD 40", "Lange boormachine", 5, 1, true, false, "BOSCH", "Type 5");
                    ProductOverview overviewWindow = new ProductOverview();
                    productInventory.addProduct(car1);
                    productInventory.addProduct(car2);
                    productInventory.addProduct(car3);
                    productInventory.addProduct(truck1);
                    productInventory.addProduct(truck2);
                    productInventory.addProduct(truck3);
                    productInventory.addProduct(drill1);
                    productInventory.addProduct(drill2);
                    productInventory.addProduct(drill3);
                    showProductOverview();
                    Medewerker medewerker1 = new Medewerker("user1", "password1");
                    Medewerker medewerker2 = new Medewerker("user2", "password2");
                    Klant klant1 = new Klant("Richard", "Morris");
                    Klant klant2 = new Klant("Robert", "Morris");
                    car1.setVerhuurd(false);
                    car2.setVerhuurd(false);
                    car3.setVerhuurd(false);
                    truck1.setVerhuurd(false);
                    drill1.setVerhuurd(false);
                    drill3.setVerhuurd(false);
                    truck1.verhuren(medewerker1, klant1);


                    break;
                case 2:


                    System.out.println("Beheer");
                    showProductTypes();
                    break;
                case 3:
                    System.out.println("Uitgelogd");
                    isLoggedIn = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }

            System.out.println();
        }
        login();
    }


    public void showProductOverview() {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = productInventory.getProducts();
        System.out.println("Product Overview:");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". Name: " + product.getName());
            System.out.println("Description: " + product.getOmschrijving());
            System.out.println("Availability: " + product.isAvailable());
            System.out.println("----------------------");
        }

        System.out.print("Selecteer een product (0 om terug te gaan): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 1 && choice <= products.size()) {
            Product selectedProduct = products.get(choice - 1);
            displayProductDetails(selectedProduct);
        } else if (choice == 0) {

        } else {
            System.out.println("Ongeldige keuze. Terug naar het vorige menu.");
        }
    }

    private void displayProductDetails(Product product) {
        product.displayProductDetails();
    }

    private void showProductTypes() {
        Scanner scanner = new Scanner(System.in);
        List<String> productTypes = productInventory.getProductTypes();

        System.out.println("Lijst van alle soorten producten:");

        for (int i = 0; i < productTypes.size(); i++) {
            System.out.println((i + 1) + ". " + productTypes.get(i));
        }

        System.out.print("Selecteer een soort product (0 om terug te gaan): ");
        int productChoice = scanner.nextInt();
        scanner.nextLine();

        if (productChoice >= 1 && productChoice <= productTypes.size()) {
            String selectedProductType = productTypes.get(productChoice - 1);
            System.out.println("Toevoegen van een " + selectedProductType + " product:");
            System.out.println("Voer de gegevens in:");


            System.out.print("Naam: ");
            String name = scanner.nextLine();
            System.out.print("Omschrijving: ");
            String description = scanner.nextLine();
            System.out.print("Huurprijs: ");
            double rentalPrice = scanner.nextDouble();
            System.out.print("Verzekeringsprijs: ");
            double insurancePrice = scanner.nextDouble();
            System.out.print("Beschikbaar (true/false): ");
            boolean available = scanner.nextBoolean();


            if (selectedProductType.equals("Car")) {
                System.out.print("Merk: ");
                String brand = scanner.nextLine();
                System.out.print("Gewicht: ");
                int weight = scanner.nextInt();
                System.out.print("laadvermogen: ");
                int maxLoadCapacity = scanner.nextInt();
                Car car = productFactory.createCar(name, description, rentalPrice, insurancePrice, available, false, brand, weight, maxLoadCapacity);
                productInventory.addProduct(car);
            } else if (selectedProductType.equals("Truck")) {
                System.out.print("laadvermogen: ");
                int maxLoadCapacity = scanner.nextInt();
                System.out.println("Motorinhoud: ");
                int enginecapacity = scanner.nextInt();
                Truck truck = productFactory.createTruck(name, description, rentalPrice, insurancePrice, available, false, maxLoadCapacity, enginecapacity);
                productInventory.addProduct(truck);
            } else if (selectedProductType.equals("Drill")) {
                System.out.print("Merk: ");
                String brand = scanner.nextLine();
                System.out.print("Type: ");
                String type = scanner.nextLine();
                Drill drill = productFactory.createDrill(name, description, rentalPrice, insurancePrice, available, false, brand, type);
                productInventory.addProduct(drill);
            } else {
                System.out.println("Ongeldig producttype.");
                return;
            }

            System.out.println("Het " + selectedProductType + " product is succesvol toegevoegd!");
        } else if (productChoice == 0) {
        } else {
            System.out.println("Ongeldige keuze. Terug naar het vorige menu.");
        }
    }
}