package EJB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;

import ProductEntitys.ProductEntity;


@Stateful
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CartSessionEJB {
	private List<Long> productEntityIds = new ArrayList();
	@EJB
	PagesEJB pagesEJB;
	@EJB
	ProductEJB productEJB;

	public List<Long> getProductEntityIds() {
		return productEntityIds;
	}
	public void setProductEntityIds(List<Long> productEntityIds) {
		this.productEntityIds = productEntityIds;
	}
	public Long addProductEntityId(Long productEntityId) {
		this.productEntityIds.add(productEntityId);
		return productEntityId;
	}
	public void removeProductEntityId(Long productEntityId) {
		this.productEntityIds.remove(productEntityId);
	}
	public int sizeproductEntityIds() {
		return this.productEntityIds.size();
	}
	public void removeproductEntityId(int index) {
		this.productEntityIds.remove(index);
	}
	
	public List<ProductEntity> allCartProductEntity(){
		return productEJB.allCartProductEntity(this.productEntityIds);
	}
	public int quantitySameProductEntity(Long productEntityId) {	
		return productEJB.quantitySameProductEntity(productEntityId, this.productEntityIds);
	}
	public Double getTotalPrice() {
		return productEJB.getTotalPrice(this.productEntityIds);
	}
	public String getTotalPriceJson() {
		String totalPriceJson = "{\"cost\":\"" + this.getTotalPrice() + "\"}";
		return totalPriceJson;
	}
}
