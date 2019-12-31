package learnenglish;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LearnEnglishBySpringBootApplication {

	  public static ConfigurableApplicationContext context;
	  
	    public static void main(String[] args) throws InterruptedException {
	    	
	        SpringApplicationBuilder builder = new SpringApplicationBuilder(LearnEnglishBySpringBootApplication.class);
	        builder.headless(false);
	        context = builder.run(args);
	        
	        
	        Application.main(null);

	        
	    }

}

