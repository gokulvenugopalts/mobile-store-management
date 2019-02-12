<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register List</title>
<link href="css/RegisterDisplay.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="registercontentstyle"><span id="registerstyle">Register List</span></div>
	<div id="registerliststyle">
	<p><c:set var="fullSet" value="${registerList}"></c:set></p>
	<p><c:set var="eachRow" value="${fn:split(fullSet,'-')}"> </c:set></p>
	<table id="registertablestyle">	 
	 <c:forEach var="eachRowTemp" items="${eachRow}">
	 <p><c:set var="eachCol" value="${fn:split(eachRowTemp,':')}"> </c:set></p>
	 
	 <tr>
	 <c:forEach var="eachColTemp" items="${eachCol}">
	 
	 
	 	<td><span id="textstyle"><c:out value="${eachColTemp}"></c:out></span></td>
	 
	</c:forEach>
	</tr>
	
	</c:forEach>
</table>
    </div>
    <div id="redirectstyle">
        <a href="viewregister.jsp" id="backbuttonstyle">Back</a>
    <a href="index.jsp" id="backhomestyle">Back to Home</a></div>
</body>
</html>