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
.row {
	padding: 5px;
	text-align: center;
}

.btn {
	width: 250px;
	padding: 5px;
	font-weight: normal;
	font-size: larger;
	font-family: Georgia;
}

.wc-head {
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
			<div class="alert alert-info wc-head">
				<h1>Add A Movie To The Store</h1>
			</div>
		</div>
		<div class="row">
			<form action="/save-movie" method="post">
				<table>
					<tr>
						<td>Title</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>Actor</td>
						<td><input type="text" name="actor"></td>
					</tr>
					<tr>
						<td>Actress</td>
						<td><input type="text" name="actress"></td>
					</tr>
					<tr>
						<td>Genre</td>
						<td><input type="text" name="genre"></td>
					</tr>
					<tr>
						<td>Year</td>
						<td><input type="number" step="1" name="year"></td>
					</tr>
				</table>
				<input type="submit" value="Save Movie" class="btn btn-primary">
			</form>
		</div>
	</div>
</body>
</html>
