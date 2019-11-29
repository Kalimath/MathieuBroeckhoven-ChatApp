let username =  $('#userId').text();
let chatToUser = $('.chat-head h4').text();
let currentChatObject = $('.chat-head h4');
let currentChat;



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
        if(src == 'images/arrow-down-32.png'){
            arrow.attr('src', 'images/arrow-up-32.png');
        }
        else{
            arrow.attr('src', 'images/arrow-down-32.png');
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
    $.getJSON("Controller?action=Chat&chat=" + currentChat, function(result) {
        console.log(result);
            writeChat(result);

        }
    ).always((data)=>{console.log(data)});
}

//moet met polling (dus niet zoals hierboven), messages array moet nog gevuld worden
function writeChat(res) {
        console.log(res);
            $( ".msg-insert" ).empty(); // clears div met alle berichten
            //alles hieronder is nog niet af

            for(let x = 0 ; x < res.length; x++){
                    if (res[x].sender === username) {
                        $('.msg-insert').append("<div class='msg-send'>me: "+ res[x].message +"</div>");
                    } else {
                        $('.msg-insert').append("<div class='msg-receive'>"+ res[x].message +"</div>");
                    }
            }
};

function openChat(userId) {
    currentChatObject.text(userId);
    currentChat = userId;
    getMessages(userId);
    setInterval(getMessages, 1500);
}