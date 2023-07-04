import java.util.List;

class ProductOverview implements ProductObserver {
    @Override
    public void update(List<Product> products) {
        showProductOverview(products);
    }

    private void showProductOverview(List<Product> products) {
        System.out.println("Product Overview:");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". Name: " + product.getName());
            System.out.println("Description: " + product.getOmschrijving());
            System.out.println("Availability: " + product.isAvailable());
            System.out.println("----------------------");
        }
    }
}
