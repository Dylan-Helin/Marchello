package fr.marchello;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class MarchelloApplication {

	public static void main(String[] args) {
		try {
			Log log = new Log("log.txt");
			SpringApplication.run(MarchelloApplication.class, args);
			log.logger.info("Starting Marchello");
			log.close();
		}catch (Exception e){

		}

	}

	@PreDestroy
	public void preDestroy() {
		try {
			Log log = new Log("log.txt");
			log.logger.info("Shuting down Marchello");
			log.close();
		}catch (Exception e){

		}
	}

}
