import java.util.Scanner;

public class RentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductInventory productInventory = new ProductInventory();
        ProductFactory productFactory = new DefaultProductFactory();


        Medewerker medewerker1 = new Medewerker("user1", "password1");
        Medewerker medewerker2 = new Medewerker("user2", "password2");
        ProductOverview overviewWindow = new ProductOverview();

        productInventory.addMedewerker(medewerker1);
        productInventory.addMedewerker(medewerker2);
       Inlogvenster inlogvenster = new Inlogvenster(productInventory, productFactory);

        inlogvenster.login();
        inlogvenster.openMenu(medewerker1.getUsername());

    }
}