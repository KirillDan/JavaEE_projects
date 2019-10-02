package MDB;

import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@TransactionAttribute(TransactionAttributeType.NEVER)
@Stateless
public class MiddleManagerConsumer{
	@Inject
	private JMSContext jmsContext;
	@Resource(lookup = "java:jboss/exported/jms/queue/MiddleManagerMDB")
	private Queue queue;
	//private JMSConsumer jmsConsumer = jmsContext.createConsumer(queue);

	
	
	
	
	public Long getMiddleOrder() throws NamingException, JMSException {
			String stringOrderId = jmsContext.createConsumer(queue).receiveBody(String.class);
			System.out.println(" -----------------------       MiddleManagerConsumer         ------------------------- " + stringOrderId);
			return Long.parseLong(stringOrderId);
	}


}
