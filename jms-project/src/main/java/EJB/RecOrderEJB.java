package EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entitys.OrderEntity;

@Stateless
public class RecOrderEJB {
	@PersistenceContext
	EntityManager em;
	
	public void createOrder(OrderEntity orderEntity) {
		em.persist(orderEntity);
	}
	public OrderEntity getOrderById(Long orderId) {
		return em.find(OrderEntity.class, orderId);
	}
	public OrderEntity getNotProcessingOrderEntity() {
		TypedQuery<OrderEntity> tq = em.createQuery("SELECT o FROM OrderEntity o WHERE o.processing = false", OrderEntity.class);
		List<OrderEntity> listOrder;
			try {
				listOrder = tq.getResultList();
			}catch(NoResultException e) {
				return null;
			}
			if(listOrder.size() > 0) {
				return listOrder.get(0);
			}else {
				return null;
			}
	}
	public void changeOrderToProcessed(OrderEntity orderEntity) {
		orderEntity.setProcessing(true);
		em.merge(orderEntity);
	}
	public void changeOrderToProcessed(Long OrderId) {
		OrderEntity orderEntity = em.find(OrderEntity.class, OrderId);
		orderEntity.setProcessing(true);
		em.merge(orderEntity);
	}
}
