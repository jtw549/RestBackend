/*
 * this is the application router/controller
 * 
 */
define(function(require){

	var $ 				= require('jquery'),
		_				= require('underscore'),
		Util			= require('util'),
		HomeView 		= require('views/home/home'),
		InventoryView 	= require('views/inventory'),
		ItemView 		= require('views/items/itemView'),
		ByCategoryView 	= require('views/items/byCategoryView'),
		FriendsView 	= require('views/friends/friends'),
		ExploreView 	= require('views/explore'),
		checkUserAuth,
		AppRouter
	;

	AppRouter = Backbone.Router.extend({
		
		initialize: function(){
            _.bindAll(this);
        },
        
		routes: {
			/*INVENTORY*/
			'inventory/:id': 'requestUserInventory',
			'item/:id': 'requestItemView',
			'category/:id': 'requestByCategoryView',

			'friends': 'requestUserFriendsView',

			'explore': 'requestExploreView',

			'logout': 'requestLogout',

			//Default
			'': 'requestHomeView'
		},
		
		requestHomeView: function(actions){
			console.log('the home page');
			
			var homeView = new HomeView();
			Util.changeView(homeView);
		},

		requestUserInventory: function(){
			console.log('user inventory');
			
			//check if user is authenticated
			//checkUserAuth();
			var inventoryView = new InventoryView({el:"#main-content .container"});
			Util.changeView(inventoryView);
		},
	
		requestUserFriendsView: function(){
			console.log('this is the friends page');
	
			var friendsView = new FriendsView();
			Util.changeView(friendsView);
	
		},
	
		requestExploreView: function(){
			console.log('this is the explore page');
	
			var exploreView = new ExploreView();
			Util.changeView(exploreView);
	
		},
	
		requestLogout: function(){
			console.log('this is the logout page');
		}
	});
	
	// Check the auth status upon initialization,
    // if not auth redirect to home page
	/*checkUserAuth = function(){
		require(['app'], function(App){
			if(!App.session.checkAuth())
		    	App.router.navigate("home", {trigger: true});          
		})
	}*/
	
	return AppRouter;

});

