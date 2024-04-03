package electricConsumerBill.main.entity;

import java.time.LocalDate;

public class BillClass {
	
	private int billNumber;
	private int consumerId;
	private boolean active;
	private String billingPeriod;
	private LocalDate dueDate;
	private LocalDate lastPaymentDate;
	private double billAmount;
	private double lateFee;

	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBillingPeriod() {
		return billingPeriod;
	}

	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(LocalDate lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	@Override
	public String toString() {
		return "Bill [billNumber=" + billNumber + ", consumerId=" + consumerId + ", active=" + active
				+ ", billingPeriod=" + billingPeriod + ", dueDate=" + dueDate + ", lastPaymentDate=" + lastPaymentDate
				+ ", billAmount=" + billAmount + ", lateFee=" + lateFee + "]";
	}   

}
