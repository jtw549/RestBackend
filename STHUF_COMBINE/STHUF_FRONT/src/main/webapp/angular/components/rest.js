angular.module('RestModule', 
	[
	 	'ConfigModule'
	]
)	
.factory('RestService', function($http, $q, CONFIG) {
	var restService = {};

	//regular ajax request
	restService.request = function(action, data) {
		//TODO: get token from cookie
		//$http.defaults.headers.common['X-Access-Token'] = token || $cookies.token;
		var headers = {'Content-Type':'application/json'},
			callApi,
			currentHost;

		currentHost = CONFIG.env;
		
		console.log("Rest Sent Data >>");
		console.log(data);
		
		callApi = function(action, data){ 
			
			var deferred = $q.defer();

			$http({
				method: 'POST', 
				url: CONFIG[currentHost] + CONFIG.endpoints[action],
				data: angular.toJson(data),
				headers: headers,
				responseType: 'json'
			})
			.then(function(response){
				console.log("Rest Response Data >>");
				console.log(response);
				deferred.resolve(response);
			}, function(error){
				console.log(error);
				deferred.reject(error);
			});
			
			
				
            return deferred.promise;
            
		};		 
		
		return callApi(action, data);
	};
	
	//ajax request with upload file capability
	restService.uploadRequest = function(action, data) {
		//TODO: get token from cookie
		//$http.defaults.headers.common['X-Access-Token'] = token || $cookies.token;
		
		//browser should change to multipart/form-data...manually setting it will fail
		var headers = {'Content-Type':undefined},
			callApi,
			currentHost;

		currentHost = CONFIG.env;;
		
		console.log("Rest Sent Data >>");
		console.log(data);
		
		callApi = function(action, data){ 
			
			var deferred = $q.defer();
			
			$http({
				method: 'POST', 
				url: CONFIG[currentHost] + CONFIG.endpoints[action],
				data: data,
				headers: headers,
				transformRequest: angular.identity
			})
			.then(function(response){
				console.log("Rest Response Data >>");
				console.log(response);
				deferred.resolve(response);
			}, function(error){
				console.log(error);
				deferred.reject(error);
			});
				
            return deferred.promise;
            
		};		 
		
		return callApi(action, data);
	};
	
	return restService;
});