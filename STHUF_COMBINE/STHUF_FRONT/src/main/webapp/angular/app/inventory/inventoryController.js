angular.module('InventoryModule').controller('inventoryCtrl', function($scope, $rootScope, InventoryService, UtilService) {
	
	//set main controller templates
	$rootScope.inventoryTemplate = {
		categoryListView:  "templates/inventory/categories/categoryListView.html",
		itemListView: "templates/inventory/items/itemListView.html",
		itemListThumbView: "templates/inventory/items/itemListThumbView.html",
		itemDetailView: "templates/inventory/items/itemDetailView.html"
	};
	
	//set inventory modal templates
	$rootScope.inventoryModal = {
		view: "",
		addCategoryView:  "templates/inventory/categories/addCategoryView.html",
		editCategoryView:  "templates/inventory/categories/renameCategoryView.html",
		deleteCategoryView:  "templates/inventory/categories/deleteCategoryView.html",
		addItemView:  "templates/inventory/items/addItemView.html",
		deleteItemView:  "templates/inventory/items/deleteItemView.html",
		addItemNoteView: "templates/inventory/notes/addNoteView.html",
		addItemPhotoView: "templates/inventory/photos/addPhotoView.html"
	};
	
	//set the content view to the item list thumb view
	$rootScope.inventoryTemplate.contentView = 'itemListThumbView';
	
	//set models for categories and items
	$scope.userCategories = InventoryService.categories;
	$scope.userItems = InventoryService.items;
	$scope.userItem = {};

	//listener for category selected
	$scope.$on('category:selected', function() {
		var items; 
		
		//highlight menu item - all
		UtilService.highlightMenuItem($("#item-column .list-group-item"), $("#item-column .list-group-item .item-all"));
	
		if(InventoryService.categoryId != '0'){
			//filter items by selected category
			items = InventoryService.filterItemsByCategory(InventoryService.items, InventoryService.categoryId);
		}
		else{
			items = InventoryService.items;
		}
		
		//update user items
		$scope.userItems = items;
		
		//switch to item thumbnail view
		if($rootScope.inventoryTemplate.contentView != "itemListThumbView")
			$rootScope.inventoryTemplate.contentView="itemListThumbView";
	});
	
	//listener for item selected
	$scope.$on('item:selected', function() {
		var item;
		
		//item selected does not equal to all
		if(InventoryService.itemId != '0'){
			//switch to detail view
			if($rootScope.inventoryTemplate.contentView != "itemDetailView"){
				$rootScope.inventoryTemplate.contentView="itemDetailView";
			}
		
			//filter items by selected item
			item = InventoryService.filterItemsById(InventoryService.items, InventoryService.itemId);
		}	
		else {
			//switch to item thumbnail view
			if($rootScope.inventoryTemplate.contentView != "itemListThumbView"){
				$rootScope.inventoryTemplate.contentView="itemListThumbView";
			}
			
			//show all items if selected category = 0 otherwise filter items based on selected category
			if(InventoryService.categoryId == '0'){
				item = InventoryService.items;
			}
			else{
				item = InventoryService.filterItemsByCategory(InventoryService.items, InventoryService.categoryId);
			}
		}	
		
		//update user item model
		$scope.userItem = item;
		
		$rootScope.itemFieldsView = "itemInfoFieldsView";
		
    });
});

angular.module('InventoryModule').controller('categoryCtrl', function ($scope, $rootScope, InventoryService, UtilService) {
	
	//handle category selected click event
	$scope.categorySelected = function(e){
		e.preventDefault();
		
		var categoryId = e.currentTarget.attributes.data.value;
	 	
		// store the selected id
		InventoryService.categoryId = categoryId;
		
		//highlight selected category
		UtilService.highlightMenuItem($("#categories-column .list-group-item"), $(e.currentTarget));
		
		//broadcast the category selected click event
		$rootScope.$broadcast('category:selected');
	};
	
	$scope.addCategorySelected = function(e){
		e.preventDefault();
		
		$rootScope.inventoryModal.view = $rootScope.inventoryModal.addCategoryView;
		
		$('#inventoryModal').modal('show');
	};
	
	$scope.editCategorySelected = function(e){
		e.preventDefault();
		
		$rootScope.inventoryModal.view = $rootScope.inventoryModal.editCategoryView;
		
		$('#inventoryModal').modal('show');
	};
	
	$scope.deleteCategorySelected = function(e){
		e.preventDefault();
		
		if(InventoryService.categoryId !== '0'){
			//set the content in modal and show the modal
			$rootScope.inventoryModal.view = $rootScope.inventoryModal.deleteCategoryView;
			$rootScope.inventoryModal.categoryName = $("#categories-column .active .category-name").text();
			
			$('#inventoryModal').modal('show');
		}
	};
	
});

