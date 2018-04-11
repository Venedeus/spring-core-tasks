<%--
  Created by IntelliJ IDEA.
  User: Evgeniy
  Date: 31.03.2018
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/common.css">
</head>
<body>
<div id="wrapper">
    <div id="content">
        <div id="menu">
            <a href="index.jsp">&lt; Back</a>
        </div>
        <div id="registration">
            <form action="register" method="GET">
                <p class="input">
                    <input type="text" name="name" placeholder="Enter user name"/>
                </p>
                <p class="input">
                    <select class="select" name="role">
                        <c:forEach items="${listOfRoles}" var="it">
                            <option value="${it}"><c:out value="${it}"/></option>
                        </c:forEach>
                    </select>
                </p>
                <p class="input">
                    <input type="text" name="email" placeholder="Enter email address"/>
                <p class="input">
                    <input type="password" name="password1" placeholder="Enter password"/>
                </p>
                <p class="input">
                    <input type="password" name="password2" placeholder="Confirm password"/>
                </p>
                <p class="input">
                    <input type="date" name="birthday" placeholder="Enter birthday"/>
                </p>
                <p class="input">
                    <input type="submit" value="Submit"/>
                </p>
            </form>
            <div id="message">
                <p class="text">
                    <c:out value="${message}"/>
                </p>
            </div>
        </div>
        <a href="/signup.jsp">Sign up</a>
    </div>
    <div id="footer">
        Evgeniy Shvetsov - Movie Theater task#1
    </div>
</div>
</body>
</html>
