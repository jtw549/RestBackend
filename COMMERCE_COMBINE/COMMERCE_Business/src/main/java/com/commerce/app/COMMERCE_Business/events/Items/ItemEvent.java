package com.commerce.app.COMMERCE_Business.events.Items;

import java.util.ArrayList;

import com.commerce.app.COMMERCE_Domain.domain.Inventories;

public class ItemEvent{
/*	"item": {
    "userId": "3489EAGFOJG489UPGAJREP",
    "make": "",
    "name": "",
    "categories": [
        {
            "id": ""
        },
        ...
    ]
}*/
	/*	  "item": {
    "count": 2,
    "data":[
        {
            "id": "32FKLJRWLKJRLK3JLKFSDF",
            "make": "Apple",
            "inventoryName": "iPad Air",
            "seller": "Apple Store",
            "cost": "499.99",
            "purchaseDate": "",
            "quantity": "1",
            "dateAdded": "",
            "privacy": ""
            "categories": {
                "count": 2,
                "data":[
                    {
                        "id": "",
                        "name": "Electronics",
                        "dateAdded": ""
                    }
                ]
            },
            "photos": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id": "",
                        "src": "http://cdn.amazon.com/img.jpg"
                    }
                ]
            },
            "videos": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id": "",
                        "src": "http://cdn.amazon.com/video.mpg",
                        "type": "inventory_main"
                    }
                ]
            },
            "notes": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id": 2,
                        "title": "",
                        "description": ""
                    }
                ]
            },
            "receipts": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id": "",
                        "src": "http://cdn.amazon.com/img.jpg"
                    }
                ]
            },
            "warranty": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id":"",
                        "issuer": "",
                        "length": "",
                        "contactInfo": "",
                        "notes": ""
                    }
                ]
            },
            "comments": {
                "count": 2,
                "privacy": "",
                "data":[
                    {
                        "id":"",
                        "comment": "",
                        "timeAgo": "",
                        "user":{
                            "id":"",
                            "firstName": "",
                            "lastName": "",
                            "photoSrc": "http://cdn.amazon.com/img.jpg"
                        }
                    }
                ]
            },
            "share": {
                "permLink": ""
            },
            "ecommerce": {
                "selling": "",
                "amount": "",
                "description": "",
                "privacy": ""
            }
        },
        {
            ...
        }
    ]
}*/
	private ItemsDetails itemsDetails;

	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}
	
	public ItemEvent (ItemsDetails itemsDetails) {
		this.itemsDetails = itemsDetails;
	}
	
	public ItemEvent(Inventories inventories) {
	ItemsDetails itemsDetails = new ItemsDetails();
	itemsDetails.toItemsDetails(inventories,itemsDetails);
	this.itemsDetails = itemsDetails;
	}

	public ItemEvent(ArrayList<Inventories> inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}


}
