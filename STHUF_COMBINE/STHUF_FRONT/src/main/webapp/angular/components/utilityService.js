angular.module('mainApp').factory('UtilService', function() {
	var utilService = {};
	
	utilService.highlightMenuItem = function(menu, menuItem){
		menu.removeClass("active");
		menuItem.parent().addClass("active");
	};
	
	utilService.closePopover = function (el){
		el.popover('hide');
	};
	
	return utilService;
});