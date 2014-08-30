<%@ page language="java" import="java.sql.*,java.util.List,java.util.Arrays" %>
<%
	String driver = "org.postgresql.Driver";
	Class.forName(driver).newInstance();
	
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	
	try{
		String url="jdbc:postgresql://localhost:5432/test1?user=akash&password=akash131";
		con=DriverManager.getConnection(url);
		stmt=con.createStatement();
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	      String sql = "SELECT * FROM MOVIES;";
	      rs = stmt.executeQuery(sql);
		%>
		
		<html>
		<head>
		<title>Movies List | Online Movie Database Management</title>
		</head>
		<body>
			<h2>Movies List</h2>
			<table border="1">
			<tr>
				<td><b>S.No</b></td>
				<td><b>UID</b></td>
				<td><b>Movie</b></td>
				<td><b>Year</b></td>
				<td><b>Rating</b></td>
				<td><b>Actors</b></td>
				<td><b>Delete</b></td>
				<td><b>Edit</b></td>
			</tr>
			 	<%
				int no=1;
				while(rs.next()){
					int id = rs.getInt("ID");
					String actors = rs.getString("ACTORS");
				%>
				<tr>
				  <td><%=no%></td>
				  <td><%=id%></td>
				  <td><%=rs.getString("NAME")%></td>
				  <td> <%=rs.getString("YEAR")%> </td>
				  <td> <%=rs.getString("RATING")%> </td>
				  <td> <%=actors%> </td>
				  <td> <a href="MovieDelete?id=<%=id%>">Delete?</a> </td>
				  <td> <a href="edit.jsp?id=<%=id%>">Edit</a> </td>
				</tr>
				<%
				no++;
	}
	rs.close();
	stmt.close();
	con.close();
%>
			</table>
		</body>
	</html>