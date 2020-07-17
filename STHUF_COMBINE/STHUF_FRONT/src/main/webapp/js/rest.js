/*
 * this file is used to send ajax request to the backend
 *
 */
define('rest',function (require) {

	"use strict";

	var $       	= require('jquery'),
		callApi,
		sendRequest
		;
		
		callApi = function(method, data, url, callback){
			var ajaxOptions;
			
			//get cookie using session model
			
			/* 	headers = {
					//Set the 'Authorization' header 
					'Authorization': {cookieKey}
				};
			*/
			
			//TODO: Remove this, testing purposes only
			console.log("Rest Sent Data: " + JSON.stringify(data));
			
			ajaxOptions = {
				type: method,
				//headers: headers,
				data: JSON.stringify(data),
				contentType: 'application/json',
				dataType: 'json',
				url:url,
				processData: false,
				success: function(data, textStatus, request) {
					//TODO: Remove this, testing purposes only
					console.log(data);
					
					//callback(JSON.stringify(data));
					callback(request);
				},
				error: function(request, textStatus, errorThrown){
					console.log("error: " + errorThrown);
				}
			}

			//call the api
			$.ajax(ajaxOptions);
			
		};
		
		sendRequest = function (method, data, url, callback) {
			//make request to API
            callApi(method, data, url, callback);
        };
		
        return {
        	sendRequest: sendRequest
        };

});