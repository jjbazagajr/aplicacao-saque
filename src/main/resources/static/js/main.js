var stompClient;
var cardSelected;
var valWithDraw
function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        var url = stompClient.ws._transport.url;
        console.log(url);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/saque', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
    stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/saque", {},
    JSON.stringify({'action':'withdraw', 'cardNumber': cardSelected, 'amount': valWithDraw}));
}

function showMessageOutput(messageOutput) {
    console.log(messageOutput);
    var htmlResult = '<div> ';
    htmlResult += JSON.stringify(messageOutput);
    htmlResult += '</div>'
    $("#resultContent").html(htmlResult);
}

$( document ).ready(function() {
    connect();
    getCards();
});

function sacar() {
    valWithDraw = $("#valSaque").val();
    if(!cardSelected || !valWithDraw) {
        alert('Selecione o cartão e ou preencha o valor para saque');
        return;
    }
    console.log(valWithDraw);
    sendMessage();
    setTimeout(function(){ getCards(); }, 550);
}

function getCards() {
   $.ajax({url: "/credit-card", success: function(result) {
       renderizaCards(result);
       $("#contentCreditCards").val("");
       cardSelected = null;
    }});
}

function bindEventRadioCards() {
  $('input[type=radio][name=card]').change(function() {
        cardSelected = this.value;
        console.log(cardSelected);
  });
}

function renderizaCards(result) {
    var creditCards = result;
    console.log(creditCards);
    var htmlList = '<h4>Cartões disponíveis</h4>' + '<ul>';
    for(var indice = 0; indice < creditCards.length; indice++) {
        var cardNumber = creditCards[indice].cardNumber;
        var availableAmount = creditCards[indice].availableAmount;
        htmlList += '<li>'
        htmlList += 'número: ' + cardNumber;
        htmlList += ' - ';
        htmlList += 'disponível: ' + availableAmount;
        htmlList += `<input type="radio" id="${cardNumber}" name="card" value="${cardNumber}">`
        htmlList += '</li>';
    }
    htmlList.concat('</ul>')
    $("#contentCreditCards").html(htmlList);
    bindEventRadioCards();
 }