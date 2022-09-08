/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch, moment */

function addCommentTour(endpoint, idtour) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "tourid": idtour
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data)
    {
       location.reload();
    });
}
function loadCommentsTour(da) {
    fetch(da).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("comments");
        let h = '';
        for (let d of data)
            h += `
               <div style= "margin-top:15px">
                              <div class="d-flex flex-start">
                                <img class="rounded-circle shadow-1-strong me-3"
                                  src="${d.userid.avatar}" alt="avatar" width="60"
                                  height="60" />
                                <div>
                                  <h6 class="fw-bold mb-1">${d.userid.username}</h6>
                                  <div class="d-flex align-items-center mb-3">
                                    <p class="mb-0">
                                     ${moment(d.createdDate).locale("vi").fromNow()}
                                      <span class="badge bg-primary">Pending</span>
                                    </p>
                                    <a href="#!" class="link-muted"><i class="fas fa-pencil-alt ms-2"></i></a>
                                    <a href="#!" class="link-muted"><i class="fas fa-redo-alt ms-2"></i></a>
                                    <a href="#!" class="link-muted"><i class="fas fa-heart ms-2"></i></a>
                                  </div>
                                  <p class="mb-0">
                                   ${d.content}
                                  </p>
                                </div>
                                                                 
                  </div>
            `;
        c.innerHTML = h;
    });
}
