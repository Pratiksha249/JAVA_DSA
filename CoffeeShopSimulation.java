import java.util.LinkedList;
import java.util.Queue;

// Custom exception for empty counter
class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

// Shared Counter class for synchronization
class Counter {
    private final int capacity = 3; // Maximum capacity of the counter
    private final Queue<String> coffeeCounter = new LinkedList<>();

    // Method for baristas to add coffee
    public synchronized void addCoffee(String coffee, String baristaName) throws InterruptedException {
        while (coffeeCounter.size() == capacity) {
            System.out.println(baristaName + " is waiting. Counter is full.");
            wait(); // Wait if the counter is full
        }
        coffeeCounter.add(coffee);
        System.out.println(baristaName + " prepared coffee. Counter: " + coffeeCounter.size());
        notifyAll(); // Notify waiting customers or reviewer
    }

    // Method for customers to pick up coffee
    public synchronized String pickUpCoffee(String customerName) throws InterruptedException, CounterEmptyException {
        while (coffeeCounter.isEmpty()) {
            System.out.println(customerName + " is waiting. Counter is empty.");
            wait(); // Wait if the counter is empty
        }
        String coffee = coffeeCounter.poll();
        System.out.println(customerName + " picked up coffee. Counter: " + coffeeCounter.size());
        notifyAll(); // Notify waiting baristas
        return coffee;
    }

    // Method for the reviewer to sample coffee
    public synchronized String sampleCoffee() throws InterruptedException, CounterEmptyException {
        while (coffeeCounter.isEmpty()) {
            System.out.println("Reviewer is waiting. Counter is empty.");
            wait(); // Wait if the counter is empty
        }
        String coffee = coffeeCounter.poll();
        System.out.println("Coffee Reviewer sampled coffee. Counter: " + coffeeCounter.size());
        notifyAll(); // Notify waiting baristas
        return coffee;
    }
}

// Barista thread
class Barista extends Thread {
    private final Counter counter;
    private final int coffeeCount;
    private final String name;

    public Barista(String name, Counter counter, int coffeeCount) {
        this.name = name;
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.addCoffee("Coffee", name);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }
}

// Customer thread
class Customer extends Thread {
    private final Counter counter;
    private final int coffeeCount;
    private final String name;

    public Customer(String name, Counter counter, int coffeeCount) {
        this.name = name;
        this.counter = counter;
        this.coffeeCount = coffeeCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < coffeeCount; i++) {
                counter.pickUpCoffee(name);
            }
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println(name + " encountered an issue: " + e.getMessage());
        }
    }
}

// Reviewer thread
class Reviewer extends Thread {
    private final Counter counter;

    public Reviewer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.sampleCoffee();
        } catch (InterruptedException | CounterEmptyException e) {
            System.out.println("Reviewer encountered an issue: " + e.getMessage());
        }
    }
}

// Main Simulation Class
public class CoffeeShopSimulation {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Baristas
        Barista barista1 = new Barista("Barista 1", counter, 2);
        Barista barista2 = new Barista("Barista 2", counter, 3);

        // Customers
        Customer customer1 = new Customer("Customer 1", counter, 1);
        Customer customer2 = new Customer("Customer 2", counter, 2);
        Customer customer3 = new Customer("Customer 3", counter, 1);

        // Reviewer
        Reviewer reviewer = new Reviewer(counter);

        // Start threads
        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();
    }
}
