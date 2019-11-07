let changeStatusbutton = document.getElementById('changeStatusbutton');
changeStatusbutton.onclick = changeStatus;

let xmlHttpRequest = new XMLHttpRequest();

function changeStatus () {
    let newStatusText = document.getElementById("newStatus").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    let information = "action=ChangeChatStatus&newStatus=" + encodeURIComponent(newStatusText);
    xmlHttpRequest.open("POST", "Controller?"+information, true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    //alert(information);
    xmlHttpRequest.send(information);
}

