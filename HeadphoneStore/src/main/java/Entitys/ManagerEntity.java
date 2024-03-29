package Entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ManagerEntity
 *
 */
@Entity
public class ManagerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ManagerEntity() {
	}
	public ManagerEntity(String firstname,String secondname,String email,String password,String sity,String street,int house,int apartment,String phoneNumber) {
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.password = password;
		this.sity = sity;
		this.street = street;
		this.house = house;
		this.apartment = apartment;
		this.phoneNumber = phoneNumber;
	}
	@Id @GeneratedValue
	private Long managerId;
	private String firstname;
	private String secondname;
	private String email;
	private String password;
	private String sity;
	private String street;
	private int house;
	private int apartment;
	private String phoneNumber;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="order_entity_manager")
	List<OrderEntity> listOrderEntity;
	
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
	    this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
	    this.secondname = secondname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	    this.password = password;
	}
	public String getSity() {
		return sity;
	}
	public void setSity(String sity) {
	    this.sity = sity;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
	    this.street = street;
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
	    this.house = house;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}
	public int getApartment() {
		return apartment;
	}
	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public List<OrderEntity> getListOrderEntity() {
 	    return listOrderEntity;
 	}

	public void setListOrderEntity(List<OrderEntity> listOrderEntity) {
	    this.listOrderEntity = listOrderEntity;
	}
	public OrderEntity addOrderEntity(OrderEntity orderEntity) {
	      if (listOrderEntity == null) {
	        listOrderEntity = new ArrayList<OrderEntity>();
	      }
	      listOrderEntity.add(orderEntity);
	      orderEntity.setManagerEntity(this);
	      return orderEntity;
	}
   
}
