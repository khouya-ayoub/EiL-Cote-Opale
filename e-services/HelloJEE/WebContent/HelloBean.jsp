<%--
  Created by IntelliJ IDEA.
  User: AYOUB
  Date: 20/10/2020
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="beanHello" scope="session" class="fr.khouya.beans.HelloBean" />

<html>
<head>
    <title>Hello Bean</title>
</head>
<body>
<div id="main__section" style="text-align: center">

    <h1> Bonjour From DB : <jsp:getProperty name="beanHello" property="name"/>  + test </h1>

</div>
</body>
</html>
