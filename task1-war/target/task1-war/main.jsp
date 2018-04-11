<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 03.04.2018
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie theater</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/common.css">
</head>
<body>
<div id="wrapper">
    <div id="content">
        <div id="menu">
            <a href="event.jsp">
                <div id="event" class="menu_item">
                    <p>
                        Create a new event
                    </p>
                </div>
            </a>
        </div>
        <div id="workplace">
            <table>
                <c:forEach items="${listOfEvents}" var="it">
                    <a href="...">
                        <tr>
                            <td>
                                <c:out value="${it[0]}"/>
                            </td>
                            <td>
                                <c:out value="${it[1]}"/>
                            </td>
                        </tr>
                    </a>
                </c:forEach>
            </table>
        </div>

    </div>
    <div id="message">
        <p class="text">
            <c:out value="${message}"/>
        </p>
    </div>
</div>
<div id="footer">
    Evgeniy Shvetsov - Movie Theater task#1
</div>
</div>
</body>
</html>
