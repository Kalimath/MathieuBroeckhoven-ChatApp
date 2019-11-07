let reactSocket;

openSocket();

class Reaction {
    constructor(title, reactor, reaction, rating) {
        this.title = title;
        this.reactor = reactor;
        this.reaction = reaction;
        this.rating = rating;
    };
}

function  openSocket() {
    reactSocket = new WebSocket("ws://localhost:8080/react");

    reactSocket.onopen =function (event) {
        setInterval(reactSocket.send("true"), 3000);
    }

    reactSocket.onmessage =function (event) {
        console.log(JSON.parse(event.data));
        writeResponse(event.data);
    }

    reactSocket.onclose =function (event) {
        console.log("closed");
    }
}

function getReaction(number) {
    let title = document.getElementById("title" + number).innerText;
    let reactor = document.getElementById("reactor" + number).value;
    let reaction = document.getElementById("reaction" + number).value;
    let rating = document.getElementById("rating" + number).value;

    let reaction0 = new Reaction(title, reactor, reaction, rating);

    return JSON.stringify(reaction0);
}

function writeResponse(text) {
    let result = JSON.parse(text);
    let titles = ["Was het een interessante projectweek?", "Wat ben je van plan om te doen vandaag?", "Naar welke muziek ben je momenteel aan het luisteren?", "Wat zijn de examenvragen voor het vak Web4?","Wat zijn de examenvragen voor het vak OSA?"];
    let reactions = [];
    document.getElementById("reactions0").innerHTML = "";
    document.getElementById("reactions1").innerHTML = "";
    document.getElementById("reactions2").innerHTML = "";
    document.getElementById("reactions3").innerHTML = "";
    document.getElementById("reactions4").innerHTML = "";
    for (let x = 0; x < result.length; x++) {
        let newreac = new Reaction(result[x].title, result[x].reactor, result[x].reaction, result[x].rating);
        if (!reactions.includes(JSON.stringify(newreac))) {
            reactions.push(JSON.stringify(newreac));
            let topicid = titles.indexOf(result[x].title);
            let reactioncontainer = document.getElementById("reactions" + topicid);
            //reactioncontainer.innerHTML = ""; //lost het probleem(dubbele reacties vermijden) niet op!!!
            let reactor = document.createElement('p');
            reactor.innerText = result[x].reactor;
            let reaction = document.createElement('p');
            reaction.innerText = result[x].reaction;
            let rating = document.createElement('p');
            rating.innerText = result[x].rating;

            reactioncontainer.appendChild(reactor);
            reactioncontainer.appendChild(reaction);
            reactioncontainer.appendChild(rating);
        }
    }
}



