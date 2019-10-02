package MDB;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import EJB.RecOrderEJB;


@TransactionAttribute(TransactionAttributeType.REQUIRED)
@JMSDestinationDefinitions(value = {
		@JMSDestinationDefinition(
				name = "java:/queue/ManagerMDB",
				interfaceName = "javax.jms.Queue",
				destinationName = "ManagerMDBDestination")
})
@MessageDriven(name="OrderToManagerMDB", activationConfig= {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/ProcessedMDB"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
})
public class OrderToProcessedMDB implements MessageListener {
/*	@Resource
	ConnectionFactory connectionFactory;
*/	@Resource(lookup = "java:/queue/ManagerMDB")
	Queue queue;
	@Inject
	JMSContext jmsContext;
	
	
	@EJB
	RecOrderEJB recOrderEJB;
	
	TextMessage txt = null;
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		Long orderId = null;
		int priority;
		txt = (TextMessage) message;
		try {
			String stringOrderId = txt.getText();
			orderId = Long.parseLong(stringOrderId);
			recOrderEJB.changeOrderToProcessed(orderId);
			System.out.println("   Hello   form MDB          +++++++++++++++++      " + orderId );
			Double price = recOrderEJB.getOrderById(orderId).getPrice();
			if(price > 100000.0) {priority = 9;}else {priority = 4;}
			jmsContext.createProducer().setProperty("price", price).setPriority(priority).send(queue, String.valueOf(orderId));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
