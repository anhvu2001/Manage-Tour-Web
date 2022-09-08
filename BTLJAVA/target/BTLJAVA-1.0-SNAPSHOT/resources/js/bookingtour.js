/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getBookingtour(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("bookingtour");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td>${data[i].tourid.name}</td>
                    <td>${data[i].numberofchildren}</td>
                    <td>${data[i].numberofadults}</td>
                    <td>${data[i].bookingdate}</td>
                </tr>
            `
            d.innerHTML = h;
        }
    }).catch(function (err) {
    })
}