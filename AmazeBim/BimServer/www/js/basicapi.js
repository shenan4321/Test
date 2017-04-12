function BasicApi(serverAddress) {
	var o = this;
	
	o.serverAddress = serverAddress;
	
	this.call = function(interface, method, parameters, callback, errorCallback) {
		var request = {
			request: {
				interface: interface,
				method: method,
				parameters: parameters
			}
		};
		if (o.token != null) {
			request.token = o.token;
		}
		$.ajax({
			dataType: "json",
			method: "POST",
			url: o.serverAddress + "/json",
			data: JSON.stringify(request),
			success: function(response){
				if (response.response.exception == null) {
					if (interface == "AuthInterface" && method == "login") {
						o.token = response.response.result;
					}
					callback(response.response.result);
				} else {
					if (errorCallback == null) {
						console.error(response.response.exception.message);
					} else {
						errorCallback(response.response.exception.message);
					}
				}
			}
		});
	}
}