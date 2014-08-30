Online-Movie-Database-Management
================================

_Web enabled 'Movie Database Management System' based on Java Server Pages and Servlets_

##Requirements
-Tomcat 7.0 server
-PostgreSQL

##How to Run
###Initial Setup
- _First create a postgres user 'akash' with password '********'_
- _Create database 'test1'_
  [Verify this by running Connect.java (11D020024/src/movies/Connect.java)]
- _Create table movies_
  [This is simply done by running CreateTable.java (11D020024/src/movies/CreateTable.java)]

###Deployment
	Deploy the 11D020024.war on Tomcat server
	
###Running web application
	-Web application should be running on http://localhost:8080/11D020024/
	-Here you have option to 'Add a movie' or to checkout the 'List of movies'

1. Add a movie (/add.jsp)
	-Enter all the details of a movie you want to add to the database
	-Submit the form
	-(After Submission) You are redirected to list.jsp
	
2. List of movies (/list.jsp)
	-Here you can see the list of all the movies
	-Also there are 'Delete' and 'Edit' options to Delete / Edit that movie details

3. Edit a movie (/edit.jsp?id='ID')
	-Details of that movie are prefetched into the form
	-Note: only rating and Actors list is editable as asked!
	-Edit the details and submit the form
	-(After Submission) You are redirected to list.jsp
	
##Inside the black box

###List of files
#####	web.xml
	-This can be found at (WebContent/WEB-INF/)
	-For whole web application, xml configuration has been done (and not the Annotaion one!)
	-There is a 'welcome-file-list', where index.html and index.jsp have been defined as the welcome files (which open as index page for http://localhost:8080/11D020024/)
	-Also servlet name, class and url have been defined
  
####servlets
######MovieAdd.java
		 	-This takes parameters from add.jsp eg. Movie name, rating, actors etc. via doPost method
		 	-Connection script has been defined to connect to the 'test1' database
		 	-All the actors are stored in a single string in a comma delimited format.
		 	-SQL query is run for INSERT operation
		 	-Changes in the connection are committed
		 	-Connection is closed
		 	-After successful submission, we are redirected to 'List of movies' [using setHeader method of response]
       
######MovieUpdate.java
		 	-This also takes parameters from edit.jsp via doPost method
		 	-Almost everything is similar to MovieAdd.java except that in this, SQL query is applied to UPDATE only ratings and actors
       
######MovieDelte.java
		 	-This takes 'id' as parameter via doGet method
		 	-SQL query is applied to DELETE the movie where id is same as the one which gotten from the doGet method
		 	
####JSP

	There are four JSP files are used:-
		index.jsp
		list.jsp
		add.jsp
		edit.jsp
			-Connection to the database has been established to prefetch the valued to the form using the 'id'
			-There is a hidden input field for 'id' having value equal to the id which we are editing