<%--  Created by IntelliJ IDEA.
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
          <script type="text/javascript">
            function onClick(str){
                var container = document.getElementById("calendars");

                var div = document.createElement("div");
                div.setAttribute("class", "calendar")
                div.setAttribute("id", "calendar" + (document
                .getElementsByClassName("calendar").length + 1));

                var date = document.createElement("input");
                date.setAttribute("type", "date");
                date.setAttribute("class", "dates");
                date.setAttribute("name", "date" + (document
                .getElementsByClassName("dates").length + 1));

                var time = document.createElement("input");
                time.setAttribute("type", "time");
                time.setAttribute("class", "times");
                time.setAttribute("name", "time" + (document
                .getElementsByClassName("times").length + 1));

                div.appendChild(date);
                div.appendChild(time);

                container.appendChild(div);
            }
          </script>
</head>
<body>
<div id="wrapper">
    <div id="content">
        <form action="event" method="GET">
            <p class="input">
            <input type="text" name="name" placeholder="Enter event name"/>
          </p>
          <p class="input">
            <input type="text" name="basePrice" placeholder="Enter base price"/>
          </p>
          <p class="input">
            <select class="select" name="ratings">
                <c:forEach items="${listOfRating}" var="it">
                    <option value="${it}">${it}</option>
                </c:forEach>
            </select>
          </p>
          <p class="input">
                        <select class="select" name="auditoriums">
                            <c:forEach items="${listOfAuditoriums}" var="it">
                                <option value="${it}">${it}</option>
                            </c:forEach>
                        </select>
                      </p>
                      <c:set var="str" value=""/>
            <input type="button" onclick="onClick('${str}')"
            value="New date"/>
            <p id="calendars">
            </p>
                      <p class="input">
            <input type="submit" value="Create event"/>
          </p>
        </form>
    </div>
    <div id="footer">
        Evgeniy Shvetsov - Movie Theater task#1
    </div>
</div>
</body>
</html>