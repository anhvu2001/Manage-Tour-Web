/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */

function deleteNews(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}

function getNews(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("adminNews");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
               <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td><img src="${data[i].image}" width="200" /></td>
                    <td>${data[i].title}</td>
                    <td >${data[i].describe}</td>
                     <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteNews('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Delete</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }
        let d2 = document.getElementById("loadingnews")
        d2.style.display = "none"
    }).catch(function (err) {
        console.error(err);
    })
}

function loadCommentsNews(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let c = document.getElementById("commentnews");
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

function addCommentnews(endpoint, newid) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentnewsId").value,
            "newsid": newid
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
         location.reload();
    });
}