angular.module('InventoryModule').controller('addCategoryCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	//add item model
	var resetCategoryModel = function(){
		$scope.category = {
			userId:"",
			categoryName:"",
			associatedCategoryId:"",
			userCategoriesId:"",
			dateAdded:""
		};
	};
	
	//reset the category model
	resetCategoryModel();
	
	$scope.categories = InventoryService.categories;
	
	$scope.addCategory = function () {
		
		//set the current user id
		$scope.category.userId = SessionService.user.id;
		
		//regular ajax POST
		RestService.request("addCategory", angular.toJson($scope.category)).then(
			function(response){ 
				
				//add new item to the item collection
				$scope.category.categoryName = response.data.categoryName;
				$scope.category.associatedCategoryId = response.data.associatedCategoryId;
				$scope.category.userCategoriesId = response.data.userCategoriesId;
				$scope.category.dateAdded = response.data.dateAdded;
				InventoryService.categories.push($scope.category);

				//update selected item id 
				InventoryService.categoryName = response.data.categoryName;

				//broadcast selected item to show item detail view
				$rootScope.$broadcast('category:selected');

				//reset the model form
				resetCategoryModel();
				
				//hide modal
		    	$("#inventoryModal").modal('hide');
		    	$('#categoryNameTxt').val('');
			},
			function(error){
				console.log(error);
			}
		);
    };
});

angular.module('InventoryModule').controller('deleteCategoryCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	var data = {
		"category": {
			"userId": SessionService.user.id,
            "id": InventoryService.userCategoriesId
        }
	};
	
	$scope.deleteCategory = function () {
		RestService.request("deleteCategory", data).then(
				function(response){ 
					//delete item from list
					InventoryService.deleteCategory(InventoryService.categories, InventoryService.categoryId);
					
					//update selected item id 
					InventoryService.categoryId = '0';
					
					//highlight new item
					
					//recall category selected event to refresh view
					$rootScope.$broadcast('category:selected');
					
					//hide modal
			    	$("#inventoryModal").modal('hide');
				},
				function(error){
					console.log(error);
				}
			);
    };
});

angular.module('InventoryModule').controller('itemListCtrl', function ($scope, $rootScope, InventoryService, UtilService) {
	
	//handle items selected event
	$scope.itemSelected = function(e){
		e.preventDefault();
		
		//get the id of the selected item
		var itemId = e.currentTarget.attributes.data.value;
	 		
		// store the selected id
		InventoryService.itemId = itemId;
		
		//highlight selected item
		UtilService.highlightMenuItem($("#item-column .list-group-item"), $(e.currentTarget));
		
		//broadcast the item selected click event
		$rootScope.$broadcast('item:selected');
	};	
	
	$scope.addItemSelected = function(e){
		e.preventDefault();
		
		$rootScope.inventoryModal.view = $rootScope.inventoryModal.addItemView;
		
		$('#inventoryModal').modal('show');
	};
	
	$scope.deleteItemSelected = function(e){
		e.preventDefault();
		
		if(InventoryService.itemId !== '0'){
			//set the content in modal and show the modal
			$rootScope.inventoryModal.view = $rootScope.inventoryModal.deleteItemView;
			$rootScope.inventoryModal.itemName = $("#item-column .active a").text();
			
			$('#inventoryModal').modal('show');
		}
	};
});



angular.module('InventoryModule').controller('itemListThumbCtrl', function ($scope, $rootScope, InventoryService, UtilService) {

	//handle items selected event
	/*$scope.itemSelected = function(e){
		e.preventDefault();
		console.log(e.target.attributes.data.value);
		
		var itemId = e.target.attributes.data.value;
	 	
		// store the selected id
		InventoryService.itemId = itemId;
		
		//highlight selected menu item
		UtilService.highlightMenuItem($("#inventory-column .list-group-item"), $(e.currentTarget));
		
		
	}*/		
	
});

