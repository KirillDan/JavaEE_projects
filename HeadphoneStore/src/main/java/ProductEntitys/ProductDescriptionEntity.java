package ProductEntitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductDescriptionEntity
 *
 */
@Entity

public class ProductDescriptionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ProductDescriptionEntity() {
	}
	@Id @GeneratedValue
	private Long id;
	private String description;
	@OneToOne
	 ProductEntity productEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(length=1024)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
   
}
