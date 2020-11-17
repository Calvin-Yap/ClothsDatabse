import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;


public class clothsmenu extends JFrame {
	private Connection conn1 = null;

	private static final int FRAME_WIDTH = 1600;
	private static final int FRAME_HEIGHT = 1000;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea actions = new JTextArea(30,70);

	private ArrayList<String> connection = new ArrayList<String>();
	private String createTables = "Inserting tables into database \n -stores created- \n -employees created- \n -customers created - \n -online profiles created - \n -clothing created - \n -purchases created - \n -employee_sales created - \n -store_stock created- \n -store_employees created- \n -store_customers created- \n -customer_with_online_profile created  ";
	private String dropTables = "Dropping tables in database \n -stores dropped- \n -employees dropped- \n -customers dropped - \n -online profiles dropped - \n -clothing dropped - \n -purchases dropped - \n -employee_sales dropped - \n -store_stock dropped- \n -store_employees dropped- \n -store_customers dropped- \n -customer_with_online_profile dropped ";
	private String loadData = "Data loaded in";
	private String addedData="Entry added please press load tables again";
	
	public clothsmenu() {
		JPanel mainPanel = new JPanel();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(createNorthPanel(),BorderLayout.NORTH);
		mainPanel.add(createWestPanel(),BorderLayout.WEST);
		mainPanel.add(createCenterPanel(),BorderLayout.CENTER);
		mainPanel.add(createEastPanel(),BorderLayout.EAST);
		getContentPane().add(mainPanel);

		setVisible(true);

	}
	public void getConnection() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
         String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
																						
			conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
            	connection.add("Connected to DB");
                //System.out.println("Connected with connection #1");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
     
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	public void dropTables() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs

