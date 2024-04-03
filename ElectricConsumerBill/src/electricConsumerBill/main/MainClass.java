package electricConsumerBill.main;

import electricConsumerBill.main.service.ConsumerBill;
import electricConsumerBill.main.service.ConsumerBillImpl;

public class MainClass {

	public static void main(String[] args) {
		
		ConsumerBill variable = new ConsumerBillImpl();
		
		System.out.println("<----------------------- Consumer Creation Status -------------------------------->");
		variable.createConsumer();
		
		System.out.println("<----------------------- Bill Generation Status  -------------------------------->");
        variable.generateBill();
        variable.display();
        
        System.out.println("<----------------------- Upadation of  consumer Status -------------------------------->");
        variable.updateConsumer();
        
        System.out.println("<----------------------- Updation of Bill ------------------------------------->");
        variable.updateBill();
        variable.display();
        
        System.out.println("<----------------------- Paid Bill Status --------------------------------------->");
        variable.paidBill();
        variable.display();
        
        System.out.println("<----------------------- Deletion of  Bill ------------------------------------->");
        variable.deleteBill();
        variable.display();
        
        System.out.println("<----------------------- Clearing of  Bill -------------------------------------->");
        variable.ClearData();
        variable.display();

	

		
		
	}
}
