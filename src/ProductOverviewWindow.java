import java.util.ArrayList;
import java.util.List;

class ProductOverviewWindow implements Observer {
    private ProductInventory productInventory;

    public ProductOverviewWindow(ProductInventory productInventory) {
        this.productInventory = productInventory;
        productInventory.registerObserver(this);
    }

    public void display() {
        List<Product> products = productInventory.getProducts();
        System.out.println("Product Overview:");

        for (Product product : products) {
            String availability = product.isAvailable() ? "Yes" : "No";
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getShortDescription());
            System.out.println("Availability: " + availability);
            System.out.println();
        }
    }

    @Override
    public void update(Subject subject) {

        display();
    }
}