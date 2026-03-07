package org.example;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("--------CRUD Operation--------");
            System.out.println("1: INSERT");
            System.out.println("2: VIEW");
            System.out.println("3: update");
            System.out.println("4: delete");
            System.out.println("5: EXIT");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            switch(choice){
                case 1://int product_id,String product_name,String category,Double price,Double quantity,Double rating,String manufacturer
                    System.out.println("enter product id");
                    sc.nextLine();
                    int product_id = sc.nextInt();
                    System.out.println("enter product name");
                    String product_name = sc.nextLine();
                    System.out.println("enter category");
                    String category = sc.nextLine();
                    System.out.println("enter price");
                    Double price = sc.nextDouble();
                    System.out.println("enter quantity");
                    Double quantity = sc.nextDouble();
                    System.out.println("enter rating");
                    Double rating = sc.nextDouble();;
                    sc.hasNextLine();
                    System.out.println("enter manufacturer");
                    String manufacturer = sc.nextLine();

                    Operation.addProduct(product_id,product_name,category,price,quantity,rating,manufacturer);
                    break;


                case 2:
            }
        }
    }
}
