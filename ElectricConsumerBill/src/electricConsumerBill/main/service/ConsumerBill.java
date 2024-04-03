package electricConsumerBill.main.service;

public interface ConsumerBill {
	
	public void generateBill();   // we must specify as public else it will take default

	public void displayBill();

	public void updateBill();  //@Overide

	public void deleteBill();

	public void createConsumer();

	public void displayConsumer();

	public void updateConsumer();

	public void paidBill();

	public void display();

    public void ClearData();


}
