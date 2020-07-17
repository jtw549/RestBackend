angular.module('InventoryModule').directive('itemFields', function ($rootScope, $compile, $http, $templateCache, UtilService){
		
	var directive = {};

	directive.restrict = 'A';
	
	directive.link = function(scope, element, attrs) {
        
        attrs.$observe("status",function(val){
        	
        	switch (val){
        	
        		case "editItemInfoView":
		        	var editTemplate = $http.get("templates/inventory/items/editItemInfoView.html", {cache: $templateCache});
		            
		        	editTemplate.success(function(html) {
		        		//compile the html from the template and add it to the DOM
		        		template = angular.element($compile(html)(scope));
		                element.html(template);
		                
		                //set focus to 'Make' field
		                $("#make").focus();
		                
		                //close popover
		                UtilService.closePopover($(".icon-settings"));
		            });
	        	
		        	break;
		        	
        		case "itemInfoFieldsView":
		        	var itemInfoFieldsTemplate = $http.get("templates/inventory/items/itemInfoFieldsView.html", {cache: $templateCache});
		            
		        	itemInfoFieldsTemplate.success(function(html) {
		        		template = angular.element($compile(html)(scope));
		                element.html(template);
		            });
		        	
		        	break;
		        
		        default:
		        	var itemInfoFieldsTemplate = $http.get("templates/inventory/items/itemInfoFieldsView.html", {cache: $templateCache});
	            
		        	itemInfoFieldsTemplate.success(function(html) {
		        		template = angular.element($compile(html)(scope));
		                element.html(template);
		            });
	        	
        	};
        	
        });
    };

	return directive;
	
});