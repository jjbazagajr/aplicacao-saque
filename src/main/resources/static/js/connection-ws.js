                 var stompClient;
                 function connect() {
                    var socket = new SockJS('/chat');
                    stompClient = Stomp.over(socket);
                    stompClient.connect({}, function(frame) {
                        console.log('Connected: ' + frame);
                        stompClient.subscribe('/topic/messages', function(messageOutput) {
                            showMessageOutput(JSON.parse(messageOutput.body));
                        });
                        sendMessage();
                    });
                 }
                 function disconnect() {
                        if(stompClient != null) {
                            stompClient.disconnect();
                        }
                        setConnected(false);
                        console.log("Disconnected");
                 }
                 function sendMessage() {
                    stompClient.send("/app/chat", {},
                    JSON.stringify({'from':'teste', 'text':'text'}));
                 }

                 function showMessageOutput(messageOutput) {
                    console.log(messageOutput);
                 }

                 connect();