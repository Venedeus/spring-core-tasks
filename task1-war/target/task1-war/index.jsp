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
        <div id="identification">
            <form action="index" method="POST">
                <p class="input">
                    <p>
                        Enter user name:
                    </p>
                    <input type="text" name="name" placeholder="Enter user name"/>
                </p>
                <p class="input">
                    <p>
                        Enter password:
                    </p>
                    <input type="password" name="password" placeholder="Enter password"/>
                </p>
                <p class="input">
                    <input type="submit" value="Sign in"/>
                </p>
            </form>
        </div>
        <div id="message">
            <p class="text">
                <c:out value="${message}"/>
            </p>
        </div>
        <a href="signup">Sign up</a>
    </div>
    <div id="footer">
        Evgeniy Shvetsov - Movie Theater task#1
    </div>
</div>
</body>
</html>
