angular.module('PopoverModule', [])
.directive('defaultPopover', function($compile) {
	
	return {
        restrict: 'A',
        link: function (scope, el, attrs) {
        	//initiate the popover for each item tab (info, photos, videos, etc.)
            $(el).popover({
            	html: true,
    			content: function(){
    				var me = $(this);

    				return $compile($('#' + me.attr("data-popover-content")).html())(scope);    				
    			},
    			trigger: 'click',
    			placement: 'bottom',
    			container: '#main-content .container'
    			//template: '<div class="popover item-meta-popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>'
            });
           
        	
            //once popover is displayed, set the hide event
    	 	$(el).on('shown.bs.popover', function () {
    	 		
    			var me = $(this);
        	 	
    			$('body').on('click', function (e) {
    			    me.each(function () {
    			        //the 'is' for buttons that trigger popups
    			        //the 'has' for icons within a button that triggers a popup
    			        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
    			            $(this).popover('hide');
    			        }
    			    });
    			});	
    		});
        }
    };
    
});