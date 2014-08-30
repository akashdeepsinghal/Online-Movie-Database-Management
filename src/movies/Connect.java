//Java Class
//Simply run the application

package movies;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
   @SuppressWarnings("unused")
public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/test1",
            "akash", "akash131");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}