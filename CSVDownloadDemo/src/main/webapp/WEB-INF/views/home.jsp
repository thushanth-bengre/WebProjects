<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Excel App</title>
<link href="${pageContext.request.contextPath}/css/global.css" />
</head>
<body>
	<div>
		<p>Enter name of the csv file here</p>
		<form action="loadData?start=0" method="post">
			<input type="text" name="csvfilename" />
			<input type="hidden" name="action" value="csvdataread" />
			<input type="submit" value="Upload" />
		</form>
	</div>
</body>
</html>

