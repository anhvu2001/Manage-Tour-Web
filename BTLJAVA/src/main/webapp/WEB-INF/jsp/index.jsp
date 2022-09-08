<%-- 
    Document   : index
    Created on : Jul 22, 2022, 4:03:18 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


 
<div style="padding-top:10px;margin: 0px" class="stylephantrang">
<ul class="pagination" style="margin:0px">
    <c:forEach begin="1" end="${Math.ceil(Countour/pageSize)}" var="i">
        <c:url value="/" var="t">
            <c:param name="page" value="${i}" />
        </c:url>
        <li class="page-item"><a class="page-link" href="${t}">${i}</a></li>
    </c:forEach>
</ul>
</div>

<div class="row">
    <c:forEach items="${listtour}" var="t">
        <div class="col-md-4 col-xs-12" style="padding:10px;">
            <div class="card" style="width:400px">
                <img class="card-img-top" src="${t.iamge}" alt="Card image">
                <div class="card-body" >
                    <h4  class="bg-secondary text-white"  >${t.name}</h4>
                    <p class="card-text">Khởi hành: ${t.daystart}</p>
                    <p class="card-text">Thời gian: ${t.numbersofday} ngày</p>
                    <a href="<c:url value="/tour/${t.id}" />" class="btn btn-outline-info">Xem Chi Tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


