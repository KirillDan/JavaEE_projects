package ProductEntitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductCharacteristicsEntity
 *
 */
@Entity
public class ProductCharacteristicsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public ProductCharacteristicsEntity() {
	}
	@Id @GeneratedValue
	private Long id;
	private String characteristicType;
	private String CharacteristicValue;
	@ManyToOne
	ProductEntity productEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCharacteristicType() {
		return characteristicType;
	}
	public void setCharacteristicType(String characteristicType) {
		this.characteristicType = characteristicType;
	}
	public String getCharacteristicValue() {
		return CharacteristicValue;
	}
	public void setCharacteristicValue(String characteristicValue) {
		CharacteristicValue = characteristicValue;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
   
}
