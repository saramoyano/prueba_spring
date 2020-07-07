package java.com.openwebinars.movieadvisor;

import java.com.openwebinars.movieadvisor.config.AppConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MovieAdvisorApp {

	public static void main(String[] args) {
		 
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MovieAdvisorRunApp runApp = appContext.getBean(MovieAdvisorRunApp.class);
		
		runApp.run(args);
		
		((AnnotationConfigApplicationContext)appContext).close();
	}

}
