package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.ManagerEntity;

@Stateless
public class ManagerEJB {
	@PersistenceContext
	EntityManager em;
	
	public ManagerEntity getManagerEntityById(Long id) {
		return em.find(ManagerEntity.class, id);
	}
}
