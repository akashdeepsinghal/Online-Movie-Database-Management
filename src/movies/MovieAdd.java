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
public class MovieAdd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Connection c = null;
	    Statement stmt = null;
	    String sql;
	    
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String movie = request.getParameter("movie");
		String year = request.getParameter("year");
		String rating = request.getParameter("rating");
		String actors="";
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
		      
		      sql = "INSERT INTO MOVIES (NAME,YEAR, RATING, ACTORS) VALUES ('"+
		    		  movie+
		    		  "','"+
		    		  year+
		    		  "','"+
		    		  rating+
		    		  "','"+
		    		  actors+
		    		  "');";
		      stmt.executeUpdate(sql);
		      c.commit();

		      
		      sql = "SELECT * FROM MOVIES";
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		    	  int id = rs.getInt("ID");
		    	  String movieDb = rs.getString("NAME");
		    	  int yearDb = rs.getInt("YEAR");
		    	  int ratingDb = rs.getInt("RATING");
		    	  int actorsDb = rs.getInt("RATING");
		    	  System.out.println("ID:- "+id);
		    	  System.out.println("Movie:- "+movieDb);
		    	  System.out.println("Year of Release:- "+yearDb);
		    	  System.out.println("Rating:- "+ratingDb);
		    	  System.out.println("Rating:- "+actorsDb+"\n");
		    	  }
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Records created successfully");
		    String site = "list.jsp" ;
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String site = "add.jsp" ;
		    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		    response.setHeader("Location", site);
	}

}