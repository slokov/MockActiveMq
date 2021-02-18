import java.io.IOException;

import javax.jms.JMSException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws JMSException, ParserConfigurationException, SAXException, IOException {
		
		mqReceiver receiverOne = new mqReceiver();
		receiverOne.start();
		
		mqReceiver receiverTwo = new mqReceiver();
		receiverTwo.start();
		
		mqReceiver receiverThree = new mqReceiver();
		receiverThree.start();
		
		mqReceiver receiverFour = new mqReceiver();
		receiverFour.start();
	}
//test
}
