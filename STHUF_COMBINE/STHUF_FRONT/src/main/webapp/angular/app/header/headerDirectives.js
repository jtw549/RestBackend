angular.module('mainApp').directive('loginView', function (){
		
	var directive = {};

	directive.restrict = 'E';
	directive.templateUrl = "templates/header/loginHeaderView.html";

	return directive;
	
});

angular.module('mainApp').directive('nonLoginView', function () {
			
	var directive = {};

	directive.restrict = 'E';
	directive.templateUrl = "templates/header/nonLoginHeaderView.html";

	return directive;
	
});