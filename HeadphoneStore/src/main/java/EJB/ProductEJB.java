package EJB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ProductEntitys.ProductEntity;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ProductEJB {
	@EJB 
	PagesEJB pagesEJB;
	
	public List<ProductEntity> allCartProductEntity(List<Long> productEntityIds){
		List<ProductEntity> lpe = new ArrayList();
		int size = productEntityIds.size();
		for(int i=0; i<size ; i++) {
			lpe.add(pagesEJB.getProductEntityById(productEntityIds.get(i)));
		}
		System.out.println("product   size    " + lpe.size());
		Collections.sort(lpe, new Comparator<ProductEntity>() {
			public int compare(ProductEntity p1,ProductEntity p2) {
				return p1.getProductEntityId().compareTo(p2.getProductEntityId());
			}
		});
		return lpe;
	}
	public int quantitySameProductEntity(Long productEntityId, List<Long> productEntityIds) {
		int i = 0;
		for(Long element : productEntityIds) {
			if(productEntityId == element) {i=i+1;}
		}		
		return i;
	}
	public Double getTotalPrice(List<Long> productEntityIds) {
		int size = productEntityIds.size();
		Double totalPrice = 0.0;
		for(int i=0; i<size ; i++) {
			totalPrice = totalPrice + pagesEJB.getProductEntityById(productEntityIds.get(i)).getPrice();
		}
		return totalPrice;
	}
}
