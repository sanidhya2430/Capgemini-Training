package callable;

import java.sql.CallableStatement;
import java.sql.Connection;

public class EmployeeService {
    public void insertEmployee(String name,double salary) {
        String sql = "{CALL Insertemployees(?,?)}";
        try(Connection conn = Databaseutil.getConnection();
            CallableStatement stmt= conn.prepareCall(sql)){
            stmt.setString(1,name);
            stmt.setDouble(2,salary);
            stmt.execute();
            System.out.println("Employee inserted successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
