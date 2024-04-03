package electricConsumerBill.main.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import electricConsumerBill.main.entity.BillClass;
import electricConsumerBill.main.entity.ConsumerClass;

public class ConsumerBillImpl implements ConsumerBill {
	
	private BillClass billDetails;
	private ConsumerClass consumerDetails;
	
	@Override
	public void createConsumer() {
		consumerDetails = new ConsumerClass(); 
		consumerDetails.setConsumerId(1);
		consumerDetails.setConsumerName(" ");
		consumerDetails.setBillingAddress("Tarnaka , Hyderabad City");
		consumerDetails.setActive(true);
		consumerDetails.setPreviousMeterReading(100);
		consumerDetails.setCurrentMeterReading(200);
		consumerDetails.setLastPaymentDate(null);
		consumerDetails.setDueAmount(0.0);
		consumerDetails.setBillDate(LocalDate.now());

		System.out.println("Consumer had been created successfully");

	}
	
	@Override
	public void generateBill() {
		double billAmount = calculateBillAmount();
		double lateFee = calculateLateFee();
		LocalDate dueDate = calculateDueDate();

		billDetails = new BillClass();
		billDetails.setBillNumber(1);
		billDetails.setConsumerId(consumerDetails.getConsumerId());
		billDetails.setBillingPeriod("Jan");
		billDetails.setDueDate(dueDate);
		billDetails.setLastPaymentDate(null);
		billDetails.setBillAmount(billAmount);
		billDetails.setLateFee(lateFee);

		System.out.println("Bill generated successfully.");

	}
	
	private double calculateBillAmount() {

		int unitsConsumed = consumerDetails.getCurrentMeterReading() - consumerDetails.getPreviousMeterReading();
		double billAmount = 0.0; 

		if (unitsConsumed <= 100) {
			billAmount = unitsConsumed * 5.0;
		} else if (unitsConsumed > 100 && unitsConsumed <= 300) {
			billAmount = 100 * 5.0 + (unitsConsumed - 100) * 7.0;
		} else if (unitsConsumed > 300) {
			double excessUnits = unitsConsumed - 300;
			billAmount = 100 * 5.0 + 200 * 7.0 + excessUnits * 10.0;
		}

		return billAmount;
	}

	private double calculateLateFee() {
		LocalDate dueDate = calculateDueDate();
		LocalDate paymentDate = LocalDate.now();

		if (paymentDate.isAfter(dueDate)) {
			long daysLate = paymentDate.toEpochDay() - dueDate.toEpochDay();//conversion Base
			return daysLate * 2.0; // Late fee of 2 per day
		}

		return 0.0;
	}

	private LocalDate calculateDueDate() {
		LocalDate billDate = LocalDate.now();
		int daysInMonth = billDate.getMonth().length(billDate.isLeapYear());
		return billDate.plusDays(daysInMonth); // Due date is set to end of the month
	}

	@Override
	public void display() {
		System.out.println("Display Consumer Details");
		displayConsumer();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Display Bill Details");
		displayBill(); // calling display bill method

	}

	@Override
	public void displayConsumer() {
		if (consumerDetails != null) {
			System.out.println("Consumer ID: " + consumerDetails.getConsumerId());
			System.out.println("Consumer Name: " + consumerDetails.getConsumerName());
			System.out.println("Billing Address: " + consumerDetails.getBillingAddress());
			System.out.println("Active: " + consumerDetails.isActive());
			System.out.println("Previous Meter Reading: " + consumerDetails.getPreviousMeterReading());
			System.out.println("Current Meter Reading: " + consumerDetails.getCurrentMeterReading());
			System.out.println("Last Payment Date: " + formatDate(consumerDetails.getLastPaymentDate()));
			System.out.println("Due Amount: " + consumerDetails.getDueAmount());
			System.out.println("Bill Date: " + formatDate(consumerDetails.getBillDate()));

		} else {
			System.out.println("No consumer available.");
		}

	}

	@Override
	public void displayBill() {
		if (billDetails != null) {
			System.out.println("Bill Number: " + billDetails.getBillNumber());
			System.out.println("Consumer ID: " + billDetails.getConsumerId());
			System.out.println("Billing Period: " + billDetails.getBillingPeriod());
			System.out.println("Due Date: " + formatDate(billDetails.getDueDate()));
			System.out.println("Last Payment Date: " + formatDate(billDetails.getLastPaymentDate()));
			System.out.println("Bill Amount: Rs " + billDetails.getBillAmount());
			System.out.println("Late Fee: Rs " + billDetails.getLateFee());
		} else {
			System.out.println("No bill available.");
		}
	}

	@Override
	public void updateConsumer() {
		if (consumerDetails != null) {
			consumerDetails.setConsumerName("Roy Kuntal");

			System.out.println("Consumer had been updated successfully.");
		} else  {
			System.out.println("No consumer available to update.");
		}
	}

	@Override
	public void updateBill()  {
		if (billDetails != null) {
			billDetails.setDueDate(LocalDate.parse("2023-05-29")); // parse read string as date
			billDetails.setBillAmount(700.00); // Update bill amount
			System.out.println("Bill updated successfully.");
		} else {
			System.out.println("No bill available to update.");
		}

	}

	@Override
	public void paidBill() {
		if (billDetails != null && consumerDetails != null) { // both operation must be true
			consumerDetails.setPreviousMeterReading(consumerDetails.getPreviousMeterReading());
			consumerDetails.setCurrentMeterReading(consumerDetails.getCurrentMeterReading());
			consumerDetails.setLastPaymentDate(LocalDate.now());

			LocalDate dueDate = billDetails.getDueDate();
			LocalDate paymentDate = LocalDate.now();

			if (paymentDate.isAfter(dueDate)) { // check given date is after another date
				double lateFee = calculateLateFee();
				billDetails.setLateFee(lateFee);
			}
			System.out.println("Bill paid successfully.");
		} else {
			System.out.println("No bill or consumer available.");
		}

	}

	@Override
	public void deleteBill() {
		if (billDetails != null ) {
			billDetails = null; // Delete the bills
			System.out.println("Bill deleted successfully.");
		} else {
			System.out.println("No bill available to delete.");
		}

	}
	
	
	@Override
	public void ClearData() {   
		
		billDetails = null;
		consumerDetails = null;
		
	}

	
	
	private String formatDate(LocalDate date) {  //Local date as 0bject
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		return date != null ? date.format(formatter) : "N/A"; 
	}
		
	

	public BillClass getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(BillClass billDetails) {
		this.billDetails = billDetails;
	}

	public ConsumerClass getConsumerDetails() {
		return consumerDetails;
	}

	public void setConsumerDetails(ConsumerClass consumerDetails) {
		this.consumerDetails = consumerDetails;
	}

	
	
	

}
