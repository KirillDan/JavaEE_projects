package MDB;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;


@JMSDestinationDefinitions(value = {
	@JMSDestinationDefinition(
		name = "java:jboss/exported/jms/queue/MiddleManagerMDB",
		interfaceName = "javax.jms.Queue",
		destinationName = "MiddleManagerMDBDestination"
	)
})
@TransactionAttribute(TransactionAttributeType.NEVER)
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/ManagerMDB"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "price < 100000.0")
})
public class MiddleManagerMDB implements MessageListener {
	@Inject
	JMSContext jmsContext;
	@Resource(lookup = "java:jboss/exported/jms/queue/MiddleManagerMDB")
	Queue queue;
	
	TextMessage txt = null;
	
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		txt = (TextMessage) message;
		try {
			String stringOrderId = txt.getText();
			System.out.println("   Hello   form   *************       MiddleManagerMDB          +++++++++++++++++      " + stringOrderId );
			jmsContext.createProducer().send(queue, stringOrderId);
		}catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
