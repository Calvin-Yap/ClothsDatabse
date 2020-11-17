import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
 
/**
 * This program demonstrates how to make database connection with Oracle
 
 *
 */
public class clothsConnect {
 
    public static void main(String[] args) {
 
        Connection conn1 = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
         String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
																						
			conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected with connection #1");
            }
 
 		
			
		
            //In your database, you should have a table created already with at least 1 row of data. In this select query example, table testjdbc was already created with at least 2 rows of data with columns NAME and NUM.
			//When you enter your data into the table, please make sure to commit your insertions to ensure your table has the correct data. So the commands that you need to type in Sqldeveloper are
			// CREATE TABLE TESTJDBC (NAME varchar(8), NUM NUMBER);
            // INSERT INTO TESTJDBC VALUES ('ALIS', 67);
            // INSERT INTO TESTJDBC VALUES ('BOB', 345);
            // COMMIT;
			
            String sql = "CREATE TABLE stores" + 
    				"store_id number(10) NOT NULL," + 
    				"store_name varchar2(25) NOT NULL," + 
    				"store_address varchar2(50) NOT NULL," + 
    				"store_city varchar2(20)," + 
    				"PRIMARY KEY (store_id));";
							
			try (Statement stmt = conn1.createStatement()) {

			 stmt.executeUpdate(sql);

			//If everything was entered correctly, this loop should print each row of data in your TESTJDBC table.
			// And you should see the results as follows:
			// Connected with connection #1
			// ALIS, 67
			// BOB, 345
			

			} catch (SQLException e) {
				System.out.println(e.getErrorCode());
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
}