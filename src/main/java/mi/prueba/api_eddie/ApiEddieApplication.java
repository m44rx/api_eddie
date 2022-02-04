package mi.prueba.api_eddie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiEddieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEddieApplication.class, args);
	}

}
