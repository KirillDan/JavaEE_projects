package EJB;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.JMSSessionMode;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import Entitys.OrderEntity;



@JMSDestinationDefinitions(
	    value = {
	    		@JMSDestinationDefinition(
	    				name = "java:/queue/ProcessedMDB",
	    				interfaceName = "javax.jms.Queue",
	    				destinationName = "TestMDBDestination"
	    				)
	    })
@JMSConnectionFactoryDefinition(
		name = "test/ConnectionFactoty",
		interfaceName = "javax.jms.ConnectionFactory"
		)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class ScheduleOrderEJB {
	@EJB
	RecOrderEJB recOrderEJB;
//	@Resource(lookup = "test/ConnectionFactoty")
//	private ConnectionFactory connectionFactory;
	@Resource(lookup = "java:/queue/ProcessedMDB")
	private Queue queue;
	
	int priority;
/*	Connection connection;
	Session session;
	TextMessage message;
	void tryConnect() {
		try {
			connection = connectionFactory.createConnection("admin", "admin");
			session = connection.createSession();
			message = session.createTextMessage("  Hello      ");
			session.createProducer(queue).send(message);
		}catch(JMSException p) {
		
		}
	}*/
	@Inject
//	@JMSConnectionFactory(value = "test/ConnectionFactoty")
	JMSContext jmsContext;
	final Destination destination = queue;
//	JMSProducer jmsProducer;/* = jmsContext.createProducer();*/
	
//  Real	@Schedule(hour = "10-19", minute = "*/1")
/*  Test  */@Schedule(hour = "*", minute = "*", second = "*/3")
	public void processedOrder() {
		OrderEntity orderEntity = recOrderEJB.getNotProcessingOrderEntity();
		if(orderEntity != null) {
			System.out.println("    Get New Order        -------------             ------      " + orderEntity.getOrderId());
			//recOrderEJB.changeOrderToProcessed(orderEntity);
			String message = String.valueOf(orderEntity.getOrderId());
			if(orderEntity.getPrice() > 100000.0) {priority = 9;}else {priority = 4;}
			jmsContext.createProducer().setPriority(priority).setProperty("price", orderEntity.getPrice()).send(queue, message);
			//tryConnect();
		}
	}
}
