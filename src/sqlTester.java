import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class sqlTester {   
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
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String table1 ="CREATE TABLE stores " +
              "(store_id INTEGER not NULL, " +
              " store_name VARCHAR(25) not NULL, " + 
              " store_address VARCHAR(50) not NULL, " + 
              " store_city VARCHAR(20), " + 
              " PRIMARY KEY ( store_id ))";
      
      String table2 = "CREATE TABLE employees " +
              	"(emp_id INTEGER not NULL, "+
              	"emp_name VARCHAR(50) not NULL,"+
              	"emp_phone VARCHAR(12) Default '000-000-0000',"+
              	"emp_address VARCHAR(50),"+
              	"emp_city VARCHAR(50),"+
              	"emp_position VARCHAR(50),"+
              	"PRIMARY KEY (emp_id))";//employees
      
      String table3 = "CREATE TABLE customers "+ 
    				 "(customer_id INTEGER not NULL,"+
    				 "customer_name VARCHAR(50) not NULL,"+
    				 "customer_phone VARCHAR(12) Default '000-000-0000',"+
    				 "has_account VARCHAR(10) Default 'No',"+
    				 "PRIMARY KEY (customer_id))";// customers
      
      String table4 = "CREATE TABLE online_profiles "+
    				 "(username VARCHAR(20),"+
    				 "password VARCHAR(20),"+
    				 "email VARCHAR(30),"+
    				 "credit_card INTEGER,"+
    				 "shipping_address VARCHAR(50),"+
    				 "shipping_city VARCHAR(20),"+
    				 "PRIMARY KEY(username))";// online_profiles
      
      String table5= " CREATE TABLE clothing"+ 
    				 "(clothing_id INTEGER, " +
    				 "clothing_type VARCHAR(20) not NULL, "+
    				 "colour VARCHAR(15) Default 'black', " +
    				 "clothing_size VARCHAR(15) Default 'small', "+
    				 "price FLOAT not NULL, " +
    				 "PRIMARY KEY(clothing_id))";// clothing
      
      String table6 = "CREATE TABLE purchases" +
    		  "(transaction# INTEGER, " +
    		  "customer_id INTEGER not NULL, " +
    		  "clothing_id INTEGER, " +
    		  "PRIMARY KEY (transaction#), "+
    		  "FOREIGN KEY (customer_id) references customers, " +
    		  "FOREIGN KEY (clothing_id) references clothing)" ;
      
      String table7 = "CREATE TABLE employee_sales"+
    		  "(emp_id INTEGER not NULL, " +
    		  "transaction# INTEGER not NULL, "+
    		  "FOREIGN KEY (emp_id) references employees, " +
    		  "FOREIGN KEY (transaction#) references purchases)";
      
      String table8 = "CREATE TABLE store_stock"+
    		  "(store_id INTEGER, " +
    		  "clothing_id INTEGER, "+
    		  "quantity INTEGER, "+
    		  "FOREIGN KEY(store_id) references stores, "+
    		  "FOREIGN KEY(clothing_id) references clothing)";
      
      String table9 = "CREATE TABLE store_employees" +
    		  "( store_id INTEGER, " +
    		  "emp_id INTEGER, " +
    		  "FOREIGN KEY(store_id) references stores, " +
    		  "FOREIGN KEY(emp_id) references employees)";
      
      String table10 = "CREATE TABLE store_customers" +
    		  "( store_id INTEGER, "+
    		  "customer_id INTEGER," +
    		  "FOREIGN KEY(store_id) references stores, " +
    		  "FOREIGN KEY(customer_id) references customers)";
      
      String table11 = "CREATE TABLE customer_with_online_profile"+
    		  "(customer_id INTEGER, " +
    		  "username VARCHAR(20)," +
    		  "FOREIGN KEY (customer_id) references customers, "+ 
    		  "FOREIGN KEY (username) references online_profiles)";


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
      
      System.out.println("Created table in given database...");
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