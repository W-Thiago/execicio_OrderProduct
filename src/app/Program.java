package app;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clienteName = sc.nextLine();
        System.out.print("Email: ");
        String clienteEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clienteBirth = sdf.parse(sc.next());

        Client client = new Client(clienteName, clienteEmail, clienteBirth);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status,client);

        System.out.print("How many items to this order? ");
        int item = sc.nextInt();

        for (int i=1; i<=item; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            Product product = new Product (name, price);
            OrderItem orderItem =  new OrderItem (quantity, price, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);









        sc.close();

    }
}
