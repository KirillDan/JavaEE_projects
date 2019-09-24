package TestBank;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import TestBank.Files.ResultPaymentJson;



@Stateless
public class BankEJB {
	@PersistenceContext
	EntityManager em;
	public Long createBankPaymentEntity(Double price, String errorCode, Long orderId) {
		BankPaymentEntity bankPaymentEntity = new BankPaymentEntity(new Random().nextLong(), price, errorCode, orderId);
		Long Id = null;
		Boolean paramBool = true;
		while(paramBool) {
			Id = new Random().nextLong();
			//if(this.findBankPaymentEntityById(Id) == null) {
			if(em.find(BankPaymentEntity.class, Id) == null) {
				paramBool = false;
			}
		}
		bankPaymentEntity.setPaymentId(Id);
		em.persist(bankPaymentEntity);
		return Id;		
	}
	public BankPaymentEntity findBankPaymentEntityById(Long PaymentId) {
		BankPaymentEntity bankPaymentEntity = em.find(BankPaymentEntity.class, PaymentId);
		return bankPaymentEntity;
	}
	public List<BankPaymentEntity> findAllBankPaymentEntity(){
		TypedQuery query = em.createQuery("SELECT b FROM BankPaymentEntity b", BankPaymentEntity.class);
		List<BankPaymentEntity> lbpe = query.getResultList();
		return lbpe;
	}
	public ResultPaymentJson getObjectResultPaymentJsonById(Long PaymentId) {
		BankPaymentEntity bankPaymentEntity = em.find(BankPaymentEntity.class, PaymentId);
		ResultPaymentJson resultPaymentJson = new ResultPaymentJson();
		resultPaymentJson.errorCode = bankPaymentEntity.getErrorCode();
		resultPaymentJson.OrderNumber = bankPaymentEntity.getOrderId();
		if("0".equals(resultPaymentJson.errorCode)) {
			resultPaymentJson.errorMessage = "Success";
		}else {
			resultPaymentJson.errorMessage = "Error";
		}
		return resultPaymentJson;
	}
	public String getResultPaymentJsonById(Long PaymentId) {
		ResultPaymentJson resultPaymentJson = this.getObjectResultPaymentJsonById(PaymentId);
		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(resultPaymentJson);
		return json;
	}
}