angular.module('InventoryModule').controller('itemDetailCtrl', function ($scope, $rootScope, InventoryService, UtilService) {
	//views for the item tab
	$scope.itemTab = {
		view: "",
		itemInfoView:  "templates/inventory/items/itemInfoView.html",
		itemPhotoListThumbView: "templates/inventory/photos/photoListThumbView.html",
		itemVideoListThumbView: "templates/inventory/videos/videoListThumbView.html",
		itemNoteListView: "templates/inventory/notes/noteListView.html",
		itemReceiptListThumbView: "templates/inventory/receipts/receiptListThumbView.html",
		itemWarrantyView: "templates/inventory/warranty/warrantyView.html",
		itemCommentListView: "templates/inventory/comments/commentListView.html",
		itemShareView: "templates/inventory/share/shareView.html",
		itemSellView: "templates/inventory/ecommerce/sellView.html"
	};
	
	//swap between item view and edit item view
	$rootScope.itemInfoTemplate = {
		contentView: "",
		itemInfoFieldsView:  "templates/inventory/items/itemInfoFieldsView.html",
		editItemInfoView: "templates/inventory/items/editItemInfoView.html"
	};
	
	//switch view based on selected tab
	$scope.itemTabSelected = function (e, tab) {
		e.preventDefault();
		$scope.itemTab.view = $scope.itemTab[tab];
    };
	
	//highlight selected tab
	$scope.isActiveTab = function(tab) {
        return $scope.itemTab.view == $scope.itemTab[tab];
    };
	
	//assign item info view onload
	$scope.itemTab.view = $scope.itemTab.itemInfoView;
	
});


angular.module('InventoryModule').controller('addItemCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	//add item model
	var resetItemModel = function(){
		$scope.item = {
			userId:SessionService.user.id,
			make:"",
			inventoryName:"",
			description:"",
			categories:{
				data:{}
			},
			media:{
				userId:SessionService.user.id,
				itemId:"",
				caption:"",
				mediaType:"images"
			}
		};
		
		$scope.files = [];
	};
	
	//reset the item model
	resetItemModel();
	
	$scope.categories = InventoryService.categories;
	
	$scope.addItem = function () {
		
		//set the current user id
		$scope.item.userId = SessionService.user.id;
		
		//send data using form data object for file upload
		var formData = new FormData();
		formData.append('file', $scope.files[0]);
		formData.append('data', angular.toJson($scope.item));
		
		//use uploadRequest method for file upload
		RestService.uploadRequest("addItem", formData).then(
			function(response){ 
				//console.log(response);
				
				//add new item to the item collection
				$scope.item.id = response.data.id;
				$scope.item.dataAdded = response.data.dataAdded;
				$scope.item.photos = response.data.photos;
				InventoryService.items.push($scope.item);
				
				//update selected item id 
				InventoryService.itemId = response.data.id;
				
				//highlight new item
				
				//broadcast selected item to show item detail view
				$rootScope.$broadcast('item:selected');
				
				//rest the item model to rest form
				resetItemModel();
				
			},
			function(error){
				console.log(error);
			}
		);
    };
});

angular.module('InventoryModule').controller('deleteItemCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	$scope.deleteItem = function () {
		var data = {
			"item": {
				"userId": SessionService.user.id,
                "id": InventoryService.itemId
            }
		}
		
		//send request for delete item 
		RestService.request("deleteItem", data).then(
			function(response){ 
				
				//delete item from list
				InventoryService.deleteItemById(InventoryService.items, InventoryService.itemId);
				
				//update selected item id 
				InventoryService.itemId = 0;
				
				//highlight new item
				
				//recall category selected event to refresh view
				$rootScope.$broadcast('category:selected');
			},
			function(error){
				console.log(error);
			}
		);
	};
});


