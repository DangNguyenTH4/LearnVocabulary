package learnenglish;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import learnenglish.driver.Gui;
import learnenglish.factory.SaveWordFactory;
import learnenglish.repository.SaveWord;

@SpringBootApplication
public class LearnEnglishBySpringBootApplication {

	  public static ConfigurableApplicationContext context;
	  
	    public static void main(String[] args) throws InterruptedException {
	        //SpringApplication.run(Application.class, args);
	        SpringApplicationBuilder builder = new SpringApplicationBuilder(LearnEnglishBySpringBootApplication.class);
	        builder.headless(false);
	        context = builder.run(args);
	        
	        Gui gui = new Gui();
	        
	        SaveWord sw = SaveWordFactory.getInstance();
//	        while(true) {
//	        	Thread.sleep(5000);
////	        	MyTrayIcon.instance().displayMessage("Hello", "OK", MessageType.ERROR);
//	        	NotifyWord nw  = new NotifyWord();
//	        	nw.displayNotify();
//	        }
//	        
	        
	    }

}

