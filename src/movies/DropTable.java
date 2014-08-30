//Java Class
//Simply run the application

package movies;

import java.sql.*;

public class DropTable
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    String sql;
    try {
  	  Class.forName("org.postgresql.Driver");
  	  c = DriverManager
  			  .getConnection("jdbc:postgresql://localhost:5432/test1","akash", "akash131");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      sql = "DROP TABLE MOVIES;";
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table dropped successfully");
  }
}