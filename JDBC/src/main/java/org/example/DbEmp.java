package org.example;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class DbEmp {
    public static void main(String[] args) throws SQLException {
        //1) Load and register driver
        Driver driver=new Driver();
        DriverManager.registerDriver(driver);

        //2) create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_db",
                "root",
                "root"
        );
        //3) Create Statement
        Statement statement = connection.createStatement();

        //------INSERT---------

//        int rowsInserted = statement.executeUpdate(
//                "INSERT INTO emp VALUES('7379','SMITHgarg','CLERK','7902','1980-12-17','827.00',NULL,'20')"
//        );
//        if(rowsInserted > 0){
//            System.out.println(rowsInserted + "row inserted");
//        } else {
//            System.out.println("Insert failed");
//        }

        //-------------FETCH-----------

        ResultSet rs = statement.executeQuery(
                "SELECT * FROM emp"
        );
        while(rs.next()){
            Double id = rs.getDouble("empno");
            String name = rs.getString("ename");
            String country = rs.getString("job");

            System.out.println(id + " | " + name + " | " + country);
        }

        //-------------UPDATE-------------
//        int rowsUpdated = statement.executeUpdate(
//                "UPDATE emp SET job = 'COOL' WHERE deptno = '20' "
//        );
//        if(rowsUpdated > 0){
//            System.out.println(rowsUpdated + " row updated ");
//        } else {
//            System.out.println("Update failed");
//        }

        //----------DELETE-----------
//        int rowsDeleted = statement.executeUpdate(
//                "DELETE FROM emp WHERE deptno=20"
//        );
//        if(rowsDeleted>0){
//            System.out.println(rowsUpdated + " row deleted");
//        } else{
//            System.out.println("delete failed");
//        }
    }
}
