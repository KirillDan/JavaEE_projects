package Entitys;

import java.io.Serializable;
import javax.persistence.*;

//import ProductEntitys.ProductEntity;

/**
 * Entity implementation class for Entity: ListOrderProduct
 *
 */
@Entity

public class OrderProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public OrderProductEntity() {
		super();
	}
	public OrderProductEntity(Double cost,Integer quantity) {
		this.cost = cost;
		this.quantity = quantity;
	}
	@Id @GeneratedValue
	private Long listOrderProductId;
	private Double cost;
	private Integer quantity;
//	@OneToOne
//	ProductEntity product;
	
	public Long getListOrderProductId() {
		return listOrderProductId;
	}
	public void setListOrderProductId(Long listOrderProductId) {
		this.listOrderProductId = listOrderProductId;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
	    this.cost = cost;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
	    this.quantity = quantity;
	}
//	public ProductEntity getProduct() {
//		return product;
//	}
//	public void setProduct(ProductEntity product) {
//		this.product = product;
//	}
   
}
