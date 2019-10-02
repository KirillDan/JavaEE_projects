package MDB;

import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@TransactionAttribute(TransactionAttributeType.NEVER)
@Stateless
public class BigManagerConsumer{
	@Inject
	private JMSContext jmsContext;
	@Resource(lookup = "java:jboss/exported/jms/queue/BigManagerMDB")
	private Queue queue;
	//private JMSConsumer jmsConsumer = jmsContext.createConsumer(queue);
	public Long getBigOrder() throws NamingException, JMSException {
			String stringOrderId = jmsContext.createConsumer(queue).receiveBody(String.class);
			System.out.println(" -----------------------       BigManagerConsumer         ------------------------- " + stringOrderId);
			return Long.parseLong(stringOrderId);
	}

}
