angular.module('InventoryModule').service('InventoryService', function($http) {
	
	this.categoryId = '0';
	
	this.itemId = '0';
	
	this.categories = [];
	
	this.items = [];
	
	this.user = [];
	
	this.filterItemsByCategory = function(items, categoryId){
		var filteredObject = [];
		
		angular.forEach(items, function(item, itemKey) {
			if(item.categories.data){
				angular.forEach(item.categories.data, function(category, categoryKey) {
					if((category.userCategoriesId || category.id) == categoryId){
			        	filteredObject.push(item);
			        }
				});
			}
		});
		
		return filteredObject;
	};
	
	this.deleteCategory = function(categories, categoryId){
		angular.forEach(categories, function( category, itemKey) {
			if( category.userCategoriesId == categoryId){
				categories.splice(itemKey, 1);
			}
		});
	};
	
	this.filterItemsById = function(items, itemId){
		var filteredObject = [];
		
		/*
		 * TODO: ADD BREAK ONCE ID HAS BEEN FOUND
		 */
		angular.forEach(items, function(item, itemKey) {
			if(item.id == itemId){
				filteredObject.push(item);
			}
		});
		
		return filteredObject;
	};
	
	this.deleteItemById = function(items, itemId){
		angular.forEach(items, function(item, itemKey) {
			if(item.id == itemId){
				items.splice(itemKey, 1);
			}
		});
	};
	
	this.addItemPhoto = function(items, itemId, photo){
		angular.forEach(items, function(item, itemKey) {
			if(item.id == itemId){
				item.photos.data.push(photo);
			}
		});
	};
	
});