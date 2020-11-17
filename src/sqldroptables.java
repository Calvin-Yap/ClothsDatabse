import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class sqldroptables {   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("oracle.jdbc.OracleDriver");
      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(dbURL1);

      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Deleting database...");
      stmt = conn.createStatement();
      
      String table1 = "DROP TABLE customer_with_online_profile";
      String table2 = "DROP TABLE store_customers";  
      String table3 = "DROP TABLE store_employees";
      String table4 = "DROP TABLE store_stock";
      String table5 = "DROP TABLE employee_sales";
      String table6 = "DROP TABLE purchases";
      String table7 = "DROP TABLE online_profiles";
      String table8 = "DROP TABLE customers";
      String table9 = "DROP TABLE employees";
      String table10 = "DROP TABLE clothing";
      String table11 = "DROP TABLE stores";


      stmt.executeUpdate(table1);
      stmt.executeUpdate(table2);
      stmt.executeUpdate(table3);
      stmt.executeUpdate(table4);
      stmt.executeUpdate(table5);
      stmt.executeUpdate(table6);
      stmt.executeUpdate(table7);
      stmt.executeUpdate(table8);
      stmt.executeUpdate(table9);
      stmt.executeUpdate(table10);
      stmt.executeUpdate(table11);
      
      System.out.println("Database deleted successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample