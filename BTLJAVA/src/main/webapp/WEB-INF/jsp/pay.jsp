<%-- 
    Document   : pay
    Created on : Aug 31, 2022, 7:09:50 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="<c:url value="/css/style.css"   />" />

<h1 class="font-weight-bold text-center">Tour đã đặt</h1>

<div class="row">
    <c:forEach items="${booktour}" var="t">
        <div class="col-md-4 col-xs-12" style="padding:10px;">
            <div class="card" style="width:400px">
                <div class="card-body" >
                    <h4>Mã vé: ${t.id}</h4>
                    <p class="card-text">Tên tour: ${t.tourid.name}</p>
                    <p class="card-text" id="n1" >Số lượng người lớn: ${t.numberofadults * t.numberofchildren}</p>
                    <p class="card-text" id="n2" >Số lượng trẻ em: ${t.numberofchildren}</p>
                    <p class="card-text">Ngày đặt tour: ${t.bookingdate}</p>
                </div>
            </div>
        </div>              
    </c:forEach>
    <h4 id="total">TỔNG TIỀN: </h4>
    <button type="button" class="btn btn-info" style="width: 150px" onclick="loadtotal()">Thanh toán</button>


</div>
<script src="<c:url value="/js/bookingtour.js" />"></script>
<script>
    <c:url value="/api/bookingtour" var="b" />
    window.onload = function () {
        getBookingtour('${b}');
    }
</script>


<script>
    function loadtotal() {
        var tong=0;
        var a = document.getElementById('n1').value;
        var b = document.getElementById('n2').value;
        tong  = parseInt(a)+ parseInt(b);
        document.getElementById('total').value=tong;
        console.log(a);
    }
</script>