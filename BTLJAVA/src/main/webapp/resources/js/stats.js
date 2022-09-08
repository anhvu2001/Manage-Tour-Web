/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function tourStats(id, cateLabels=[], cateData =[]) {
    const data = {
        labels: cateLabels,
        datasets: [{
                label: 'Thống kê số Tour',
                data: cateData,
                backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(255, 205, 86)'
                ],
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };
    const ctx = document.getElementById(id).getContext('2d');
     new Chart(ctx, config);
}