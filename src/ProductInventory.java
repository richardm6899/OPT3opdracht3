import java.util.ArrayList;
import java.util.List;

class ProductInventory implements Subject {
    private List<Product> products;
    private List<ProductObserver> observers;
    private List<Medewerker> medewerkers;


    public ProductInventory() {
        observers = new ArrayList<>();
        products = new ArrayList<>();
        medewerkers = new ArrayList<>();
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    public void removeProductObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ProductObserver observer : observers) {
            observer.update(products);
        }
    }

    public List<Medewerker> getMedewerkers() {
        return medewerkers;
    }

    public void addProduct(Product product) {
        products.add(product);
        notifyObservers();
    }

    public void addMedewerker(Medewerker medewerker) {
        medewerkers.add(medewerker);
    }


    public List<Product> getProducts() {
        return products;
    }

    public List<String> getProductTypes() {
        List<String> productTypes = new ArrayList<>();

        for (Product product : products) {
            String productType = product.getProductType();

            if (!productTypes.contains(productType)) {
                productTypes.add(productType);
            }
        }

        return productTypes;
    }

}



