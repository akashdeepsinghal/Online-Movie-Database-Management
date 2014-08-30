package movies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings({ "unused", "serial" })
public class MovieUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Connection c = null;
	    Statement stmt = null;
	    String sql;
	    
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String ID = request.getParameter("id");
		int intId = Integer.parseInt(ID);
		System.out.println(intId);
		
		String rating = request.getParameter("rating");
		String actors ="";
		for(int l=0;l<5;l++){
			String m = "a"+(l+1);
			String actor = request.getParameter(m);
			if(actor!=null && actor!="" && !actor.isEmpty() ){
				actor = actor+", ";
				actors = actors + actor;
			}
		}
		if(actors.endsWith( ", " )){
			actors = actors.substring(0, actors.length()-2);
		}
		System.out.println(actors);
	    try {
		  	  Class.forName("org.postgresql.Driver");
			  c = DriverManager
					  .getConnection("jdbc:postgresql://localhost:5432/test1","akash", "akash131");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");
		      
		      stmt = c.createStatement();

		      sql = "UPDATE MOVIES set RATING = "+
		    		  rating+
		    		  ", ACTORS = '"+
		    		  actors+
		    		  "' where ID = "+
		    		  intId+
		    		  ";";
		      stmt.executeUpdate(sql);
		      c.commit();

		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Records updated successfully");
		    String site = "list.jsp" ;
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("Get method is not supported");
	    String site = "list.jsp" ;
	    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
	    response.setHeader("Location", site);
	}

}