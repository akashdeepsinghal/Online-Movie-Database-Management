package movies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MovieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
	    Connection c = null;
	    Statement stmt = null;
	    String sql;
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		
	    try {
		  	  Class.forName("org.postgresql.Driver");
			  c = DriverManager
					  .getConnection("jdbc:postgresql://localhost:5432/test1","akash", "akash131");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");
		      
		      stmt = c.createStatement();
		      
		      sql = "DELETE from MOVIES where ID="+id+";";
		      stmt.executeUpdate(sql);
		      c.commit();

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
