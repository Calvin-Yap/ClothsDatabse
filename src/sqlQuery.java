import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Properties;

public class sqlQuery {   
   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      Class.forName("oracle.jdbc.OracleDriver");
	      String dbURL1 = dblogin.db1;  // that is school Oracle database and you can only use it in the labs
	      conn = DriverManager.getConnection(dbURL1);
	      stmt = conn.createStatement();
	      String sql = "SELECT * FROM EMPLOYEES";
	      ResultSet rs = stmt.executeQuery(sql);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      int columnsNumber = rsmd.getColumnCount();
	      while (rs.next()) {
	          for (int i = 1; i <= columnsNumber; i++) {
	              if (i > 1) System.out.print(",  ");
	              String columnValue = rs.getString(i);
	              System.out.print(columnValue + " " + rsmd.getColumnName(i));
	          }
	          System.out.println("");
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
}//end JDBCExample