package com.sthuf.app.STHUF_Domain.repository;

/*import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sthuf.app.STHUF_Domain.config.SpringMongoConfig1;
import com.sthuf.app.STHUF_Domain.domain.Categories;*/


public class InsertDeletePreCategories {

	/*ApplicationContext ctx = 
            new AnnotationConfigApplicationContext(SpringMongoConfig1.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoOperation");
	
	Query categoryQuery;
	
	Categories categories;
	
	public static void main(String[] args) {
		InsertDeletePreCategories insertDeletePreCategories = new InsertDeletePreCategories();
		insertDeletePreCategories.something();	
		
	}

	public void something() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		ArrayList <String> subs= new ArrayList<String>();
		subs.add("Books");
		subs.add("Electronic books");
		subs.add("Children’s books");
		subs.add("Textbooks");
		subs.add("Magazines");
		
		categories.setCategoryId(0);
		categories.setCreatedDate(dateFormat.format(date).toString());
		categories.setName("Books and Audible");
		categories.setSubCategorys(subs);
		
		mongoOperation.insert(categories);
	}*/
}
