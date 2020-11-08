<%@ page import="java.util.Collection" %>
<%@ page import="fr.khouya.beans.HelloBean" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: AYOUB
  Date: 20/10/2020
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of beans</title>
</head>
<body>
<div id="main__section" style="text-align: center">

    <%
        Collection<HelloBean> listBean =
                (Collection<HelloBean>) session.getAttribute("listBean");

        if (listBean != null) {
            Iterator<HelloBean> it = listBean.iterator();
            while (it.hasNext()) {
                HelloBean bean = it.next();
                %>
                    <h1>Bonjour : <%= bean.getName() %></h1><br/>
                <%
            }
        }
    %>

    <h2>---------------------- for (Class i : list) -----------------------</h2><br/>

    <%
        if (listBean != null) {
            for (HelloBean bean : listBean) {
                %>
                    <h1>Bonjour : <%= bean.getName() %></h1><br/>
                <%
            }
        }

    %>

    <h2>---------------------- Tag Lib ----------------------</h2><br/>

    <c:forEach var="aBean" items="${listBean}">
        <h1>Bonjour : ${aBean.name}</h1><br/>
    </c:forEach>


</div>
</body>
</html>
