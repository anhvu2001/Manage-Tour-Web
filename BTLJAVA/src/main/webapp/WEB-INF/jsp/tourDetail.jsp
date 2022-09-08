<%-- 
    Document   : tourDetail
    Created on : Aug 3, 2022, 5:30:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />

<div class="row">
    <div class="col-md-6 "style="padding:10px" >
        <div class="card" style="width:650px">
            <img class="card-img-top" id ="main" src="${tour.iamge}" alt="Card image">
        </div>
    </div>
    <div class="col-md-6" style="padding:25px" >
        <h3>  ${tour.name}</h3>
        <p class="card-title">Ngày Khởi Hành: ${tour.daystart}</p>
        <p class="card-title">Thời gian: ${tour.numbersofday} ngày</p>
        <table class="table" >
            <thead class="table-primary">
                <tr>
                    <th>Loại vé</th>
                    <th >Giá trên 1 người </th>  
                </tr>   
            </thead>
            <tbody id="pricetour">

            </tbody>
        </table>
        <c:url value="/tour/${tour.id}" var="action" />
        <form:form method="post" action="${action}"  modelAttribute="booktour"  >
            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <div class="form-floating mb-3 mt-3">
                <h6>Nhập số lượng người lớn</h6>
                <form:input type="number" path="numberofadults"  id="nguoilon"  />
            </div>
            <div class="form-floating mb-3 mt-3">
                <h6>Nhập số lượng trẻ em</h6>
                <form:input type="number" path="numberofchildren"  id="trenho"   />
            </div>
            <button type="submit" class="btn btn-success">Đặt Ngay</button> 
        </form:form> 

    </div>       
</div>






<script>
    function changeImage(obj) {
        var path = obj.src;
        var img = document.getElementById("main");
        img.setAttribute("src", path);
    }
</script>


<div class="thumail" >
    <c:forEach items="${image}" var="c">
        <div class="items">
            <image src="${c.link}" alt="anhvu" style="width:100%; height: 107px" onclick="changeImage(this)" />
        </div>
    </c:forEach>
</div>


<c:url value="/api/tours/${tour.id}/comments" var="t" />

<sec:authorize access="!isAuthenticated()">
    <strong>Vui lòng <a href="<c:url value="/login" />">Đăng nhập</a> để bình luận!!!</strong>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="form-group">
        <textarea class="form-control" placeholder="Nhập nội dung" id="contentId"></textarea>
    </div>
    <button class="btn btn-danger" onclick="addCommentTour('${t}', ${tour.id})">Thêm bình luận</button>
</sec:authorize>


<ul id="comments" class="list-group">
    
</ul>





<script src="<c:url value="/js/adminTour.js" />"></script>
<script>
    <c:url value="/api/tours/${tour.id}/prices" var="u" />
        window.onload = function () {
            loadPrice('${u}');
        }
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment.js" />"></script>
<script>
        window.onload = function () {
            loadCommentsTour('${t}');
        }
</script>


