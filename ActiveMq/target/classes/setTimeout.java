import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class setTimeout {
	
	public void setTime(int time) throws InterruptedException {
			
		TimeUnit.SECONDS.sleep(time);
		System.out.println("Class timeout:" + LocalDateTime.now());		
	}

}
