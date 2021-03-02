
public class generateMessageRs {
	
	public String helloRs(String id) {
		
	String HelloRs = 
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
			"<response>                            "+
			" <name>HelloRs</name>                 "+
			" <id>"+id+"</id>					   "+
			" <status> </status>                   "+
			" <message></message>                  "+
			"</response>                           ";	
	
		 return HelloRs;
	}

	public String testRs(String id) {
		
	String testRs = 
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
			"<response>                            "+
			" <name>TestRs</name>                 "+
			" <id>"+id+"</id>					   "+
			" <status> </status>                   "+
			" <message></message>                  "+
			"</response>                           ";	
	
		 return testRs;
	}
	
	public String mainRs(String id) {
		
	String mainRs = 
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
			"<response>                            "+
			" <name>MainRs</name>                 "+
			" <id>"+id+"</id>					   "+
			" <status> </status>                   "+
			" <message></message>                  "+
			"</response>                           ";	
	
		 return mainRs;
	}
}
