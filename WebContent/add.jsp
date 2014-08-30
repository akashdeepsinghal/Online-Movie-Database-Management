<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a movie | Online Movie Database Management</title>
<style type="text/css">
.field{
	/*display: table;*/
}
input{
	width: 200px;
	display: table-cell;
}
label{
	width: 200px;
	font-weight: bold;
	/*display: block;*/
	display: table-cell;
}
</style>
</head>
<body>
<h1>Online Movie Database Management</h1>
<h3>Add a movie and relevant info</h3>
<form method="post" action="MovieAdd">
	<div class="field"><label>Movie<input name="movie" type="text" placeholder="Movie Name"/></label></div>
	<div class="field"><label>Year of Release<input name="year" type="number" min="1930" max="2014" placeholder="Year"/></label></div>
	<div class="field"><label>Rating<input name="rating" type="number" min="1" max="10" step="0.1" placeholder="Rating"/></label></div>
	<div class="field"><label>Actors<br>
	<input name="a1" type="text" placeholder="actor 1"/>
	<input name="a2" type="text" placeholder="actor 2"/>
	<input name="a3" type="text" placeholder="actor 3"/>
	<input name="a4" type="text" placeholder="actor 4"/>
	<input name="a5" type="text" placeholder="actor 5"/>
	</label>
	</div>
	<input type="submit" />	
</form>
</body>
</html>