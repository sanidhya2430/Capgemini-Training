package app;

import dao.ProductDAO;
import model.Product;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n===== PRODUCT INVENTORY MENU =====");

            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. View Product By ID");
            System.out.println("4. Update Product Price");
            System.out.println("5. Update Product Quantity");
            System.out.println("6. Delete Product");
            System.out.println("7. Search Product By Name");
            System.out.println("8. Show Low Stock Products");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();

                    Product p = new Product(id, name, cat, price, qty, rating);

                    dao.addProduct(p);

                    break;

                case 2:
                    dao.viewAllProducts();
                    break;

                case 3:

                    System.out.print("Enter Product ID: ");
                    dao.viewProductById(sc.nextInt());
                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updatePrice(pid, newPrice);

                    break;

                case 5:

                    System.out.print("Enter ID: ");
                    int id2 = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int q = sc.nextInt();

                    dao.updateQuantity(id2, q);

                    break;

                case 6:

                    System.out.print("Enter Product ID: ");
                    dao.deleteProduct(sc.nextInt());

                    break;

                case 7:

                    sc.nextLine();
                    System.out.print("Enter keyword: ");
                    dao.searchProduct(sc.nextLine());

                    break;

                case 8:

                    dao.lowStockProducts();

                    break;

                case 9:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}