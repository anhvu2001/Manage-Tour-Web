<%-- 
    Document   : adminNews
    Created on : Aug 6, 2022, 10:58:02 PM
    Author     : ADMIN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="<c:url value="/css/style.css"   />" />


<button class="btn btn-primary" id="loadingnews">
    <span class="spinner-border spinner-border-sm"></span>
    Loading..
</button>

<c:if test="${err!=null}" >
    <div class ="alert alert-danger">
        ${err}
    </div>
</c:if>

<c:url value="/admin/news" var="action" />
<form:form method="post" action="${action}"  modelAttribute="news" enctype="multipart/form-data"  >
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name"  />
        <label for="name">Tên tin tức</label>
        <form:errors path="name" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="title" class="form-control" id="name"  />
        <label for="name">Tiêu đề</label>
        <form:errors path="name" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="describe" class="form-control" id="name"  />
        <label for="name">Noi dung</label>
        <form:errors path="name" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="form-label">
        <form:input type="file" path="file" class="form-control" id="file" />
    </div>
    <div style="margin: 5px">
        <button type="submit" class="btn btn-success">Thêm tin tuc</button>
    </div>

</form:form>


<table class="table" style="margin-top: 10px">
    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>IMAGE</th>
            <th>TITLE</th>
            <th class="text-center">DESCRIBE</th>
            <th></th>
        </tr>   
    </thead>
    <tbody id="adminNews">

    </tbody>
</table>

<script src="<c:url value="/js/adminNews.js" />"></script>
<script>
    <c:url value="/api/news" var="n" />
    window.onload = function () {
        getNews('${n}');
    }
</script>


