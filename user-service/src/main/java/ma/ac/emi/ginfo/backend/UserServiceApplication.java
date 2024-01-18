package ma.ac.emi.ginfo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserServiceApplication {

    public static void main(String[] args) throws InterruptedException{


        
        Thread.sleep(10000);

        SpringApplication.run(UserServiceApplication.class, args);
    }


}
 