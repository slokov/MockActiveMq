
import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.xml.sax.SAXException;

public class mqReceiver extends Thread {



		public void receiver()  throws JMSException, ParserConfigurationException, SAXException, IOException  
		{
			
			String url = ActiveMQConnection.DEFAULT_BROKER_URL;
			String queueName = "Request";
			String mqMessageReceiver = "";
			
			System.out.println("url connect = " + url);

			stringCreate mqString = new stringCreate();
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue(queueName);
			MessageConsumer consumer = session.createConsumer(destination);
			
			while(true) {

			Message message = consumer.receive();
			
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Received message '" + textMessage.getText() + "'");
				mqMessageReceiver = (String) textMessage.getText();
				
				mqString.stringEdit(mqMessageReceiver);
			}
			//connection.close();
			}
		}
		
		public void run()	
		{
			try {
				this.receiver();
				System.out.println("Thread run");
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
