package EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import PagesEntitys.BlockEntity;
import PagesEntitys.ElementEntity;
import PagesEntitys.ImgEntity;
import PagesEntitys.PageEntity;
import PagesEntitys.PagesEntity;
import PagesEntitys.TxtEntity;
import ProductEntitys.ProductCharacteristicsEntity;
import ProductEntitys.ProductDescriptionEntity;
import ProductEntitys.ProductEntity;


@Stateless
public class PagesEJB {
	@PersistenceContext
	private EntityManager em;
	
	public List<ProductEntity> allProductEntitys() {
		TypedQuery<ProductEntity> querype = em.createQuery("SELECT p FROM ProductEntity p",ProductEntity.class);
		List<ProductEntity> lpe = querype.getResultList();
		return lpe;
	}
	
	public ProductEntity getProductEntityById(Long id) {
		ProductEntity productEntity = em.find(ProductEntity.class, id);
		return productEntity;
	}
}
