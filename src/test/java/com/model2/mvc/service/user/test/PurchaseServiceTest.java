package com.model2.mvc.service.user.test;
// W D 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/commonservice.xml"})
public class PurchaseServiceTest {

	// Field
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	
	//@Test
	public void testAddPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		purchase.setPaymentOption("1");
		purchase.setPurchaseProd(productService.getProduct(10008));
		purchase.setBuyer(userService.getUser("user08"));
		purchase.setDlvyDate("240910");
		
		System.out.println("\n==============================");
		purchaseService.addPurchase(purchase);
		System.out.println("==============================\n");
	}
	
	
	@Test
	public void testGetPurchase() {
		
		System.out.println("\n==============================");
		Purchase purchase = purchaseService.getPurchase(10003);
		System.out.println(purchase);
		System.out.println("==============================\n");
	}
	
	
	
}
// class end