package c2;
public class SortingTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("003", "Alice", 150.75),
            new Order("001", "Bob", 200.50),
            new Order("002", "Charlie", 120.00),
            new Order("004", "Diana", 175.25)
        };

        System.out.println("Before Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        SortingUtil.bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        orders = new Order[]{
            new Order("003", "Alice", 150.75),
            new Order("001", "Bob", 200.50),
            new Order("002", "Charlie", 120.00),
            new Order("004", "Diana", 175.25)
        };

        System.out.println("\nBefore Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        SortingUtil.quickSort(orders, 0, orders.length - 1);

        System.out.println("\nAfter Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
