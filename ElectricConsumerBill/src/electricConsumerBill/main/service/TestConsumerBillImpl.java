package electricConsumerBill.main.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestConsumerBillImpl {
	
	private ConsumerBillImpl customerBill;
	
	@Before
	public void setUp() {
		customerBill = new ConsumerBillImpl();
	}


	@Test
    @DisplayName(" Test Update Bill")
	public void testUpdateBill() {
		customerBill.createConsumer();
		customerBill.generateBill();
		customerBill.updateBill();
		assertEquals("2023-05-29", customerBill.getBillDetails().getDueDate().toString());
		assertEquals(700.00, customerBill.getBillDetails().getBillAmount(), 0.0);
	}
	
	
	@Test
	@DisplayName(" Test Generate Bill")
	public void testGenerateBill() {
		customerBill.createConsumer(); // it will import required methods for operation
		customerBill.generateBill();
		assertNotNull(customerBill.getBillDetails()); 
		assertNotNull(customerBill.getConsumerDetails());
	}


	

	
	
//	@Test
//	public void testUpdateBill () {
//		customerBill.createConsumer();
//		customerBill.generateBill();
//		customerBill.setBillDetails(null);
//		customerBill.setConsumerDetails(null);
//
//		assertThrows(NullPointerException.class, ()->{
//			
//			customerBill.updateBill();
//		});
//		
//		assertNotNull(customerBill.getBillDetails());
//		assertEquals("2023-05-30", customerBill.getBillDetails().getDueDate().toString());
//		assertEquals(500.0, customerBill.getBillDetails().getBillAmount(), 0.0);
//	}
	
	
//	@Test(expected = NullPointerException.class)
//	public void  testUpdateBill() {
//		String test = null;
//		test.length();
//		
//	}
	
	
	@Test
    @DisplayName(" Test Display Customer")
	public void testdisplayCustomer() {
		assertDoesNotThrow(()->{           //Does not throw any kind of exception
			customerBill.displayBill();
		});
		
	}
	
	
	@Test (expected = NullPointerException.class)
    @DisplayName(" Test Clear Customer")
	public void testClearData() {
		customerBill.getBillDetails().getBillAmount();
        assertEquals(null, customerBill);
		customerBill.getConsumerDetails().getBillDate();
        assertEquals(null, customerBill);
	} 
	
	
	@Test
    @DisplayName(" Test Display Bill")
	public void testdisplayBill() {
		assertDoesNotThrow(()->{
			customerBill.displayBill();
		});
		
	}


    @Test  
    @DisplayName(" Test Delete Bill")
	public void testDeleteBill() {
		customerBill.createConsumer();
		customerBill.generateBill();
		customerBill.deleteBill();
		assertNull(customerBill.getBillDetails());
		
	}
	


	@Test
    @DisplayName(" Test Paid Bill")
	public void testPaidBill() {
		customerBill.createConsumer();
		customerBill.generateBill();
		customerBill.paidBill();
		assertNotNull(customerBill.getConsumerDetails().getLastPaymentDate());
//		if (customerBill.getConsumerDetails().getLastPaymentDate().isAfter(customerBill.getBillDetails().getDueDate())) {
//			assertTrue(customerBill.getBillDetails().getLateFee() > 0);
//		}
		
	
		
}
}
