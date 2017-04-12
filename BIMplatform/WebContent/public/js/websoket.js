function WebsocketBim(){
    this.socket = null;
    this.code = new Date().getTime()+""+Math.floor(Math.random() * ( 1000 + 1));
    
    this.options = {
        
        dataType:"json",
        onmessage:function(msg){
            return msg;
        },
        onopen:function(msg){
            return msg;
        },
        onclose:function(msg){
            return msg;
        },
        onerror:function(msg){
            return msg;
        }
    };
}

WebsocketBim.prototype.init = function(options){
	var path = window.document.location.pathname;//端口后的路径
    var projectName = path.substring(0,path.substr(1).indexOf("/")+1);
	var url = "ws://"+ window.location.host+projectName+"/";
    //判断当前浏览器是否支持WebSocket
    if (!window.WebSocket) {
        window.WebSocket = window.MozWebSocket;
    }
    if(window.WebSocket){
        this.socket = new WebSocket( url+ (options.urlPath||'') );
    }else{
        alert('当前浏览器 不支持 websocket');
        return;
    }

    //如果存在配置信息
    if(options){
        //初始化默认属性
        options = $.extend(this.options,options);

        //连接发生错误的回调方法
        this.socket.onerror = function (event) {
            options.onerror(event.data);
        };

        //连接成功建立的回调方法
        this.socket.onopen = function (event) {
            options.onopen(event.data);
        };

        //接收到消息的回调方法
        this.socket.onmessage = function (event) {
            //当返回配置为json的时候则配置为json
            if(options.dataType=="json"){
                options.onmessage($.parseJSON(event.data));
            }else{
                options.onmessage(event.data);
            }
        };

        //连接关闭的回调方法
        this.socket.onclose = function (event) {
            options.onclose(event.data);
        };

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            if(this.socket){
                this.socket.close();
            }
        }
    }
};

//发送消息
WebsocketBim.prototype.send = function(msg){
    if (!window.WebSocket) { return; }
    if (this.socket.readyState == WebSocket.OPEN) {
        if(typeof msg == "string"){
            this.socket.send(msg);
        }else{
            msg["code"] = this.code;
            msg.paramsIn = JSON.stringify(msg.paramsIn);
            this.socket.send(JSON.stringify(msg));
        }
    } else {
        alert("连接没有打开！");
    }
};
