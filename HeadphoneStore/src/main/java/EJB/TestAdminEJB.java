package EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entitys.ManagerEntity;
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
public class TestAdminEJB {

		@PersistenceContext
		private EntityManager em;
		
		public PagesEntity createPagesEntity(PagesEntity pages) {
			em.persist(pages);
			return pages;
		}
		public PageEntity createPageEntity(PageEntity page) {
			em.persist(page);
			return page;
		}
		public BlockEntity createBlockEntity(BlockEntity block) {
			em.persist(block);
			return block;
		}
		public ElementEntity createElementEntity(ElementEntity element) {
			em.persist(element);
			return element;
		}
		public TxtEntity createTxtEntity(TxtEntity text) {
			em.persist(text);
			return text;
		}
		public ImgEntity createImgEntity(ImgEntity img) {
			em.persist(img);
			return img;
		}
		
	/*	public CustomerEntity getCustomerEntity() {
			TypedQuery<CustomerEntity> tce = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.firstname = 'Вася'", CustomerEntity.class);
			List<CustomerEntity> lce = tce.getResultList();
			CustomerEntity cev = lce.get(0);
			return cev;
			
		}*/
		
		public ProductEntity createProductEntity(ProductEntity productEntity) {
			em.persist(productEntity);
			return productEntity;
		}
		public ProductCharacteristicsEntity createProductCharacteristicsEntity(ProductCharacteristicsEntity productCharacteristicsEntity) {
			em.persist(productCharacteristicsEntity);
			return productCharacteristicsEntity;
		}
		public ProductDescriptionEntity createProductDescriptionEntity(ProductDescriptionEntity productDescriptionEntity) {
			em.persist(productDescriptionEntity);
			return productDescriptionEntity;
		}
//////////////////////////////////////////////////
		public void createManager(String firstname,String secondname,String email,String password,String sity,String street,int house,int apartment,String phoneNumber) {
			ManagerEntity managerEntity = new ManagerEntity(firstname, secondname, email, password, sity, street, house, apartment, phoneNumber);
			em.persist(managerEntity);
		}
		public void removeManager(Long Id) {
			Query query = em.createQuery("DELETE FROM ManagerEntity m WHERE m.managerId = :Id");
			query.setParameter("Id", Id);
			query.executeUpdate();
		}
		public List<ManagerEntity> getAllManagers(){
			TypedQuery<ManagerEntity> tq = em.createQuery("SELECT m FROM ManagerEntity m", ManagerEntity.class);
			return tq.getResultList();
		}
	}