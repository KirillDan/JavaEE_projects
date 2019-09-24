package PagesEntitys;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import ProductEntitys.ProductEntity;

//import ProductEntitys.ProductEntity;

/**
 * Entity implementation class for Entity: ElementEntity
 *
 */
@Entity

public class ElementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ElementEntity() {
	}
	@Id @GeneratedValue
	private Long elementEntityId;
	private String number;
	@OneToOne
	private TxtEntity txtEntity;
	@OneToOne
	private ImgEntity imgEntity;
	@OneToOne
	ProductEntity productEntity;
	
	public Long get() {
		return elementEntityId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public TxtEntity getTxtEntity() {
		return txtEntity;
	}
	public void setTxtEntity(TxtEntity txtEntity) {
		this.txtEntity = txtEntity;
	}
	public ImgEntity getImgEntity() {
		return imgEntity;
	}
	public void setImgEntity(ImgEntity imgEntity) {
		this.imgEntity = imgEntity;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
   
}
