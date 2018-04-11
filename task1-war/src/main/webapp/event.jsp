<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 03.04.2018
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new event</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/common.css">
</head>
<body>
<div id="wrapper">
    <div id="content">
        <form action="event" method="GET">
            <input type="text" name="name" placeholder="Enter event name"/>
            <input type="text" name="basePrice" placeholder="Enter base price"/>
            <select class="select" name="ratings">
                <c:forEach items="${listOfRating}" var="it">
                    <option value="${it}">${it}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Create event"/>
        </form>
    </div>
    <div id="footer">
        Evgeniy Shvetsov - Movie Theater task#1
    </div>
</div>
</body>
</html>
