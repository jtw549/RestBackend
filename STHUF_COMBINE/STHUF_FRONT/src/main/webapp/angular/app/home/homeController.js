angular.module('HomeModule').controller('homeCtrl', function ($scope, $location, $rootScope, RestService, SessionService, InventoryService) {
		
	$rootScope.headerView = "login";
	
	$scope.login = function (user) {
		var loginUser = {};
		
		loginUser = {
			//userName:user.userName,
			email:user.email,
			metaPsd:user.password
		};
		
		//rest service from rest module
		RestService.request("login", loginUser).then(
			function(response){ 
				
				//TODO: ADD USER INFO TO LOCAL STORAGE/COOKIE TO HANDLE PAGE REFRESH
				
				//store the signed user info
				SessionService.user.id = response.data.users.userId;
				SessionService.user.username = response.data.users.userName;
				SessionService.user.fullName = response.data.users.firstName + " " + response.data.users.lastName;
				SessionService.user.privacy = response.data.users.userPrivacy;
				SessionService.user.email = response.data.users.email;
				SessionService.user.bio = response.data.users.bio;
				
				//store the user items
				InventoryService.items = response.data.users.usersInventories;
				
				//store the user categories
				InventoryService.categories = response.data.users.usersCategories;
				
				//$cookieStore.put('session', response.data.users.token);
	
				//redirect to the inventory page
				$location.path('/inventory/' + SessionService.user.username);
				
				//switch to non login header
				$rootScope.headerView = "non-login";
				
			},
			function(error){
				console.log(error);
			}
		);

	};
	
	$scope.register = function (user) {
		
		var registerUser = {};
		
		$rootScope.headerView = "non-login";
		
		registerUser = {
			firstName:"",
			lastName:"",
			userName:user.userName,
			email:user.email,
			metaPsd:user.password
			//accessCode:user.accessCode
		};
		
		RestService.request("registerUser", registerUser).then(
			function(response){ 
				
				//TODO: ADD USER INFO TO LOCAL STORAGE/COOKIE TO HANDLE PAGE REFRESH
				
				//store the signed user info
				SessionService.user.id = response.data.userId;
				SessionService.user.username = response.data.userName;
				SessionService.user.privacy = response.data.userPrivacy;
				SessionService.user.email = response.data.email;
				
				//$cookieStore.put('session', response.data.users.token);
	
				//redirect to the inventory page
				$location.path('/inventory/' + SessionService.user.username);
				
				//switch to non login header
				$rootScope.headerView = "non-login";
				
			},
			function(error){
				console.log(error);
			}
		);
		
	};
	
});