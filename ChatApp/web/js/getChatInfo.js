var xhrFriends = new XMLHttpRequest();
var xhrStatus = new XMLHttpRequest();



window.onload = function () {
    getFriends();
    getStatus();
};

function getFriends() {
    xhrFriends.open("GET", "Controller?action=GetFriends", true);
    xhrFriends.onreadystatechange = getFriendsData;
    xhrFriends.send(null);
}

function getFriendsData() {
    var friendlist = [];
    if (xhrFriends.status == 200) {
        if (xhrFriends.readyState == 4) {
            var serverResponse = JSON.parse(xhrFriends.responseText);
            var tableroot = document.getElementById("friendsTable");
            var tbody = tableroot.lastElementChild;
            tbody.innerHTML = "";
            console.log(serverResponse.length);
            for (var i = 0; i < serverResponse.length; i++) {
                if (friendlist.indexOf(serverResponse[i].userId) < 0) {
                    var tr = document.createElement('tr');
                    for (var j = 0; j < 3; j++) {

                        if (i === 10 && j === 1) {
                            break
                        } else if (j === 1) {
                            let td = document.createElement('td');

                            td.appendChild(document.createTextNode(serverResponse[i].status));

                            tr.appendChild(td);
                        } else if (j === 0) {
                            let td = document.createElement('td');
                            td.appendChild(document.createTextNode(serverResponse[i].userId));
                            tr.appendChild(td);
                            //friendlist.push(serverResponse[i].userId);
                        }else if (j === 2) {
                            let td = document.createElement('td');
                            let str = '<button id="' + serverResponse[i].userId + '" onclick="openChat(\'' + serverResponse[i].userId + '\');">Message</button>'
                            td.innerHTML = str;
                            tr.appendChild(td);
                            //friendlist.push(serverResponse[i].userId);
                        }
                    }
                    tbody.appendChild(tr);
                }
            }


            setTimeout(getFriends, 10000);
        }
    }
}

function getStatus() {
    xhrStatus.open("GET", "Controller?action=GetUserFromSession", true);
    //alert("getStatus called!!");
    xhrStatus.onreadystatechange = getStatusData;
    xhrStatus.send(null);
}

function getStatusData () {
    if (xhrStatus.status == 200) {
        if (xhrStatus.readyState == 4) {
            //alert(xhrStatus.responseText);
            let serverResponse = JSON.parse(xhrStatus.responseText);
            let status = serverResponse.status; // status property uit JSON
            let statusDiv = document.getElementById("personStatus");
            let statusParagraph = statusDiv.childNodes[0];

            if (statusParagraph == null) {
                statusParagraph = document.createElement('div');
                statusParagraph.id = "newStatusText";
                let statusText = document.createTextNode(status);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }
            else {
                let statusText = document.createTextNode(status);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
            setTimeout(getStatus, 2000);
        }
    }
}
