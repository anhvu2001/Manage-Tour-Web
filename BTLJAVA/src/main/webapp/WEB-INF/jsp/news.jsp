<%-- 
    Document   : news
    Created on : Aug 4, 2022, 8:28:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />

<h1>Các tin tức mới nhất</h1>
<div>
    <c:forEach items="${listnews}" var="n">
        <div class="list-group" style="background-color: #CC9999">
            <a style="margin-bottom:15px" href="<c:url value="/news/${n.id}" />" class="list-group-item list-group-item-action">${n.title}</a>
        </div>
    </c:forEach>
</div>
<h1>${userinfo.username}</h1>
