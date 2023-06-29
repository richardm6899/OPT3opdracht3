import java.util.List;
import java.util.Scanner;

class Inlogvenster {
    private ProductInventory productInventory;

    public Inlogvenster(ProductInventory productInventory) {
        this.productInventory = productInventory;
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

    private void openMenu(String username) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.println("Menuvenster voor medewerker: " + username);
            System.out.println("1. Overzicht");
            System.out.println("2. Beheer");
            System.out.println("3. Uitloggen");
            System.out.print("Selecteer een optie: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Implementeer logica voor Overzicht
                    ProductOverviewWindow productOverviewWindow = new ProductOverviewWindow(productInventory);
                    productOverviewWindow.display();
                    Product car1 = new Car("Civic", 50, 0.01, "Honda", 1000, 50);
                    Product car2 = new Car("SUV", 50, 0.01, "Nissan", 1200, 50);
                    Product car3 = new Car("KUGA", 50, 0.01, "FORD", 1100, 50);
                    productInventory.addProduct(car1);
                    productInventory.addProduct(car2);
                    productInventory.addProduct(car3);
                    Product truck1 = new Truck("BigTruck", 0.10, 0.01, 2000, 10000);
                    Product truck2 = new Truck("FarmersTruck", 0.10, 0.01, 4000, 12000);
                    Product truck3 = new Truck("Jumbo", 0.10, 0.01, 3000, 12000);
                    productInventory.addProduct(truck1);
                    productInventory.addProduct(truck2);
                    productInventory.addProduct(truck3);
                    Product drill1 = new Drill("DCD791P2-QW", 5, 1, "DeWalt", "Type 1");
                    Product drill2 = new Drill("DHR243ZJW", 5, 1, "Makita", "Type 2");
                    Product drill3 = new Drill("PBD 40", 5, 1, "BOSCH", "Type 2");
                    productInventory.addProduct(drill1);
                    productInventory.addProduct(drill2);
                    productInventory.addProduct(drill3);
                    showProductOverview();
                    break;
                case 2:
                    // Implementeer logica voor Beheer
                    System.out.println("Beheer");
                    break;
                case 3:
                    System.out.println("Uitgelogd");
                    isLoggedIn = false; // Uitloggen, de lus wordt verlaten
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }

            System.out.println();
        }
        login();
    }
    private void showProductOverview() {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = productInventory.getProducts();
        System.out.println("Product Overview:");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String availability = product instanceof Car ? "Yes" : "No";
            System.out.println((i + 1) + ". " + product.getShortDescription() + " (Available: " + availability + ")");
        }

        System.out.print("Selecteer een product (0 om terug te gaan): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (choice >= 1 && choice <= products.size()) {
            Product selectedProduct = products.get(choice - 1);
            displayProductDetails(selectedProduct);
        } else if (choice == 0) {
            // Terug naar het vorige menu
        } else {
            System.out.println("Ongeldige keuze. Terug naar het vorige menu.");
        }
    }

    private void displayProductDetails(Product product) {
        System.out.println("Product Details:");
        product.displayDetails();
    }
    private void showProductTypes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecteer een producttype:");

        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("3. Drill");

        System.out.print("Selecteer een optie (0 om terug te gaan): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                Car.addCar();
                break;
            case 2:
                addTruck();
                break;
            case 3:
                addDrill();
                break;
            case 0:
                // Terug naar het vorige menu
                break;
            default:
                System.out.println("Ongeldige keuze. Terug naar het vorige menu.");
        }
    }