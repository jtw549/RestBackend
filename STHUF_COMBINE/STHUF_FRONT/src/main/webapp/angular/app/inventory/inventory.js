angular.module('InventoryModule', ['checkboxListModule', 'PopoverModule', 'previewImageModule'])
.config(function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/inventory/:username', {
			templateUrl: 'templates/inventory/inventory.html',
			controller: 'inventoryCtrl',
			resolve:{
				/*userInventory: function(RestService, InventoryService){
					RestService.request("getUserInventory", user).then(
						function(response){ 
						
							//store the user items
							InventoryService.items = response.data.users.usersInventories;
							
							//store the user categories
							InventoryService.categories = response.data.users.usersCategories;
							
							$rootScope.headerView = "non-login";
				
							//$cookieStore.put('token', token);
							
							$location.path('/inventory/curtiszjohn');
							
						},
						function(error){
							console.log(error);
						}
					);
				}*/
			}
		})
});