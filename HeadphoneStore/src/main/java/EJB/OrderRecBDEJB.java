package EJB;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entitys.AddressEntity;
import Entitys.CustomerEntity;
import Entitys.OrderEntity;
import Entitys.OrderProductEntity;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class OrderRecBDEJB {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void createOrder(OrderEntity orderEntity) {
		entityManager.persist(orderEntity);
	}
	public void createOrderProduct(List<OrderProductEntity> listOrderProductEntity) {
		for(OrderProductEntity orderProductEntity : listOrderProductEntity) {
			entityManager.persist(orderProductEntity);
		}
	}
	public void createOrderAddress(AddressEntity addressEntity) {
		entityManager.persist(addressEntity);
	}
	public void createFullOrder(CustomerEntity customerEntity, OrderEntity orderEntity,List<OrderProductEntity> listOrderProductEntity,AddressEntity addressEntity) {
		orderEntity.setAddressEntity(addressEntity);
		orderEntity.setListOrderProductEntity(listOrderProductEntity);
		orderEntity.setCustomerEntity(customerEntity);
		orderEntity.setManagerEntity(null);
		customerEntity.addOrderEntity(orderEntity);
		this.createOrder(orderEntity);
		this.createOrderAddress(addressEntity);
		this.createOrderProduct(listOrderProductEntity);
	}
}
