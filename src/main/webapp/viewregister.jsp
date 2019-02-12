<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/viewregister.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="registercontentstyle"><span id="registerstyle">Register</span></div>
	<div id="viewregisterstyle">
<!-- 		<form>
		<input type="submit" name="search" id="searchuniquestyle" value=""/>
		<input type="submit" name="search" id="searchnamestyle" value="Search by name"/>
		<input type="submit" name="search" id="searchcoststyle" value="Search by cost"/> -->
		<a href="viewRegisterUnique.jsp" id="searchuniquestyle"><span class="textstyle">Search by unique name and cost</span></a>
		<a href="ViewRegisterCost.jsp" id="searchcoststyle"><span class="textstyle">Search by cost</span></a>
		<a href="ViewRegisterName.jsp" id="searchnamestyle"><span class="textstyle">Search by name</span></a>
		<!-- </form> -->
	</div>
	<a href="index.jsp" id="backbuttonstyle">Back to Home</a>	
</body>
</html>