package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.AppAuth.AppAuthenticatedEvent;
import com.commerce.app.COMMERCE_Business.events.AppAuth.AuthenticateAppEvent;
import com.commerce.app.COMMERCE_Domain.domain.AppTable;

@Service
public class AppAuthenticationEventHandler implements AppAuthenticationService {

	//I don't know about this...It is easier to use am Auth framework.
	private MongoTemplate mongoTemplate;
	
	@Override
	public AppAuthenticatedEvent authenticateApp(AuthenticateAppEvent authenticateAppEvent) {
		boolean appAllowed = false;
		ArrayList<String> appValue = authenticateAppEvent.getAppValues();
		String formula = appValue.get(0);
		int position = Integer.parseInt(appValue.get(1));
		ArrayList<String> symbol = new ArrayList<String>();
		ArrayList<String> number = new ArrayList<String>();
		for(int i=0; i<formula.length()+1; i++) {
			if((i%2==0)&& i+2<formula.length()+1 ) {
			symbol.add(formula.substring(i,i+1));
			number.add(formula.substring(i+1,i+2));
			}
		}
		int finalNum =0;
		String comboString = "";
		boolean beginning = false;
		if(position > 0) {
			beginning =true;
		}
		for(int j=position;j<symbol.size();j++) {
			if("-".equals(symbol.get(j))) {
				comboString = symbol.get(j)+number.get(j);
				finalNum = finalNum + Integer.parseInt(comboString);
			}
			if("+".equals(symbol.get(j))) {
				finalNum = finalNum + Integer.parseInt(number.get(j));
			}
			if("*".equals(symbol.get(j))) {
				finalNum = finalNum * Integer.parseInt(number.get(j));
			}
			if("/".equals(symbol.get(j))) {
				finalNum = finalNum / Integer.parseInt(number.get(j));
			}
			
			if((j==symbol.size()-1)&& beginning) {
				j=-1;
			}
			
			if(j==position-1 && beginning) {
				break;
			}
		}
		Query searchAppQuery 
		= new Query(Criteria.where("appValue").is(finalNum));
		 
		AppTable appTable = mongoTemplate.findOne(searchAppQuery, AppTable.class);
		if(appTable != null) {
			appAllowed = true;
		}
		return new AppAuthenticatedEvent(appAllowed);
	}
}
