//Java Class
//Simply run the application

package movies;

import java.sql.*;

public class Select
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
      sql = "SELECT * FROM MOVIES;";
      ResultSet rs = stmt.executeQuery(sql);
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  name = rs.getString("NAME");
         int year  = rs.getInt("YEAR");
         float rating  = rs.getFloat("RATING");
         String  actors = rs.getString("ACTORS");

         System.out.println( "ID = " + id );
         System.out.println( "NAME = " + name );
         System.out.println( "YEAR = " + year );
         System.out.println( "RATING = " + rating);
         System.out.println( "ACTORS = " + actors);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
//    System.out.println("Operation done successfully");
  }
}