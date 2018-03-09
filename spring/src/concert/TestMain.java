package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class TestMain {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
        Dance d = context.getBean("dance",Dance.class); 
        d.perform();  
    }
}