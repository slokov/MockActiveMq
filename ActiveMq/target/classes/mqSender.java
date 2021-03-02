
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * This class is used to send a text message to the queue.
 */
public class mqSender
{

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String queueName = "Response";

	
	public void sender(String messageRs) throws JMSException
	{
		System.out.println("url = " + url);

		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();


		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queueName);

		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage(messageRs);

		producer.send(message);

		System.out.println("Message Sender class: '" + message.getText());
		connection.close();
	}
}
