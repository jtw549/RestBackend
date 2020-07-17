angular.module('mainApp').factory('MockDataService', function() {
	var mockData = {};
	
	// login
	mockData.login = {"users":{"userId":"5000","firstName":"John","lastName":"Doe","username":"curtiszjohn","email":"jdoe@test.com","bio":"","privacy":"private","usersInventories":[{"id":"32FKLJRWLKJRLK3JLKFSDF","make":"Apple","inventoryName":"iPad Air","description":"test","seller":"Apple Store","cost":"499.99","purchaseDate":"","quantity":"1","model":"","condition":"New","dateAdded":"","privacy":"","categories":{"count":"2","data":[{"id":"1111111","name":"Electronics","dateAdded":""}]},"photos":{"count":"2","privacy":"","data":[{"id":"","src":"http://sthuf.com/images/ipad.jpg"},{"id":"","src":"http://sthuf.com/images/ipad.jpg"},{"id":"","src":"http://sthuf.com/images/ipad.jpg"}]},"videos":{"count":2,"privacy":"","data":[{"id":"","src":"http://sthuf.com/images/ipadvid.jpg"}]},"notes":{"count":2,"privacy":"","data":[{"id":2,"title":"Testing the notes","description":"akdsjfkldajs ofijdslkfjdaslfk jdsalkf ajdsklfj ldska jafkladsjf lskdjf aklsdf jdsfkdjsaklf jadsklf jadsklfj dasklfj adslkfja;sdlf jdsa klfja dslfkjadsl;kfj dsakljf ldksafj ","dateAdded":"June 4, 2013"},{"id":4,"title":"dsfasdfadsfadsfdasf r","description":"adsfdasf ads fdasf dasf adsf dasf dsaf dsafasd fdfsda fds","dateAdded":"July 12, 2013"}]},"receipts":{"count":2,"privacy":"","data":[{"id":"","src":""}]},"warranty":{"count":2,"privacy":"","data":[{"id":"","issuer":"Target","type":"Manufacturer","term":"24 Months","contactInfo":"123-234-2345","notes":"dfsjak dsakl fjadsklfjdslkfjdsklfj adslfkjdas flkdsaj flkadjsf"}]},"comments":{"count":2,"privacy":"","data":[{"id":"","comment":"testing the comments for apple air product.  cool product","dateAdded":"May 30th, 2014","user":{"id":"","firstName":"Jane","lastName":"Thomas","photoSrc":"http://sthuf.com/images/placeholder-small.jpg"}},{"id":"","comment":"testing the comments","dateAdded":"June 30, 2014","user":{"id":"","firstName":"Joe","lastName":"Thomas","photoSrc":"http://sthuf.com/images/placeholder-small.jpg"}}]},"share":{"permLink":""},"ecommerce":{"selling":"","amount":"","description":"","privacy":""}},{"id":"43jrj4kl3rjq4wlk3jrq3wkl4jr","make":"AB Roller","inventoryName":"Evolution","description":"testtesttest","seller":"Target","cost":"499.99","purchaseDate":"","quantity":"1","model":"","condition":"New","dateAdded":"","privacy":"","categories":{"count":2,"data":[{"id":"2222222","name":"Exercise","dateAdded":""}]},"photos":{"count":2,"privacy":"","data":[{"id":"","src":"http://sthuf.com/images/abroller.jpg"}]},"videos":{"count":2,"privacy":"","data":[{"id":"","src":"http://sthuf.com/images/abrollervid.jpg"}]},"receipts":{"count":"2","privacy":"","data":[{"id":"","src":"http://sthuf.com/images/receipt.jpg"},{"id":"asdf","src":"http://sthuf.com/images/receipt.jpg"}]},"warranty":{"count":2,"privacy":"","data":[{"id":"","issuer":"Target","type":"Store","term":"1 Year","contactInfo":"123-234-2345","notes":"dslfkjdas flkdsaj flkadjsf"}]},"notes":{"count":2,"privacy":"","data":[{"id":"2","title":"Testing the notes for ab roller","description":"akdsjfkldajs ofijdslkfjdaslfk jdsalkf ajdsklfj ldska","dateAdded":"July 12, 2013"},{"id":"4","title":"dsfasdfadsfadsfdasf r","description":"adsfdasf ads fdasf dasf adsf dasf dsaf dsafasd fdfsda fds","dateAdded":"July 12, 2013"}]},"comments":{"count":"2","privacy":"","data":[{"id":"","comment":"this is a test comment","dateAdded":"June 30, 2014","user":{"id":"","firstName":"John","lastName":"Doe","photoSrc":"http://sthuf.com/images/placeholder-small.jpg"}},{"id":"","comment":"testing tesitng testing testing","dateAdded":"June 20, 2014","user":{"id":"","firstName":"John","lastName":"Test","photoSrc":"http://sthuf.com/images/placeholder-small.jpg"}}]}}],"usersCategories":[{"userCategoriesId":"1111111","categoryName":"Electronics","dateAdded":""},{"userCategoriesId":"2222222","categoryName":"Exercise","dateAdded":""},{"userCategoriesId":"3333333","categoryName":"Jeans","dateAdded":""}]},"categories":[{"id":"1111111","name":"Electronics","dateAdded":""},{"id":"2222222","name":"Exercise","dateAdded":""},{"id":"3333333","name":"Jeans","dateAdded":""}]}
	
	//register
	mockData.register = {"userId": "5000", "username":"curtiszjohn","email":"jj@e.com","privacy": "private"}

	//addItem
	mockData.addItem = {"id": "AKDSF8ASK33MK3A6", "dateAdded":"","privacy":"", "photos":{"count":2,"privacy":"","data":[{"id":"","src":"http://sthuf.com/images/ipad.jpg"}]}};
	
	//updateItem
	mockData.updateItem = {};
	
	//deleteItem
	mockData.deleteItem = {};
	
	//addCategory
	mockData.addCategory = { "associatedCategoryId": "250", "categoryName": "Sneakers", "dateAdded": null, "formula": null, "position": "0", "userCategoriesId": "100", "userCategoriesList": null, "userId": "5000"};
	
	mockData.deleteCategory = { "status": "success", "message": "Category successfully deleted!"};
	
	//Add Note
	mockData.addNote = {"id":"ASDFDSFDSAFADSDASFAS", "dateAdded":"September 4, 2014"};
	
	//Add Media
	mockData.addMedia = {"photos":{"privacy":"private","data":[{"id":"","src":"http://sthuf.com/images/ipad.jpg","dateAdded":""}]}};
	
	return mockData;
	
});