		      conn = DriverManager.getConnection(dbURL1);
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
		      
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	
	public void createTables() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
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
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}

	public void loadData() {
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs

		      conn = DriverManager.getConnection(dbURL1);

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
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	

	ArrayList<String> EMP_Name =new ArrayList<String>();
	ArrayList<String> EMP_Phone =new ArrayList<String>();
	ArrayList<String> EMP_Address=new ArrayList<String>();
	ArrayList<String> EMP_City=new ArrayList<String>();
	ArrayList<String> EMP_Position =new ArrayList<String>();
	ArrayList<String> Store_Name =new ArrayList<String>();
	
	ArrayList<String> store_name =new ArrayList<String>();
  	ArrayList<String> clothing_type =new ArrayList<String>();
  	ArrayList<String> colour=new ArrayList<String>();
  	ArrayList<String> clothing_size=new ArrayList<String>();
  	ArrayList<String> quantity =new ArrayList<String>();
  	
 	ArrayList<String> store_name1 =new ArrayList<String>();
  	ArrayList<String> customer_name =new ArrayList<String>();
  	ArrayList<String> customer_phone=new ArrayList<String>();
  	ArrayList<String> has_account=new ArrayList<String>();
  	
  	ArrayList<String> customer_name2 =new ArrayList<String>();
  	ArrayList<String> username =new ArrayList<String>();
  	ArrayList<String> password=new ArrayList<String>();
  	ArrayList<String> email=new ArrayList<String>();
  	ArrayList<String> cusphone=new ArrayList<String>();
  	ArrayList<String> creditcard=new ArrayList<String>();
  	ArrayList<String> shipadd=new ArrayList<String>();
  	ArrayList<String> shipcity=new ArrayList<String>();
	
  	ArrayList<String> transaction=new ArrayList<String>();
  	ArrayList<String> clothing_type2 =new ArrayList<String>();
  	ArrayList<String> price=new ArrayList<String>();
  	ArrayList<String> customer_name3=new ArrayList<String>();
  	ArrayList<String> customer_phone3=new ArrayList<String>();
  	
  	ArrayList<String> emp_name1=new ArrayList<String>();
  	ArrayList<String> transaction1 =new ArrayList<String>();
  	ArrayList<String> clothingtype5=new ArrayList<String>();
  	ArrayList<String> pricey=new ArrayList<String>();
  	String resultsOfQ = "";
  	public void getDataEmp() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT employees.emp_name, employees.emp_phone, employees.emp_address, employees.emp_city, employees.emp_position, stores.store_name FROM ((store_employees INNER JOIN employees ON store_employees.emp_id = employees.emp_id)INNER JOIN stores ON store_employees.store_id = stores.store_id)ORDER BY employees.emp_id ASC";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         String Name  = rs.getString("EMP_Name");
		         EMP_Name.add(Name);
		         String Phone = rs.getString("EMP_Phone");
		         EMP_Phone.add(Phone);
		         String Address = rs.getString("EMP_Address");
		         EMP_Address.add(Address);
		         String City = rs.getString("EMP_City");
		         EMP_City.add(City);
		         String Position = rs.getString("EMP_Position");
		         EMP_Position.add(Position);
		         String Store = rs.getString("Store_Name");
		         Store_Name.add(Store);
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getStock() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT stores.store_name, clothing.clothing_type, clothing.colour, clothing.clothing_size, store_stock.quantity FROM ((store_stock INNER JOIN clothing ON store_stock.clothing_id = clothing.clothing_id) INNER JOIN stores ON store_stock.store_id = stores.store_id) ORDER BY stores.store_id ASC";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         String StoreName  = rs.getString("store_name");
			         store_name.add(StoreName);
			         String ClothingType = rs.getString("clothing_type");
			         clothing_type.add(ClothingType);
			         String Colour = rs.getString("colour");
			         colour.add(Colour);
			         String ClothingSize = rs.getString("clothing_size");
			         clothing_size.add(ClothingSize);
			         String Quantity = rs.getString("quantity");
			         quantity.add(Quantity);
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getOnlineusers() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT stores.store_name, customers.customer_name, customers.customer_phone, customers.has_account FROM ((store_customers INNER JOIN customers ON store_customers.customer_id = customers.customer_id) INNER JOIN stores ON store_customers.store_id = stores.store_id) ORDER BY stores.store_id ASC";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         String StoreName1  = rs.getString("store_name");
			         store_name1.add(StoreName1);
			         String Customer_Name = rs.getString("customer_name");
			         customer_name.add(Customer_Name);
			         String Customer_Phone = rs.getString("customer_phone");
			         customer_phone.add(Customer_Phone);
			         String Has_Account = rs.getString("has_account");
			         has_account.add(Has_Account);
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getPurchases() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT customers.customer_name, online_profiles.username, online_profiles.password, online_profiles.email, customers.customer_phone, online_profiles.credit_card, online_profiles.shipping_address, online_profiles.shipping_city FROM ((customer_with_online_profile INNER JOIN online_profiles ON customer_with_online_profile.username = online_profiles.username) INNER JOIN customers ON customer_with_online_profile.customer_id = customers.customer_id)";
		      ResultSet rs = stmt.executeQuery(sql);
		  	while(rs.next()){
		         String Customer_Name2  = rs.getString("customer_name");
		         customer_name2.add(Customer_Name2);
		         String Username = rs.getString("username");
		         username.add(Username);
		         String Password = rs.getString("password");
		         password.add(Password);
		         String Email = rs.getString("email");
		         email.add(Email);
		         String Cusphone = rs.getString("customer_phone");
		         cusphone.add(Cusphone);
		         String CreditCard = rs.getString("Credit_Card");
		         creditcard.add(CreditCard);
		         String Shipadd = rs.getString("Shipping_Address");
		         shipadd.add(Shipadd);
		         String Shipcity = rs.getString("Shipping_City");
		         shipcity.add(Shipcity);
	      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getSales() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT purchases.transaction#, clothing.clothing_type, clothing.price, customers.customer_name, customers.customer_phone FROM ((purchases INNER JOIN customers ON purchases.customer_id = customers.customer_id) INNER JOIN clothing ON purchases.clothing_id = clothing.clothing_id) ORDER BY purchases.transaction# ASC";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         String Transaction  = rs.getString("transaction#");
			         transaction.add(Transaction);
			         String clothtype = rs.getString("clothing_type");
			         clothing_type2.add(clothtype);
			         String prices = rs.getString("price");
			         price.add(prices);
			         String cusname2 = rs.getString("customer_name");
			         customer_name3.add(cusname2);
			         String Cusphone = rs.getString("customer_phone");
			         customer_phone3.add(Cusphone);

		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getCustomers() {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = "SELECT employees.emp_name, purchases.transaction#, clothing.clothing_type, clothing.price FROM ((employee_sales INNER JOIN purchases ON purchases.transaction# = employee_sales.transaction# INNER JOIN clothing ON clothing.clothing_id = purchases.clothing_id) INNER JOIN employees ON employees.emp_id = employee_sales.emp_id) ORDER BY purchases.transaction# ASC";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
			         String empnames  = rs.getString("EMP_Name");
			         emp_name1.add(empnames);
			         String transactions = rs.getString("Transaction#");
			         transaction1.add(transactions);
			         String prices = rs.getString("Clothing_Type");
			         clothingtype5.add(prices);
			         String prices3 = rs.getString("Price");
			         pricey.add(prices3);
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	public void getQuery(String search) {
		 Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql = search;
		      ResultSet rs = stmt.executeQuery(sql);
		      ResultSetMetaData rsmd = rs.getMetaData();
		      int columnsNumber = rsmd.getColumnCount();
		      while (rs.next()) {
		          for (int i = 1; i <= columnsNumber; i++) {
		              if (i > 1) resultsOfQ += ",  ";
		              String columnValue = rs.getString(i);
		              resultsOfQ +=columnValue + " " + rsmd.getColumnName(i);
		          }
		          resultsOfQ+="\n";
		      }
		      rs.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	   
	}
	public void addData(String add) {
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      Class.forName("oracle.jdbc.OracleDriver");
		      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
		      conn = DriverManager.getConnection(dbURL1);
		      stmt = conn.createStatement();
		      String sql =add ;
		      stmt.executeUpdate(sql);
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}	
public JPanel createNorthPanel() {
		JPanel northPanel = new JPanel( new GridLayout(2,1));
		northPanel.setBackground(Color.decode("#e82365"));
		JLabel title = new JLabel("CLOTHS CLOTHING STORE DATABASE INTERFACE");
		title.setFont(new Font("sansserif", Font.BOLD, 30));
		northPanel.add(title);
		JLabel names = new JLabel("By Calvin Yap, Julie Nguyen, Jason Yu");
		northPanel.add(names);
		return northPanel;
	}
	DefaultTableModel empmodel = new DefaultTableModel();
	DefaultTableModel stockmodel = new DefaultTableModel();
	DefaultTableModel onlineUsersmodel = new DefaultTableModel();
	DefaultTableModel purchasemodel = new DefaultTableModel();
	DefaultTableModel salesmodel = new DefaultTableModel();
	DefaultTableModel customermodel = new DefaultTableModel();
	
	public JPanel createWestPanel() {
		JPanel westPanel = new JPanel(new GridLayout(6,0));
		JPanel emp = new JPanel(new BorderLayout());
		JPanel stock = new JPanel(new BorderLayout());
		JPanel onlineUsers = new JPanel(new BorderLayout());
		JPanel purchases = new JPanel(new BorderLayout());
		JPanel sales = new JPanel(new BorderLayout());
		JPanel customers = new JPanel(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(560, 800));
		
		emp.add(new JLabel("Employees"),BorderLayout.NORTH);
		JTable empTable = new JTable(empmodel);
		empmodel.addColumn("EMP_Name");
		empmodel.addColumn("EMP_Phone");
		empmodel.addColumn("EMP_Address");
		empmodel.addColumn("EMP_City");
		empmodel.addColumn("EMP_Position");
		empmodel.addColumn("Store_Name");		
		JScrollPane scrollEMP = new JScrollPane(empTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JTextField addempText = new JTextField();
		addempText.setColumns(10);
		JButton addtoEmp= new JButton("Add Entry");
		JPanel addEMP = new JPanel(new GridLayout(2,1));
		addEMP.add(addempText);
		addEMP.add(addtoEmp);
		emp.add(addEMP,BorderLayout.SOUTH);
		emp.add(scrollEMP,BorderLayout.CENTER);
		addtoEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = addempText.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		westPanel.add(emp);
		
		
		stock.add(new JLabel("Stock"),BorderLayout.NORTH);

		JTable stockTable = new JTable(stockmodel);
		stockmodel.addColumn("Store_Name");
		stockmodel.addColumn("Clothing_Type");
		stockmodel.addColumn("Colour");
		stockmodel.addColumn("Clothing_Size");
		stockmodel.addColumn("Quantity");
		
		JScrollPane stockScroll = new JScrollPane(stockTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		stock.add(stockScroll,BorderLayout.CENTER);
		JTextField addstockText = new JTextField();
		addstockText.setColumns(10);
		JButton addtostock= new JButton("Add Entry");
		JPanel addSTOCK = new JPanel(new GridLayout(2,1));
		addSTOCK.add(addstockText);
		addSTOCK.add(addtostock);
		stock.add(addSTOCK,BorderLayout.SOUTH);
		westPanel.add(stock);
		addtostock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = addstockText.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		
		onlineUsers.add(new JLabel("Online Users"),BorderLayout.NORTH);
		JTable onlineUsersTable = new JTable(onlineUsersmodel);
		onlineUsersmodel.addColumn("Store_Name");
		onlineUsersmodel.addColumn("Customer_Name");
		onlineUsersmodel.addColumn("Customer_Phone");
		onlineUsersmodel.addColumn("Has_Account");
		
		JScrollPane onlineUsersScroll = new JScrollPane(onlineUsersTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		onlineUsers.add(onlineUsersScroll,BorderLayout.CENTER);
		JTextField addonlinet = new JTextField();
		addstockText.setColumns(10);
		JButton addtoonline= new JButton("Add Entry");
		JPanel addusers = new JPanel(new GridLayout(2,1));
		addusers.add(addonlinet);
		addusers.add(addtoonline);
		onlineUsers.add(addusers,BorderLayout.SOUTH);
		addtoonline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = addstockText.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		westPanel.add(onlineUsers);
		
		JTable purchasesTable = new JTable(purchasemodel);
		purchasemodel.addColumn("Customer_Name");
		purchasemodel.addColumn("Username");
		purchasemodel.addColumn("Password");
		purchasemodel.addColumn("Email");
		purchasemodel.addColumn("Customer_Phone");
		purchasemodel.addColumn("Credit_Card");
		purchasemodel.addColumn("Shipping_Address");
		purchasemodel.addColumn("Shipping_City");


		purchases.add(new JLabel ("Purchases"),BorderLayout.NORTH);
		JScrollPane purchasesTableScroll = new JScrollPane(purchasesTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JTextField addpurchasesText = new JTextField();
		addpurchasesText.setColumns(10);
		JButton addtopur= new JButton("Add Entry");
		JPanel addpur = new JPanel(new GridLayout(2,1));
		addpur.add(addpurchasesText);
		addpur.add(addtopur);
		purchases.add(addpur,BorderLayout.SOUTH);
		purchases.add(purchasesTableScroll,BorderLayout.CENTER);
		addtopur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = addpurchasesText.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		westPanel.add(purchases);
		
		JTable salesTable = new JTable(salesmodel);
		salesmodel.addColumn("Transaction#");
		salesmodel.addColumn("Clothing_Type");
		salesmodel.addColumn("Price");
		salesmodel.addColumn("Customer_Name");
		salesmodel.addColumn("Customer_Phone");

		sales.add(new JLabel ("Sales"),BorderLayout.NORTH);
		JScrollPane salesScroll = new JScrollPane(salesTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sales.add(salesScroll,BorderLayout.CENTER);	
		JTextField salesText = new JTextField();
		salesText.setColumns(10);
		JButton addtosales= new JButton("Add Entry");
		JPanel addsales = new JPanel(new GridLayout(2,1));
		addsales.add(salesText);
		addsales.add(addtosales);
		sales.add(addsales,BorderLayout.SOUTH);
		addtosales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = salesText.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		westPanel.add(sales);
		
		
		JTable customersTable = new JTable(customermodel);
		customermodel.addColumn("EMP_Name");
		customermodel.addColumn("Transaction#");
		customermodel.addColumn("Clothing_Type");
		customermodel.addColumn("Price");
		
		customers.add(new JLabel ("Customers"),BorderLayout.NORTH);
		JScrollPane customerScroll = new JScrollPane(customersTable,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JTextField custext = new JTextField();
		salesText.setColumns(10);
		JButton addtocus= new JButton("Add Entry");
		JPanel addcus = new JPanel(new GridLayout(2,1));
		addcus.add(custext);
		addcus.add(addtocus);
		customers.add(addcus,BorderLayout.SOUTH);
		customers.add(customerScroll,BorderLayout.CENTER);
		
		addtocus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = custext.getText();
				addData(text);
				actions.append(addedData+"\n");
			}
			
		});
		westPanel.add(customers);

		return westPanel;
		
	}
	public JPanel createCenterPanel() {
		JPanel centerPanel=new JPanel();
		
		JButton search = new JButton("Search Query");
		
		centerPanel.add(search);
		
		textField_1 = new JTextField();
		centerPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea results = new JTextArea(15,80);
		results.setEditable(false);
		JScrollPane resultsScroll = new JScrollPane(results,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		centerPanel.add(resultsScroll);
		search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			String meme=textField_1.getText();
			getQuery(meme);
			results.append(resultsOfQ);
			}
			
		});
		centerPanel.add(new JLabel("Actions"));

		
		actions.setEditable(false);
		
		JScrollPane actionsScroll = new JScrollPane(actions,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		centerPanel.add(actionsScroll);

		
		return centerPanel;
	}

	
	public JPanel createEastPanel() {
		JPanel eastPanel = new JPanel(new GridLayout(5,1));
		
		JButton btnNewButton4 = new JButton("CONNECT TO DB");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getConnection();
				for(int i =0; i< connection.size(); i++) {
					actions.append(connection.get(i)+"\n");
				}
			}
			
		});
		eastPanel.add(btnNewButton4);
		
		JButton btnNewButton = new JButton("DROP TABLES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dropTables();
				actions.append(dropTables+"\n");
			}
			
		});
		eastPanel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("CREATE TABLES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createTables();
				actions.append(createTables +"\n");
			}			
		});
		eastPanel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("LOAD DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
				actions.append(loadData +"\n");
				getDataEmp();
				getStock();
				getOnlineusers();
				getPurchases();
				getSales();
				getCustomers();
			}	
		});
		eastPanel.add(btnNewButton_1);
		
		JButton btnLoadTables = new JButton("LOAD TABLES");
		btnLoadTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!EMP_Name.isEmpty()) {
					for(int i =0;i<EMP_Name.size();i++) {
					empmodel.addRow(new Object[] {EMP_Name.get(i),EMP_Phone.get(i),EMP_Address.get(i),EMP_City.get(i),EMP_Position.get(i),Store_Name.get(i)});
					}
				}
				if(!store_name.isEmpty()) {
					for(int i =0;i<store_name.size();i++) {
					stockmodel.addRow(new Object[] {store_name.get(i),clothing_type.get(i),colour.get(i),clothing_size.get(i),quantity.get(i)});
					}
				}
				if(!store_name1.isEmpty()) {
					for(int i =0;i<store_name1.size();i++) {
						onlineUsersmodel.addRow(new Object[] {store_name1.get(i),customer_name.get(i),customer_phone.get(i),has_account.get(i)});
						}
				}
				if(!customer_name2.isEmpty()) {
					for(int i =0;i<customer_name2.size();i++) {
						purchasemodel.addRow(new Object[] {customer_name2.get(i),username.get(i),password.get(i),email.get(i),cusphone.get(i),creditcard.get(i),shipadd.get(i),shipcity.get(i)});
						}
				}
				if(!transaction.isEmpty()) {
					for(int i =0;i<transaction.size();i++) {
						salesmodel.addRow(new Object[] {transaction.get(i),clothing_type2.get(i),customer_name3.get(i),customer_phone3.get(i)});
						}
				}
				if(!emp_name1.isEmpty()) {
					for(int i =0;i<emp_name1.size();i++) {
						customermodel.addRow(new Object[] {emp_name1.get(i),transaction1.get(i),clothingtype5.get(i),pricey.get(i)});
						}
				}
			}
			
		});
		eastPanel.add(btnLoadTables);

		return eastPanel;
	}
}
