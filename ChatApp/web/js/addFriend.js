let xhrAddFriend = new XMLHttpRequest();
let addFriendbutton = document.getElementById('addFriendbutton');
addFriendbutton.onclick = function () {
    addFriend();
}

function addFriend() {
    let newFriend = document.getElementById("newFriend").value;
    document.getElementById("newFriend").value = "";
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    let information = "action=AddFriend&newFriend=" + encodeURIComponent(newFriend);
    xhrAddFriend.open("POST", "Controller?"+information, true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    xhrAddFriend.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    //alert(information);
    xhrAddFriend.send(information);
    xhrAddFriend.onreadystatechange= function () {
        getFriends();
    }
}