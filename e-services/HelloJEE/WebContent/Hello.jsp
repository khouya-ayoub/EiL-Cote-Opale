<%--
  Created by IntelliJ IDEA.
  User: AYOUB
  Date: 20/10/2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Page JSP</title>
</head>
<body>
<div id="main__section" style="text-align: center">

    <h1>Hello Mr. <%= request.getParameter("nom") %> en Parameter</h1>

    <h1>Hello Mr. <%= request.getAttribute("nom") %> en Attribute</h1>

</div>
</body>
</html>
