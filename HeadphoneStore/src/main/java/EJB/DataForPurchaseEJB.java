package EJB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import Entitys.AddressEntity;
import Entitys.CustomerEntity;
import Entitys.OrderEntity;
import Entitys.OrderProductEntity;
import ProductEntitys.ProductEntity;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DataForPurchaseEJB {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	Test testEJB;
	@EJB
	ProductEJB productEJB;
	@EJB
	OrderRecBDEJB orderRecBDEJB;
	
	private CustomerEntity customerEntity;
	private OrderEntity order;
	List<OrderProductEntity> listOrderProductEntity = new ArrayList();
	private AddressEntity address;
	
	public void recTransaction() {
		orderRecBDEJB.createFullOrder(customerEntity, order, listOrderProductEntity, address);
	}

	public void setCustomer(Long customerId) {
		this.customerEntity = testEJB.getCustomerEntity(customerId);
	}
	public void setListOrderProductEntity(List<Long> productEntityIds) {
		List<ProductEntity> productEntitys = productEJB.allCartProductEntity(productEntityIds);
		int k = 0;
		for(ProductEntity productEntity : productEntitys) {
			if(k == 0) {
				k = productEJB.quantitySameProductEntity(productEntity.getProductEntityId(), productEntityIds);
				this.listOrderProductEntity.add(new OrderProductEntity(productEntity.getPrice(), Integer.valueOf(productEJB.quantitySameProductEntity(productEntity.getProductEntityId(), productEntityIds)), productEntity));
			}
			if(k > 0) {k = k - 1;}
		}
	}
	public Long newOrder(List<Long> productEntityIds) {
		OrderEntity order = new OrderEntity(new Random().nextLong());
		Long Id = null;
		Boolean paramBool = true;
		while(paramBool) {
			Id = new Random().nextLong();
			//if(this.findBankPaymentEntityById(Id) == null) {
			if(entityManager.find(OrderEntity.class, Id) == null) {
				paramBool = false;
			}
		}
		order.setOrderId(Id);	
		order.setDate(new Date().toString());
		order.setPrice(productEJB.getTotalPrice(productEntityIds));
		order.setDiscount(0);
		order.setProcessing(false);
		order.setTransferedManager(false);
		order.setPaid(false);
		order.setClosed(false);
		this.order = order;
		return Id;
	}
	public boolean setAddress(HttpServletRequest request) {
		String sity = request.getParameter("sity");
		String street = request.getParameter("street");
		int house = Integer.parseInt(request.getParameter("house"));
		int apartment = Integer.parseInt(request.getParameter("apartment"));
		String phone = request.getParameter("phone");
		String zipIndex = request.getParameter("zipindex");
		String comment = request.getParameter("comment");
		if(sity != null && street != null && house > 0 && apartment > 0 && phone != null && zipIndex != null) {
			this.address = new AddressEntity(sity,street,house,apartment,phone,zipIndex,comment);
			return true;
		}else {
			return false;
		}
	}
}
