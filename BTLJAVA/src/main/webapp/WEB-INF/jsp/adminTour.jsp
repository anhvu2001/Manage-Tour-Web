<%-- 
    Document   : adminTour
    Created on : Aug 5, 2022, 2:35:34 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="<c:url value="/css/style.css"   />" />

<button class="btn btn-primary" id="loading">
    <span class="spinner-border spinner-border-sm"></span>
    Loading..
</button>


<c:if test="${err!=null}" >
    <div class ="alert alert-danger">
        ${err}
    </div>
</c:if>

<c:url value="/admin/tours" var="action" />
<form:form method="post" action="${action}"  modelAttribute="tour" enctype="multipart/form-data"  >
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Tên tour</label>
        <form:errors path="name" element="div" cssClass="alert alert-danger" />
    </div>
    <div style="margin-bottom: 15px" >
        <label for="name">Ngày khởi hành</label>
        <form:input type="date" path="daystart" class="form-control" id="day"  />
    </div>
    <div class="form-floating"  style="margin-bottom: 15px" >
        <form:select path="typeidId" class="form-select" id="type" name="type">
            <c:forEach items="${listtypetour}" var="t">
                <option value="${t.id}">${t.name}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Kiểu tour</label>
    </div>
    <div class="form-label">
        <form:input type="file" path="file" class="form-control" id="file" />
    </div>
    <div style="margin: 5px">
        <button type="submit" class="btn btn-success">Thêm tour</button>
    </div>

</form:form>

<table class="table table-bordered table-sm">
    <thead class="table-success" style="width: 100%">
        <tr>
        <th>ID</th>
        <th>IMAGE</th>
        <th>NAME</th>
        <th></th>
    </tr>
    </thead>
    <tbody id="adminMyTour">

    </tbody>
</table>

<script src="<c:url value="/js/adminTour.js" />"></script>
<script>
    <c:url value="/api/tours" var="u" />
    window.onload = function () {
        getTour('${u}');
    }
</script>
