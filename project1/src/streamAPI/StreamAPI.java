package streamAPI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class StreamAPI {
    static void main(String[] args) {
        List<String> immutableList = Stream.of("red","green",null,null).toList();
        System.out.println(immutableList);
        //immutableList.add("yellow");
        System.out.println("------------------    ");
        List<String> mutableList = Stream.of("red","green",null,null).collect(Collectors.toList());
        System.out.println(mutableList);
        mutableList.add("orange");
        mutableList.add("yellow");
        System.out.println(mutableList);
        System.out.println("---------------    ");

        record Product(String name, String category, int price){
        }
        Stream<Product> products = Stream.of(new Product("bat","sportsitem",4000),
                new Product("bells","sportsitem",4000),
                new Product("ball","sportsitem",2000),
                new Product("mobile","item",14000),
                new Product("laptop","item",40000));
//        Map<String,List<Product>> categoryMap = products.collect(Collectors.groupingBy(Product::category));
//        System.out.println(categoryMap);
//        Map<String,Integer> pricing=products.collect(Collectors.groupingBy(Product::category,Collectors.summingInt(Product::price)));
//        System.out.println(pricing);
//        Map<String,Double> avg=products.collect(Collectors.groupingBy(Product::category,Collectors.averagingDouble(Product::price)));
//        System.out.println(avg);

        //Filtering
//        List<Product> filtered =products.filter(Product->Product.price>2500).collect(Collectors.toList());
//        System.out.println(filtered);

        //Mapping extracting product fields
//        var extractfields =products.map(Product::price).toList();
//        System.out.println(extractfields);

        //Partition based on condition
//        Map<Boolean,List<Product>> part=products.collect(Collectors.partitioningBy(Product->Product.price>1000));
//        System.out.println(part);

        //give count ,max,min,sum,avg
//        System.out.println(products.collect(Collectors.summarizingInt(Product::price)));

        Map<String, DoubleSummaryStatistics> summerized=products.collect(Collectors.groupingBy(Product::category,Collectors.summarizingDouble(Product::price)));
        System.out.println(summerized);
    }
}
