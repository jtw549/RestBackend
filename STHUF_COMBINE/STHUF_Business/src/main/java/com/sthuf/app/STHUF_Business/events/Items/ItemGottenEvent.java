package com.sthuf.app.STHUF_Business.events.Items;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Business.events.ReadEvent;
import com.sthuf.app.STHUF_Domain.domain.Inventories;

public class ItemGottenEvent extends ReadEvent{
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
	
	private final ItemsDetails itemsDetails;
	
	public ItemsDetails getItemsDetails() {
		return itemsDetails;
	}

	public ItemGottenEvent(Inventories inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}
	
	public ItemGottenEvent(ArrayList<Inventories> inventories) {
		ItemsDetails itemsDetails = new ItemsDetails();
		itemsDetails.toItemsDetails(inventories,itemsDetails);
		this.itemsDetails = itemsDetails;
	}
}
