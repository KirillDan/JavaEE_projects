package EJB;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entitys.AddressEntity;
import Entitys.CustomerEntity;
import Entitys.OrderEntity;
import Entitys.OrderProductEntity;
import Logic.ArrayListBuilder;
import ProductEntitys.ProductEntity;

@Stateless
public class Test {
	@PersistenceContext
	private EntityManager em;
	
	public CustomerEntity createCustomer(CustomerEntity ce) {
		em.persist(ce);
		return ce;
	}
	
	public List<CustomerEntity> allCustomerEntity() {
		TypedQuery<CustomerEntity> query = em.createQuery("SELECT c FROM CustomerEntity c",CustomerEntity.class);
		List<CustomerEntity> lce = query.getResultList();
		return lce;
	}
	
	public CustomerEntity getCustomerEntity(String email, String password) {
		TypedQuery<CustomerEntity> tce = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.email = :email  AND c.password = :password", CustomerEntity.class);
		tce.setParameter("email", email);
		tce.setParameter("password", password);
		CustomerEntity lce = null;
		try {
			lce = tce.getSingleResult();
			System.out.println("lce result       " + lce);
		}catch(NoResultException e){
			lce = null;
			System.out.println("lce  ========= null " + e);
		}catch(NonUniqueResultException e2) {
			lce = null;
			System.out.println(e2);
		}
		return lce;		
	}
	public CustomerEntity getCustomerEntity(String email) {
		TypedQuery<CustomerEntity> tce = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.email = :email", CustomerEntity.class);
		tce.setParameter("email", email);
		CustomerEntity lce = null;
		try {
			lce = tce.getSingleResult();
			System.out.println("lce result       " + lce);
		}catch(NoResultException e){
			lce = null;
			System.out.println("lce  ========= null " + e);
		}catch(NonUniqueResultException e2) {
			lce = null;
			System.out.println(e2);
		}
		return lce;		
	}
	public CustomerEntity getCustomerEntity(Long customerId) {
		TypedQuery<CustomerEntity> tce = em.createQuery("SELECT c FROM CustomerEntity c WHERE c.customerId = :customerId", CustomerEntity.class);
		tce.setParameter("customerId", customerId);
		CustomerEntity lce = null;
		try {
			lce = tce.getSingleResult();
			System.out.println("lce result       " + lce);
		}catch(NoResultException e){
			lce = null;
			System.out.println("lce  ========= null " + e);
		}catch(NonUniqueResultException e2) {
			lce = null;
			System.out.println(e2);
		}
		return lce;		
	}
//////////////////////////////////////////////////////////////OrderEntity
	public Long createOrder(OrderEntity orderEntity) {
		orderEntity.setOrderId(new Random().nextLong());
		Long Id = null;
		Boolean paramBool = true;
		while(paramBool) {
			Id = new Random().nextLong();
			//if(this.findBankPaymentEntityById(Id) == null) {
			if(em.find(OrderEntity.class, Id) == null) {
				paramBool = false;
			}
		}
		orderEntity.setOrderId(Id);
		em.persist(orderEntity);
		return Id;
	}
	public void mergeOrder(OrderEntity orderEntity) {
		em.merge(orderEntity);
	}
	public OrderEntity getOrderEntityById(Long orderId) {
		OrderEntity orderEntity = em.find(OrderEntity.class, orderId);
		return orderEntity;
	}
	//Administrator
	public List<OrderEntity> allOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allNonPayOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.paid <> true", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allPayOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.paid = true AND o.processing <> true AND o.transferedManager <> true AND o.closed <> true", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allProcessingOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.paid = true AND o.processing = true AND o.transferedManager <> true AND o.closed <> true", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allTransferedManagerOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.paid = true AND o.processing = true AND o.transferedManager = true AND o.closed <> true", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allClosedOrderEntitys(){
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.paid = true AND o.processing = true AND o.transferedManager = true AND o.closed = true", OrderEntity.class);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	/**********************************************
///////////////////Customer
	******************************************/
	public List<OrderEntity> allOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allNonPayOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId AND o.paid <> true", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allPayOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId AND o.paid = true AND o.processing <> true AND o.transferedManager <> true AND o.closed <> true", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allProcessingOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId AND o.paid = true AND o.processing = true AND o.transferedManager <> true AND o.closed <> true", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allTransferedManagerOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId AND o.paid = true AND o.processing = true AND o.transferedManager = true AND o.closed <> true", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
	public List<OrderEntity> allFinishedOrderEntitysByCustomer(Long customerId) {
		TypedQuery<OrderEntity> toe = em.createQuery("SELECT o FROM OrderEntity o WHERE o.customerEntity.customerId = :customerId AND o.paid = true AND o.processing = true AND o.transferedManager = true AND o.closed = true", OrderEntity.class);
		toe.setParameter("customerId", customerId);
		List<OrderEntity> loe = toe.getResultList();
		return loe;
	}
///////////////////////////////////////////////////////////OrderProductEntity
	public void createOrderProduct(OrderProductEntity orderProductEntity) {
		em.persist(orderProductEntity);
	}
//////////////////////////////////////////////////////////Address
	public void createAddress(AddressEntity addressEntity) {
		em.persist(addressEntity);
	}
//////////////////////////////////////Summ
	public void createComplex(CustomerEntity customerEntity, OrderEntity orderEntity, OrderProductEntity orderProductEntity, AddressEntity addressEntity) {
		orderEntity.addOrderProductEntity(orderProductEntity);
		orderEntity.setAddressEntity(addressEntity);
		orderEntity.setCustomerEntity(customerEntity);
		customerEntity.addOrderEntity(orderEntity);
		this.createOrder(orderEntity);
		this.createOrderProduct(orderProductEntity);
		this.createAddress(addressEntity);
		this.createCustomer(customerEntity);
	}
	public void createComplex(CustomerEntity customerEntity, OrderEntity orderEntity, List<OrderProductEntity> listOrderProductEntity, AddressEntity addressEntity) {
		orderEntity.setListOrderProductEntity(listOrderProductEntity);
		orderEntity.setAddressEntity(addressEntity);
		orderEntity.setCustomerEntity(customerEntity);
		customerEntity.addOrderEntity(orderEntity);
		this.createOrder(orderEntity);
		for(OrderProductEntity orderProductEntity : listOrderProductEntity) {
			this.createOrderProduct(orderProductEntity);
		}
		this.createAddress(addressEntity);
		this.createCustomer(customerEntity);
	}
	public void createComplexTest(CustomerEntity customerEntity, List<OrderEntity> listOrderEntity) {
		for(OrderEntity orderEntity : listOrderEntity){
			List<OrderProductEntity> listOrderProductEntity = new ArrayListBuilder().adds(new OrderProductEntity(new Random().nextDouble(), (Integer) new Random().nextInt())).adds(new OrderProductEntity(new Random().nextDouble(), (Integer) new Random().nextInt())).buildArrayList();
			AddressEntity addressEntity = new AddressEntity("Moskow","Sadovaya",new Random().nextInt(3),new Random().nextInt(4),String.valueOf(new Random().nextInt(1)),String.valueOf(new Random().nextInt(2)),"MyComment");
			orderEntity.setListOrderProductEntity(listOrderProductEntity);
			orderEntity.setAddressEntity(addressEntity);
			orderEntity.setCustomerEntity(customerEntity);
			customerEntity.addOrderEntity(orderEntity);
			this.createOrder(orderEntity);
			for(OrderProductEntity orderProductEntity : listOrderProductEntity) {
				this.createOrderProduct(orderProductEntity);
			}
		
			this.createAddress(addressEntity);
			listOrderProductEntity = null;
			addressEntity = null;
		}
		this.createCustomer(customerEntity);
	}
}
