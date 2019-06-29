import MessageService from "./message-service.js";

let userId = "BCorbett0312";
const messageService = new MessageService(userId);
const form = document.getElementById("new-message-form");

window.addEventListener("load", function () {
    document.getElementById("greeting").innerHTML = `Welcome ${userId}!`;
    messageService.getAllMessages()
        .then(successCallback, errorCallback);

    function successCallback(response) {
        populateThread(response);
    }

    function errorCallback(response){
        console.log(response);
    }
});


function populateThread(messages) {
    messages.forEach(message => {
        addMessageToThread(message)
    })
}

form.addEventListener("click", createFormListener);

function createFormListener() {


    form.onsubmit = function (event) {
        event.preventDefault();

        const data = {
            fromid: userId,
            message: form.message.value
        };

        messageService.createNewMessage(data)
            .then(successCallback, errorCallback);

        function successCallback(response) {
            addMessageToThread(response);
        }

        function errorCallback(response) {
            console.log(response);
        }
    }
};


function addMessageToThread(message){

    const messageListItem = document.createElement("li");
    const userIdHeading = document.createElement("h3");
    const messageParagraph = document.createElement("p");
    const messageContent = document.createTextNode(message.message);
    const userIdContent = document.createTextNode(message.fromid);
    userIdHeading.appendChild(userIdContent);
    messageParagraph.appendChild(messageContent);
    messageListItem
        .appendChild(userIdHeading)
        .appendChild(messageParagraph);
    document.getElementById("message-list").appendChild(messageListItem);
}

