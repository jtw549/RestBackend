/*
 * this file is to configure the application dependencies 
 * it loads the rest.js file to override the Backbone.sync function
 */
require.config({
	baseUrl: 		'./js',
	
	//Loads javascript dependencies
	paths: {
		jquery: 	'lib/jquery/dist/jquery.min',
		underscore: 'lib/lodash/dist/lodash.underscore.min',
		backbone: 	'lib/backbone-amd/backbone-min',
		bootstrap: 	'lib/bootstrap/dist/js/bootstrap.min',
		handlebars: 'lib/handlebars/handlebars'
	},
	
	// non-AMD lib
    shim: {
    	'jquery': { 
    		exports  : '$' 
    	},
        'underscore': { 
        	deps:["jquery"],
        	exports  : '_' 
        },
        'bootstrap': {
	        deps: ['jquery'],
	        exports: "bootstrap"
	     },
         'handlebars': { 
          	exports  : 'Handlebars' 
         },
    }

});

//initiate and overwrite Backbone sync
require(['init', 'rest'], function(App, Rest){
	  // initialize the application
	  App.initialize();
});
