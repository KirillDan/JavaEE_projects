package ProductEntitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import PagesEntitys.BlockEntity;
import PagesEntitys.PageEntity;

/**
 * Entity implementation class for Entity: ProductEntity
 *
 */
@Entity
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ProductEntity() {
	}
	public ProductEntity(String firm,String name,Boolean pro,byte availability,byte rating,Double price) {
		this.firm = firm;
		this.name = name;
		this.pro = pro;
		this.availability = availability;
		this.rating = rating;
		this.price = price;
	}
	@Id @GeneratedValue
	private Long productEntityId;
	private String firm;
	private String name;
	private Boolean pro;
	private byte availability;
	private byte rating;
	private Double price;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable
	private Set<String> srcImgSet = new LinkedHashSet<>();
/*	@OneToOne
	ProductDescriptionEntity productDescriptionEntity;
	@OneToMany
	List<ProductCharacteristicsEntity> productCharacteristicsEntityList;
*/		
	public Long getProductEntityId() {
		return productEntityId;
	}
	public void setProductEntityId(Long productEntityId) {
		this.productEntityId = productEntityId;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getPro() {
		return pro;
	}
	public void setPro(Boolean pro) {
		this.pro = pro;
	}
	public byte getAvailability() {
		return availability;
	}
	public void setAvailability(byte availability) {
		this.availability = availability;
	}
	public byte getRating() {
		return rating;
	}
	public void setRating(byte rating) {
		this.rating = rating;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Set<String> getSrcImgSet() {
		return srcImgSet;
	}
	public void setSrcImgSet(Set<String> srcImgSet) {
		this.srcImgSet = srcImgSet;
	}
	public String addSrcImg(String srcImg) {
		srcImgSet.add(srcImg);
		return srcImg;
	}
	public String getSrcImg(int num) {
		//return this.blockEntitySet.stream().filter((n) -> (n.getNumber() == number));
		int i = 0;
		for(String sis : this.srcImgSet) {
			i=i+1;
			if(num == i) {return sis;}
		}
		return null;
	}
/*	public ProductDescriptionEntity getProductDescriptionEntity() {
		return productDescriptionEntity;
	}
	public void setProductDescriptionEntity(ProductDescriptionEntity productDescriptionEntity) {
		this.productDescriptionEntity = productDescriptionEntity;
	}
	public List<ProductCharacteristicsEntity> getProductCharacteristicsEntityList() {
		return productCharacteristicsEntityList;
	}
	public void setProductCharacteristicsEntityList(List<ProductCharacteristicsEntity> productCharacteristicsEntityList) {
		this.productCharacteristicsEntityList = productCharacteristicsEntityList;
	}
	public ProductCharacteristicsEntity addProductCharacteristicsEntity(ProductCharacteristicsEntity productCharacteristicsEntity) {
	      if (productCharacteristicsEntityList == null) {
	    	  productCharacteristicsEntityList = new ArrayList<ProductCharacteristicsEntity>();
	      }
	      productCharacteristicsEntityList.add(productCharacteristicsEntity);
	      return productCharacteristicsEntity;
	}
*/	
   
}
