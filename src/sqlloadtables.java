import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class sqlloadtables {   
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
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
     
      String sql = "INSERT INTO stores VALUES(001, 'Cloths Toronto', '123 Main St', 'Toronto')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO stores VALUES(002, 'Cloths Eaton Centre', '12 Street St', 'Toronto')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO stores VALUES(003, 'Cloths Atrium', '78 Yonge St', 'Markham')";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO employees VALUES(101, 'John Smith', '905-123-4321', '12 Desk Ave', 'Toronto', 'Manager')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(102, 'Jane Doe', '647-123-4321', '13 Table Ave', 'Toronto', 'Sales Associate')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(103, 'Johnathan Barnes', '416-123-4321', '123 Lamp Ave', 'Toronto', 'Sales Associate')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(104, 'Evan Bell', '216-123-4321', '124 Church St', 'Toronto', 'Manager')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(105, 'Jenson Riley', '905-555-4321', '43 Floor St', 'Hamilton', 'Sales Associate')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(106, 'Sebastian Rowe', '905-888-4333', '2438 Tissue Ave', 'Scarborough', 'Sales Associate')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(107, 'Leslie Wright', '647-453-4321', '99 Phone Crescent', 'Toronto', 'Manager')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(108, 'Alex Taylor', '416-420-6969', '14 Bed Ave', 'Markham', 'Sales Associate')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employees VALUES(109, 'Logan Adams', '905-12-1112', '88 Scissors Ave', 'Richmond Hill', 'Sales Associate')";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO clothing VALUES(201, 'Denim Jacket', 'Blue', 'Large', 89.99)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO clothing VALUES(202, 'Light Down Jacket', 'Yellow', 'Medium', 99.99)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO clothing VALUES(203, 'Graphic T-Shirt', 'White', 'Small', 39.99)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO clothing VALUES(204, 'Hooded Sweater', 'Black', 'Medium', 59.99)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO clothing VALUES(205, 'Tank Top', 'Red', 'Large', 19.99)";
      stmt.executeUpdate(sql);

      sql ="INSERT INTO customers VALUES(301, 'Cameron Holmes', '905-146-4654', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(302, 'Kayden Wright', '905-743-4239', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(303, 'Isabel Harvey', '647-432-6259', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(304, 'Isla Thompson', '905-732-5639', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(305, 'Amelie Adams', '905-432-4265', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(306, 'Haiden Pearson', '647-732-1229', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(307, 'Jordan Davis', '416-722-6669', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(308, 'Eli Scott', '416-222-4344', 'NO')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customers VALUES(309, 'Ashley Jensen', '905-762-4939', 'NO')";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO online_profiles VALUES('cholmes', 'helloworld2', 'cholmes@cloths.com', 1234567890123456, '123 Holmes St', 'Toronto')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('heyitsisabel', 'isabel84jh8', 'isabelharvey@cloths.com', 2345678901234567, '3 Harvey St', 'Scarborough')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('islaT', 'TTT463278', 'islaThompson@cloths.com', 3456789012345678, '12 Thompson Ave', 'Brampton')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('ameadams', 'q1w2e3r4t5y', 'amelie996@cloths.com', 4567890123456789, '44 Adams St', 'Toronto')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('hydnprsn', 'a9z8x7c7v@@', 'hayhaydenP@cloths.com', 5678901234567890, '123 Pearson St', 'Toronto')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('jordan66', 'jordan94327', 'jjdavis@cloths.com', 7890123456789012, '7 Davis St', 'North York')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO online_profiles VALUES('jensenly', 'ashley4322', 'ashleyjensen@cloths.com', 8901234567890123, '4327 Jensen St', 'Markham')";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO customer_with_online_profile VALUES(301, 'cholmes')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(303, 'heyitsisabel')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(304, 'islaT')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(305, 'ameadams')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(306, 'hydnprsn')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(307, 'jordan66')";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO customer_with_online_profile VALUES(308, 'jensenly')";
      stmt.executeUpdate(sql);

      sql ="UPDATE customers SET customers.has_account = 'YES' WHERE customers.customer_id IN (SELECT customer_id FROM customer_with_online_profile)";
      stmt.executeUpdate(sql);

      sql ="INSERT INTO purchases VALUES(9901, 301, 201)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9902, 301, 202)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9903, 301, 203)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9904, 302, 204)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9905, 303, 201)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9906, 303, 205)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9907, 304, 203)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9908, 304, 205)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9909, 301, 204)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9910, 305, 202)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9911, 306, 201)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9912, 307, 205)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9913, 307, 203)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9914, 308, 205)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9915, 309, 201)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9916, 309, 201)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO purchases VALUES(9917, 309, 202)";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO employee_sales VALUES(101, 9901)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(101, 9902)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(102, 9903)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(103, 9904)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(104, 9905)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(105, 9906)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(106, 9907)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(107, 9908)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(108, 9909)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(109, 9910)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(109, 9911)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(108, 9912)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(102, 9913)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(103, 9914)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(106, 9915)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(107, 9916)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO employee_sales VALUES(105, 9917)";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO store_employees VALUES(001, 101)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(002, 102)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(003, 103)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(003, 104)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(002, 105)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(001, 106)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(002, 107)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(003, 108)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_employees VALUES(001, 109)";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO store_customers VALUES(001, 301)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(001, 302)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(001, 303)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(002, 304)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(002, 305)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(002, 306)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(003, 307)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(003, 308)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_customers VALUES(003, 309)";
      stmt.executeUpdate(sql);
      
      sql ="INSERT INTO store_stock VALUES(001, 201, 10)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(001, 202, 4)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(001, 203, 21)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(002, 204, 5)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(002, 205, 8)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(002, 201, 11)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(003, 202, 2)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(003, 203, 1)";
      stmt.executeUpdate(sql);
      sql ="INSERT INTO store_stock VALUES(003, 205, 12)";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");
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