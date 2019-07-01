package EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entitys.CustomerEntity;

@Stateless
public class Test {
	@PersistenceContext
	private EntityManager em;
	
	public CustomerEntity createCustomer(CustomerEntity ce) {
		em.persist(ce);
		return ce;
	}
	
	public CustomerEntity getCustomerEntity() {
		TypedQuery<CustomerEntity> tce = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.firstname = 'Вася'", CustomerEntity.class);
		List<CustomerEntity> lce = tce.getResultList();
		CustomerEntity cev = lce.get(0);
		return cev;
		
	}

}
