package preparedstatements;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreferredStatement {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_db",
                "root",
                "root"
        );
        //------------INERT----------

//        String insertQuery = "INSERT INTO emp VALUES (?,?,?,?,?,?,?,?)";
//
//        PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
//        insertStmt.setDouble(1,1);
//        insertStmt.setString(2,"benjii");
//        insertStmt.setString(3,"killing");
//        insertStmt.setDouble(4,5);
//        insertStmt.setDate(5,java.sql.Date.valueOf("1991-06-09"));
//        insertStmt.setDouble(6,5478.50);
//        insertStmt.setDouble(7,654);
//        insertStmt.setDouble(8,10);
//
//        int rowInserted = insertStmt.executeUpdate();
//        if(rowInserted>0){
//            System.out.println(rowInserted + " row inserted");
//        } else {
//            System.out.println("insert failed");
//        }

        //-------------UPDATE---------
//        String updatequerry = "UPDATE emp SET job = ? WHERE empno = ?";
//        PreparedStatement updateStmt = connection.prepareStatement(updatequerry);
//
//        updateStmt.setString(1,"PLUMBER");
//        updateStmt.setDouble(2,1);
//
//        int rowsUpdated = updateStmt.executeUpdate();
//        if(rowsUpdated > 0){
//            System.out.println(rowsUpdated + " row updated");
//        }else{
//            System.out.println("update failer");
//        }

        //-------------DELETE----------.
        String deletequerry = "DELETE FROM emp WHERE empno=? ";
        PreparedStatement deleteStmt = connection.prepareStatement(deletequerry);
        deleteStmt.setInt(1,1);

        int rowsdelete = deleteStmt.executeUpdate();
        if(rowsdelete > 0){
            System.out.println(deletequerry + "row delete");
        }else{
            System.out.println("delete not done");
        }
    }
}
