package com.commerce.app.COMMERCE_Business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CategoryServiceTest.class, CommentServiceTest.class, EcommerceServiceTest.class,
		InventoryServiceTest.class, MediaServiceTest.class, NoteServiceTest.class, UserServiceTest.class,
		WarrantyServiceTest.class })
public class AllTests {

}