angular.module('InventoryModule').controller('itemInfoCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	//form model
	var resetEditItemModel = function(){
		
		$scope.selectedItem = {
			userId:SessionService.user.id,
			itemId:InventoryService.itemId,
			make:null,
			inventoryName:null,
			description:null,
			seller:null,
			purchaseDate:null,
			cost:null,
			model:null,
			quantity:null
		};
		
	};
	
	//reset the item model
	resetEditItemModel();
	
	//display the edit info form 
	$scope.editInfo = function(e){
		e.preventDefault();
		$rootScope.itemFieldsView = "editItemInfoView";
	};
	
	
	//edit item
	$scope.editItem = function(){
		
		//get the form input
		var data = $scope.selectedItem;
		
		//update field with original if no answer was given
		angular.forEach(data, function(prop, propKey) {
			if(prop === null){
				data[propKey] = $scope.userItem[0][propKey];
			}
		});
		
		//send request for update item  
		RestService.request("updateItem", data).then(
			function(response){ 

				//update the item object with the new answers
				angular.forEach(data, function(prop, propKey) {
					$scope.userItem[0][propKey] = data[propKey];
				});
				
				//back to non-edit view
				$rootScope.itemFieldsView = "itemInfoFieldsView";
				
				//reset the item model
				resetEditItemModel();
				
			},
			function(error){
				console.log(error);
			}
		);
		
	};
	
	//cancel edit item button
	$scope.cancelEditItem = function(){
		//back to non-edit view
		$rootScope.itemFieldsView = "itemInfoFieldsView";
	};
	
	
});


angular.module('InventoryModule').controller('itemNotesCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	//add item model
	var resetNoteModel = function(){
		$scope.note = {
			id:"",
			userId:"",
			itemId:"",
			title:"",
			description:"",
			dateAdded:""
		};
	};
	
	//reset the category model
	resetNoteModel();
	
	//display add note form
	$scope.addNoteView = function(e){
		e.preventDefault();

		$rootScope.inventoryModal.view = $rootScope.inventoryModal.addItemNoteView;
		
		$('#inventoryModal').modal('show');	
	};
	
	//add note
	$scope.addNote = function(){
		
		var data = $scope.note;
		
		//set the current user id
		data.userId = SessionService.user.id;
		
		//set the itemId property
		data.itemId = InventoryService.itemId;
		
		//send request for add note  
		RestService.request("addNote", data).then(
			function(response){ 
				
				//set the id property
				$scope.note.id = response.data.id;
				
				//set the dataAdded property
				$scope.note.dateAdded = response.data.dateAdded;
				
				/* TODO: Sort the object by date DESC*/ 
				$scope.userItem[0].notes.data.push($scope.note);

				//reset the model form
				resetNoteModel();
				
				//hide modal
		    	$("#inventoryModal").modal('hide');
			},
			function(error){
				console.log(error);
			}
		);
	};
});


angular.module('InventoryModule').controller('itemPhotosCtrl', function ($scope, $rootScope, InventoryService, SessionService, RestService) {
	
	//add photo model
	var resetPhotoModel = function(){
		$scope.photo = {
			userId:"",
			itemId:"",
			caption:"",
			mediaType:"images"
		};
		
		$scope.photoFiles = [];
	};
	
	//reset the category model
	resetPhotoModel();
	
	//display add note form
	$scope.addPhotosView = function(e){
		e.preventDefault();

		$rootScope.inventoryModal.view = $rootScope.inventoryModal.addItemPhotoView;
		
		$('#inventoryModal').modal('show');	
	};
	
	$scope.addPhotos = function () {
		
		//set the current user id
		$scope.photo.userId = SessionService.user.id;
		
		//set the current item id
		$scope.photo.itemId = InventoryService.itemId;
		
		//send data using form data object for file upload
		var formData = new FormData();
		formData.append('file', $scope.photoFiles[0]);
		formData.append('data', angular.toJson($scope.photo));
		
		//use uploadRequest method for file upload
		RestService.uploadRequest("addMedia", formData).then(
			function(response){ 
				console.log(response.data.photos.data);
				//add new photo to the collection
				InventoryService.addItemPhoto(InventoryService.items, InventoryService.itemId, response.data.photos.data[0]);
				
				//rest the item model to rest form
				resetPhotoModel();
				
			},
			function(error){
				console.log(error);
			}
		);
    };
});