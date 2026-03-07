package org.example;

import java.sql.*;

public class Operation {
    public static void addProduct(int product_id,String product_name,String category,Double price,Double quantity,Double rating,String manufacturer) throws SQLException {

        String queue = "INSERT into products VALUES(product_id,product_name,category,price,quantity,rating,manufacturer)"
                +
        Connection conn=Question.getConnection();
        Statement statement=conn.createStatement();
        if(rowsInserted > 0){
            System.out.println(rowsInserted + "row inserted");
        } else {
            System.out.println("Insert failed");
       }
    }
    public static void fetch(ResultSet rs) throws SQLException {
        while(rs.next()){
            Double id = rs.getDouble("empno");
            String name = rs.getString("ename");
            String country = rs.getString("job");

            System.out.println(id + " | " + name + " | " + country);
        }
    }
}
