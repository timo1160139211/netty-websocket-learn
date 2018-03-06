

var socket;

if(!window.WebSocket){
	window.WebSocket = window.MozWebSocket;
}

if(window.WebSocket){
    socket = new WebSocket("ws://localhost:8888/websocket");
    socket.onmassage = function(e){
        var ta = document.getElementById("responseContent");
        ta.value += event.data + "\r\n";
    }
    socket.onopen = function(e){
        var ta = document.getElementById("responseContent");
        ta.value = "WebSocket 已开启。\r\n";  
    }
    
    socket.onclose = function(e){
        var ta = document.getElementById("responseContent");
        ta.value += event.data + "WebSocket 已关闭。\r\n"; 
    }
    
}else{
	alert("您的浏览器不支持WebSocket");

}

function send(message){
    if(!window.WebSocket){
        return;
    }
  
    if(socket.readyState == WebSocket.OPEN){
        socket.send(massage);
    }else{
        alert("WebSocket连接建立失败");
    }

}





