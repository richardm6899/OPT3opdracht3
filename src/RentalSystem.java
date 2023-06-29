import java.util.Scanner;

public class RentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create product inventory
        ProductInventory productInventory = new ProductInventory();
        Medewerker medewerker1 = new Medewerker("user1", "password1");
        Medewerker medewerker2 = new Medewerker("user2", "password2");
        ProductOverviewWindow overviewWindow = new ProductOverviewWindow(productInventory);

        productInventory.addMedewerker(medewerker1);
        productInventory.addMedewerker(medewerker2);
        Inlogvenster inlogvenster = new Inlogvenster(productInventory);


        // Add sample products

        inlogvenster.login();




       //overviewWindow.display();








        // Simulate user interactions


        // Simulate selecting a product for details view
      //  Product selectedProduct = car1;
      //  selectedProduct.displayDetails();

        // Simulate adding a new product
        Product newProduct = new Car("Car 3", 50, 0.01, "Brand 3", 1100, 2200);
        productInventory.addProduct(newProduct);

        // Simulate removing a product
        //productInventory.removeProduct(truck2);

        // Simulate selecting a different product for details view
      //  selectedProduct = drill1;
      //  selectedProduct.displayDetails();

    }
}