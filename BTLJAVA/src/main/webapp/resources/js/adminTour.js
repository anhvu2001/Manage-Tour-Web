/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteTour(endpoint, id, btn) {
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


function getTour(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("adminMyTour");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td><img src="${data[i].iamge}" width="120" /></td>
                    <td>${data[i].name}</td>
                   
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteTour('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">DELETE</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }
        let d2 = document.getElementById("loading")
        d2.style.display = "none"
    }).catch(function (err) {
        console.error(err);
    })
}

function loadPrice(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("pricetour");
        let h = '';
        for (let d of data)
            h += `
            <tr>
                <td id="${d.id}">${d.customerid.name}</td>
                <td>${d.price} $ </td>
            </tr>` ;
    
        c.innerHTML = h;
    });
}

