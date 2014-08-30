<%@ page language="java" import="java.sql.*,java.util.List,java.util.Arrays" %>
<%
	String driver = "org.postgresql.Driver";
	Class.forName(driver).newInstance();
	
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	String ID = request.getParameter("id");
	
	try{
		String url="jdbc:postgresql://localhost:5432/test1?user=akash&password=akash131";
		con=DriverManager.getConnection(url);
		stmt=con.createStatement();
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	      String sql = "SELECT * FROM MOVIES where ID="+ID+";";
	      rs = stmt.executeQuery(sql);
		%>
		
<jsp:include page="header.jsp"/>
<h3>Edit the movie details</h3>
<%
int no=1;
while(rs.next()){
	int id = rs.getInt("ID");
	int year = rs.getInt("YEAR");
	String actors = rs.getString("ACTORS");
	List<String> actorsList = Arrays.asList(actors.split(", "));
	int len = actorsList.size();
	String a1, a2, a3, a4, a5;
	a1 = ((0<len)?actorsList.get(0):"");
	a2 = ((1<len)?actorsList.get(1):"");
	a3 = ((2<len)?actorsList.get(2):"");
	a4 = ((3<len)?actorsList.get(3):"");
	a5 = ((4<len)?actorsList.get(4):"");
	
%>
<form method="post" action="MovieUpdate">
	<input name="id" type="number" value="<%=id%>" style="display:none"/>
	<div class="field"><label><%=rs.getString("NAME")%></label></div>
	<div class="field"><label><%=year%></label></div><br>
	<div class="field"><label>Rating<input name="rating" type="number" min="1" max="10" step="0.1" value="<%=rs.getString("RATING")%>" placeholder="Rating" required/></label></div>
	<div class="field"><label>Actors<br>
	<input name="a1" type="text" placeholder="actor 1" value="<%=a1%>"/>
	<input name="a2" type="text" placeholder="actor 2" value="<%=a2%>"/>
	<input name="a3" type="text" placeholder="actor 3" value="<%=a3%>"/>
	<input name="a4" type="text" placeholder="actor 4" value="<%=a4%>"/>
	<input name="a5" type="text" placeholder="actor 5" value="<%=a5%>"/>
	</label>
	</div>
	<input type="submit" />
</form>
<%
no++;
}
rs.close();
stmt.close();
con.close();
%>
</body>
</html>