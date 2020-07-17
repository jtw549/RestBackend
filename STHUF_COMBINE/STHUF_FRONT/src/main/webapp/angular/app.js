angular.module('mainApp',
  [	
	'ngRoute',
	'ngMockE2E',
	'ConfigModule',
	'RestModule',
	'HomeModule',
	'SessionModule',
	'InventoryModule'
  ]
)

.config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'templates/home/homeContentView.html',
			controller: 'homeCtrl'
		})
		.otherwise({
			redirectTo: '/'
		})
})

.run(function($httpBackend, MockDataService, CONFIG) {
	
	var currentHost = CONFIG.env;
	
	//DATA MOCKS FOR TESTING - TODO comment out block and ngMockE2E during build
	if (currentHost == "mockUrl"){
		
		angular.forEach(CONFIG.endpoints, function(endpoint, endpointKey) {
			$httpBackend.whenPOST(CONFIG[currentHost] + endpoint).respond(function(method, url, data) {
		        var response = MockDataService[endpointKey];
		        return [201, response, {}];
		    });
		});
	}	
	else{
		
		//allow actual calls to backend
		angular.forEach(CONFIG.endpoints, function(endpoint, endpointKey) {
			$httpBackend.whenPOST(CONFIG[currentHost] + endpoint).passThrough();
		});
	}
	
	/* BYPASS CALLS TO TEMPLATES */
	$httpBackend.whenGET(/templates\//).passThrough();
});
