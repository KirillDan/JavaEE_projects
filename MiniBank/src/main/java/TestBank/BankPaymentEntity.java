package TestBank;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankPaymentEntity {
	public BankPaymentEntity(){}
	public BankPaymentEntity(Long Id, Double cost, String errorCode, Long orderId){
		this.PaymentId = Id;
		this.cost = cost;
		this.errorCode = errorCode;
		this.OrderId = orderId;
	}

	 @Id //@GeneratedValue
	 private Long PaymentId;
	 private Long OrderId;
	 private Double cost;
	 private String errorCode;
	public Long getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(Long Id) {
		this.PaymentId = Id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
}
