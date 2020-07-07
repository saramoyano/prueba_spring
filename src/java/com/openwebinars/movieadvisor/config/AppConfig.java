package java.com.openwebinars.movieadvisor.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.openwebinars.movieadvisor") //escaneará todos los beans q se encuentren en esos paquetes o por debajo
@PropertySource("classpath:/movieadvisor.properties")
public class AppConfig {

	@Value("${file.path}")
	private String file;
	
	@Value("${file.csv.separator}")
	private String separator;
	
	@Value("${file.csv.list_separator}")
	private String listSeparator;

	public String getFile() {
		return file;
	}

	 
	public String getSeparator() {
		return separator;
	}

	 
	public String getListSeparator() {
		return listSeparator;
	}

}
