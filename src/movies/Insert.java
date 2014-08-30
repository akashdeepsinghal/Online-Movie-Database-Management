//Java Class
//Simply run the application

package movies;

import java.sql.*;

public class Insert
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
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      sql = "INSERT INTO MOVIES (NAME,YEAR, RATING, ACTORS) " +
                   "VALUES ('Guardians of the Galaxy', 2014, 8.6, 'Chris Pat, Vin Diesel');"; 
      stmt.executeUpdate(sql);

      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}