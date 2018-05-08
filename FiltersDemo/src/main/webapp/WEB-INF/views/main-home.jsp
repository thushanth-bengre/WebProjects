<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>HW5P4</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style type="text/css">
.row{
padding: 5px;
text-align: center;
}
.btn{
width: 250px;
padding:5px;
font-weight: normal;
font-size: larger;	
font-family: Georgia;

}
.wc-head{
	text-align: center;
	background-color: gray;
	color: white;
	font-weight: bold;
	font-size: larger;	
	font-family: Georgia;
}
.navbar {
	border-radius: 0 !important;
}
</style>	
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"><span class="glyphicon glyphicon-film"></span>
					&nbsp; Movie Store</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="alert alert-info wc-head" ><h1>Welcome To Movie Store</h1></div>
		</div>
		<div class="row">
			<form action="/add-movie" method="post">
				<input type="submit" value="Add Movie" class="btn btn-success">
			</form>
		</div>
		<div class="row">
			<form action="/search-movie" method="post">
				<input type="submit" value="Search Movie" class="btn btn-warning">
			</form>
		</div>
	</div>
</body>
</html>
