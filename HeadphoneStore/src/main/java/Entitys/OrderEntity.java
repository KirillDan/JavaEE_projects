package Entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: OrderEntity
 *
 */
@Entity
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public OrderEntity() {
	}
	public OrderEntity(Long Id) {
		this.setOrderId(Id);
	}
	public OrderEntity(String date,Boolean paid,Boolean processing,Boolean transferedManager,Boolean closed,Double price,Integer discount) {
		this.date  = date;
		this.processing  = processing;
		this.transferedManager  = transferedManager;
		this.paid  = paid;
		this.closed  = closed;
		this.price  = price;
		this.discount  = discount;
		this.setPaymentId(null);
	}
	@Id 
	private Long orderId;
	private String date;
	private Boolean processing;
	private Boolean transferedManager;
	private Boolean paid;
	private Long PaymentId;
	private Boolean closed;
	private Double price;
	private Integer discount;
	@OneToMany 
	@JoinColumn(name="list_order_entity_id")
	List<OrderProductEntity> listOrderProductEntity;
	@ManyToOne
	@JoinColumn(name="order_to_manager_entity_id")
	ManagerEntity managerEntity;
	@ManyToOne
	@JoinColumn(name="order_to_customer_entity_id")
	CustomerEntity customerEntity;
	@OneToOne
	@JoinColumn(name="order_to_address_entity_id")
	AddressEntity addressEntity;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
	    this.date = date;
	}
	public Boolean getProcessing() {
		return processing;
	}
	public void setProcessing(Boolean processing) {
	    this.processing = processing;
	}
	public Boolean getTransferedManager() {
		return transferedManager;
	}
	public void setTransferedManager(Boolean transferedManager) {
	    this.transferedManager = transferedManager;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
	    this.paid = paid;
	}
	public Boolean getClosed() {
		return closed;
	}
	public void setClosed(Boolean closed) {
	    this.closed = closed;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
	    this.price = price;
	}
	public  Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
	    this.discount = discount;
	}
	public  ManagerEntity getManagerEntity() {
		return managerEntity;
	}
	public void setManagerEntity(ManagerEntity managerEntity) {
	    this.managerEntity = managerEntity;
	}
//	public List<OrderProductEntity> getListOrderProductEntity() {
//	    return listOrderProductEntity;
//	  }
//	public void addListOrderProductEntity(OrderProductEntity orderProductEntity) {
//	   this.listOrderProductEntity.add(orderProductEntity);
//	}
	public  CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
	    this.customerEntity = customerEntity;
	}
	///////////////
	//List<OrderProductEntity> listOrderProductEntity;
	public OrderProductEntity addOrderProductEntity(OrderProductEntity orderProductEntity) {
	      if (listOrderProductEntity == null) {
	    	  listOrderProductEntity = new ArrayList<OrderProductEntity>();
	      }
	      listOrderProductEntity.add(orderProductEntity);
	      return orderProductEntity;
	}
	public void setListOrderProductEntity(List<OrderProductEntity> listOrderProductEntity) {
		this.listOrderProductEntity = listOrderProductEntity;
	}
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public Long getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(Long paymentId) {
		PaymentId = paymentId;
	}
   
}
