let username =  $('#userId').text();
let currentChatObject = $('.chat-head h4');
let currentChat;
let messages = [];

class Message {
    constructor(sender, receiver, message, number) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.volgnummer = number;
    };
}

$(function(){
    let arrow = $('.chat-head img');
    let textarea = $('.chat-text .chat');

    arrow.on('click', function(){
        let src = arrow.attr('src');

        $('.chat-body').slideToggle('fast');
        if(src == 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_down-16.png'){
            arrow.attr('src', 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_up-16.png');
        }
        else{
            arrow.attr('src', 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_down-16.png');
        }
    });

    textarea.keypress(function(event) {
        let $this = $(this);

        if(event.keyCode == 13){
            let msg = $this.val();
            let newMsg = new Message(username, currentChat, msg);
            let jsonMsg = JSON.stringify(newMsg);
            let uriMsg = "message=" + jsonMsg;
            $.post("Controller?action=Chat", uriMsg);
            $this.val('');
            uriMsg = '';
        }
    });

});

function getMessages() {
    $.ajax({url: "Controller?action=Chat&chat=" + currentChat, method: "GET", success: function (result) {
        writeChat(result);
    }});
}

function writeChat(text) {
    let parsedText = JSON.parse(text);
    for (let i = 0; i < parsedText.length; i++) {
        if ($.inArray(parsedText[i].volgnummer, messages) === -1) {
            if (parsedText[i].sender === username) {
                $('.msg-insert').append("<div class='msg-send'>"+ parsedText[i].message +"</div>");
                messages.push(parsedText[i].volgnummer);
            } else {
                $('.msg-insert').append("<div class='msg-receive'>"+ parsedText[i].message +"</div>");
                messages.push(parsedText[i].volgnummer);
            }
        }
    }
}

function openChat(userId) {
    currentChatObject.text(userId);
    currentChat = userId;
    getMessages(userId);
    setInterval(getMessages, 1500);
}