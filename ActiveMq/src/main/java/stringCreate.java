import java.io.StringReader;
import java.time.LocalDateTime;

import javax.jms.JMSException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class stringCreate {
	

	public void stringEdit(String message) throws JMSException, InterruptedException  {
		
		System.out.println("Message in stringEdit class:\n" + message + "\n Date: " + LocalDateTime.now());
		
		String nameRequest = regexpXml(message, "request","name",0);
		
		setTimeout timeout = new setTimeout();
		
		System.out.println("Message nameRequest: " + nameRequest);
		
		  if(nameRequest.equals("TestRq")){
			
		String idMessage = regexpXml(message, "request","id",0);
		generateMessageRs testRs = new generateMessageRs();
		String responseRs = testRs.testRs(idMessage);
		timeout.setTime(4);
		mqSender sender = new mqSender();
		sender.sender(responseRs);
		
		} else if(nameRequest.equals("HelloRq")) {
		
			String idMessage = regexpXml(message, "request","id",0);
			generateMessageRs helloRs = new generateMessageRs();
			String responseRs = helloRs.testRs(idMessage);
			timeout.setTime(4);
			mqSender sender = new mqSender();
			sender.sender(responseRs);
		} else if(nameRequest.equals("MainRq")) {
			
		String idMessage = regexpXml(message, "request","id",0);
		generateMessageRs mainRs = new generateMessageRs();
		String responseRs = mainRs.testRs(idMessage);
		timeout.setTime(4);
		mqSender sender = new mqSender();
		sender.sender(responseRs);
		
		System.out.println("Message response:" + LocalDateTime.now());
		
		} else {
			System.out.println("Not resours for response: " + nameRequest);
		}
		
		
	
	}	
	

	public String regexpXml(String message, String rootTag, String tagName, int numGroup) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder;
		String regexTag = "";
		try { 
				
		    builder = factory.newDocumentBuilder();  
		    Document document = builder.parse(new InputSource(new StringReader(message)));
		    document.getDocumentElement().normalize(); 
		    
		    System.out.println( 
	                "Root element: "
	                + document.getDocumentElement().getNodeName());
		    
		    NodeList nodeList 
            = document.getElementsByTagName(rootTag); 
		    
		    for (int i = 0; i < nodeList.getLength(); ++i) { 
                Node node = nodeList.item(i); 
                System.out.println("\nNode Name :"
                                   + node.getNodeName()); 
                if (node.getNodeType() == Node.ELEMENT_NODE) { 
                	
                    Element tElement = (Element)node; 
                    
                    System.out.println( 
                        "Extract date: "
                        + tElement 
                              .getElementsByTagName(tagName) 
                              .item(numGroup) 
                              .getTextContent()); 
                    
                    regexTag = tElement.getElementsByTagName(tagName) 
                            .item(numGroup) 
                            .getTextContent(); 
                }
		    }
	            
		} catch (Exception e) {  
		    e.printStackTrace();  
		}
		
		
		return regexTag; 
	}

}
