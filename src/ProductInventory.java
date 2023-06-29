import java.util.ArrayList;
import java.util.List;

class ProductInventory implements Subject {
    private List<Observer> observers;
    private List<Product> products;
    private List<Medewerker> medewerkers;


    public ProductInventory() {
        observers = new ArrayList<>();
        products = new ArrayList<>();
        medewerkers = new ArrayList<>();
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

    public void removeProduct(Product product) {
        products.remove(product);
        notifyObservers();
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

// Observer interface for Observer pattern
