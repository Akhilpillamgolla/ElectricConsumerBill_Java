package electricConsumerBill.main.entity;

import java.time.LocalDate;

public class ConsumerClass {

	private int consumerId;
    private String consumerName;
    private String billingAddress;
    private boolean isActive;
    private int previousMeterReading;
    private int currentMeterReading;
    private LocalDate lastPaymentDate;
    private double dueAmount;
    private LocalDate billDate;
    
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getPreviousMeterReading() {
		return previousMeterReading;
	}
	public void setPreviousMeterReading(int previousMeterReading) {
		this.previousMeterReading = previousMeterReading;
	}
	public int getCurrentMeterReading() {
		return currentMeterReading;
	}
	public void setCurrentMeterReading(int currentMeterReading) {
		this.currentMeterReading = currentMeterReading;
	}
	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(LocalDate lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public double getDueAmount() {
		return dueAmount;
	}
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consumerName=" + consumerName + ", billingAddress="
				+ billingAddress + ", isActive=" + isActive + ", previousMeterReading=" + previousMeterReading
				+ ", currentMeterReading=" + currentMeterReading + ", lastPaymentDate=" + lastPaymentDate
				+ ", dueAmount=" + dueAmount + ", billDate=" + billDate + "]";
	} 
	

}
