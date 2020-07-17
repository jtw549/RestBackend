/**
 * this file is to setup the fake sinon server to do mock/test server calls without need of a backend
 * 
 * requires sinon.js
 */
define(function(require){
	var _initTestServer;
	
	_initTestServer = function() {
		var server,
			$ = require('jquery'),
			Sinon = require('lib/sinon/sinon'),
			strResponse = '{ "status": "error", "message": "Error: Action failed!" }',
			postResponse = "",
			
			//USERS
			login = require("localTest/testCalls/Users/login"),
			registerUser = require("localTest/testCalls/Users/registerUser"),
			
			//NOTES
			addNote = require("localTest/testCalls/Notes/addNote"),
			
			//ITEMS
			addItem = require("localTest/testCalls/Items/addItem"),

			//CATEGORIES
			addCategory = require("localTest/testCalls/Categories/addCategory")	
			//deleteCategory = require("localTest/testCalls/Categories/deleteCategory")
			
		;
		
		server = sinon.fakeServer.create();
		server.autoRespond = true;
		server.autoRespondAfter = 400;
		
		//LOGIN
		strResponse = JSON.stringify(login);	
		server.respondWith("POST", "https://sthuf.com/api/action/users/login",
				[200, { "Content-Type": "application/json" }, strResponse]);

		//REGISTER USER
		strResponse = JSON.stringify(registerUser);	
		server.respondWith("POST", "https://sthuf.com/api/action/users/registerUser", 
				[201, { "Content-Type": "application/json" }, strResponse]);
		
		//ADD ITEM
		postResponse = JSON.stringify(addItem);
		server.respondWith("POST", "post/getItem.json", 
				[200, { "Content-Type": "application/json" }, postResponse]);
		
		//ADD CATEGORY
		strResponse = JSON.stringify(addCategory);		
		server.respondWith("POST", "https://sthuf.com/api/action/categories/addCategory", 
				[201, { "Content-Type": "application/json" }, strResponse]);
		
		//DELETE CATEGORY
		//strResponse = JSON.stringify(deleteCategory);		
		//server.respondWith("POST", "https://sthuf.com/api/action/categories/deleteCategory", 
		//		[201, { "Content-Type": "application/json" }, strResponse]);
		
		//ADD NOTE
		postResponse = JSON.stringify(addNote);
		server.respondWith("POST", "https://sthuf.com/api/action/notes/addNote", 
				[200, { "Content-Type": "application/json" }, postResponse]);
	}
	
	return {
		initTestServer: _initTestServer
	};
});
