<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/>
<h3>Add a movie and relevant info</h3>
<form method="post" action="MovieAdd">
	<div class="field"><label>Movie<input name="movie" type="text" placeholder="Movie Name" required/></label></div>
	<div class="field"><label>Year of Release<input name="year" type="number" min="1930" max="2014" placeholder="Year" required/></label></div>
	<div class="field"><label>Rating<input name="rating" type="number" min="1" max="10" step="0.1" placeholder="Rating" required/></label></div>
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