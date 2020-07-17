angular.module('SessionModule', [
                              
])
.config(function($routeProvider) {
	$routeProvider
		.when('/profile', {
			templateUrl: '',
			controller: 'sessionController',
			resolve: {
				
			}
		})
});