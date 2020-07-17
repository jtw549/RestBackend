angular.module('ConfigModule',[])

.constant("CONFIG", {
	//enableTest: false,
	env: "mockUrl",
	localUrl: "http://localhost:8080/STHUF_WebService-3.0-SNAPSHOT/api/action/",
	mockUrl: "http://localhost:8080/mock/api/action/",
	testUrl: "http://sthuf.com/test/api/action/",
	prodUrl: "http://sthuf.com/api/action/",
	endpoints:{
		login: "users/login",
		addItem: "items/addItem",
		updateItem: "items/updateItem",
		deleteItem: "items/deleteItem",
		registerUser: "users/registerUser",
		addCategory: "categories/addCategory",
		updateCategory: "categories/updateCategory",
		deleteCategory: "categories/deleteCategory",
		addNote: "notes/addNote",
		addMedia: "media/addMedia"
	}
});


