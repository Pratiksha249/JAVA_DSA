import java.util.*;

// Same Customer, Product, and Order classes

public class Amazon{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList for dynamic storage
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();
        ArrayList<Order> orderList = new ArrayList<>();

        // HashMap for fast retrieval
        HashMap<Integer, Customer> customerMap = new HashMap<>();
        HashMap<Integer, Product> productMap = new HashMap<>();

        // HashSet for unique products
        HashSet<Product> uniqueProducts = new HashSet<>();

        try {
            // Adding customers dynamically
            System.out.println("Enter the number of customers:");
            int numCustomers = Integer.parseInt(scanner.nextLine()); // Use nextLine for safe parsing

            for (int i = 0; i < numCustomers; i++) {
                System.out.println("Enter customer ID:");
                int customerId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter customer name:");
                String name = scanner.nextLine();

                System.out.println("Enter loyalty points:");
                int loyaltyPoints = Integer.parseInt(scanner.nextLine());

                Customer customer = new Customer(customerId, name, loyaltyPoints);
                customerList.add(customer);
                customerMap.put(customerId, customer);
            }

            // Adding products dynamically
            System.out.println("Enter the number of products:");
            int numProducts = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numProducts; i++) {
                System.out.println("Enter product ID:");
                int productId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter product name:");
                String productName = scanner.nextLine();

                System.out.println("Enter product price:");
                double price = Double.parseDouble(scanner.nextLine());

                Product product = new Product(productId, productName, price);
                productList.add(product);
                productMap.put(productId, product);
                uniqueProducts.add(product);
            }

            // Adding orders dynamically
            System.out.println("Enter the number of orders:");
            int numOrders = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < numOrders; i++) {
                System.out.println("Enter order ID:");
                int orderId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter customer ID for the order:");
                int customerId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter delivery date (yyyy-MM-dd):");
                String dateInput = scanner.nextLine();
                Date deliveryDate = new Date();
                try {
                    deliveryDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
                } catch (Exception e) {
                    System.out.println("Invalid date format. Using current date.");
                }

                Order order = new Order(orderId, customerId, deliveryDate);
                orderList.add(order);
            }

            // TreeSet with custom sorting for products by price
            TreeSet<Product> sortedProducts = new TreeSet<>(new ProductPriceComparator());
            sortedProducts.addAll(productList);

            // TreeSet with custom sorting for customers by loyalty points
            TreeSet<Customer> sortedCustomers = new TreeSet<>(new CustomerLoyaltyComparator());
            sortedCustomers.addAll(customerList);

            // Displaying sorted products
            System.out.println("Products sorted by price:");
            for (Product product : sortedProducts) {
                System.out.println(product);
            }

            // Displaying sorted customers
            System.out.println("\nCustomers sorted by loyalty points:");
            for (Customer customer : sortedCustomers) {
                System.out.println(customer);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter valid integers or doubles.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
