package LinearSearch;

import java.util.ArrayList;

public class CarSearch {
    ArrayList<Car> cars = new ArrayList<>();

    public CarSearch() {
        cars.add(new Car("Ford", "Mustang", "Blue", 38320.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Camry", "Green", 28484.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Red", 31984.00, "DEALER TRADE"));
        cars.add(new Car("Ford", "Mustang", "Red", 41000.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Camry", "Blue", 31044.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Green", 28484.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Blue", 30990.00, "FACTORY ORDER"));
        cars.add(new Car("Toyota", "Corolla", "Green", 23450.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Red", 25500.00, "IN STOCK"));
        cars.add(new Car("Ford", "Escort", "Red", 38849.00, "FACTORY ORDER"));
        cars.add(new Car("Toyota", "Corolla", "Blue", 28959.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Green", 28462.00, "IN STOCK"));
        cars.add(new Car("Ford", "Mustang", "Blue", 70990.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Camry", "Green", 32248.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Accord", "Red", 33984.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Mustang", "Red", 55600.00, "DEALER TRADE"));
        cars.add(new Car("Toyota", "Camry", "Blue", 29755.00, "IN STOCK"));
        cars.add(new Car("Honda", "Accord", "Green", 29758.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Blue", 35838.00, "DEALER TRADE"));
        cars.add(new Car("Toyota", "Corolla", "Green", 25324.00, "IN STOCK"));
        cars.add(new Car("Honda", "Civic", "Red", 28484.00, "FACTORY ORDER"));
        cars.add(new Car("Ford", "Escort", "Red", 33000.00, "IN STOCK"));
        cars.add(new Car("Toyota", "Corolla", "Blue", 24428.00, "DEALER TRADE"));
        cars.add(new Car("Honda", "Civic", "Green", 28583.00, "FACTORY ORDER"));
    }

    public ArrayList<Car> searchAvailability(String availability) {
        ArrayList<Car> results = new ArrayList<>();

        for (Car car : cars) {
            if (car.availability.equals(availability)) {
                results.add(car);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No cars found with availability: " + availability + ". Please modify your search and try again.");
        }

        return results;
    }

    public ArrayList<Car> searchPrice(double priceLimit, boolean lowerThan) {
        ArrayList<Car> results = new ArrayList<>();

        for (Car car : cars) {
            if ((lowerThan && car.price <= priceLimit) || (!lowerThan && car.price > priceLimit)) {
                results.add(car);
            }
        }

        if (results.isEmpty()) {
            if (lowerThan) {
                System.out.println("No cars found with price less than or equal to $" + priceLimit + ". Please modify your search and try again.");
            } else {
                System.out.println("No cars found with price greater than $" + priceLimit + ". Please modify your search and try again.");
            }
        }

        return results;
    }

    public ArrayList<Car> search(String make, String model, String color) {
        ArrayList<Car> results = new ArrayList<>();

        for (Car car : cars) {
            if (car.make.equals(make) && car.model.equals(model) && car.color.equals(color)) {
                results.add(car);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No cars found matching the search criteria. Please modify your search and try again.");
        }

        return results;
    }

    public static void main(String[] args) {
        CarSearch carSearch = new CarSearch();

        System.out.println("\nList cars IN STOCK");
        ArrayList<Car> carsFound = carSearch.searchAvailability("IN STOCK");
        if (carsFound != null) {
            for (Car car : carsFound) {
                System.out.println(car);
            }
        }

        System.out.println("\nList all Red, Ford Mustangs");
        carsFound = carSearch.search("Ford", "Mustang", "Red");
        if (carsFound != null) {
            for (Car car : carsFound) {
                System.out.println(car);
            }
        }

        System.out.println("\nList all cars under $25,000.00");
        carsFound = carSearch.searchPrice(25000.00, true);
        if (carsFound != null) {
            for (Car car : carsFound) {
                System.out.println(car);
            }
        }

        System.out.println();
    }
}