package b101.percast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PercastApplication {

    public static void main(String[] args) {
        SpringApplication.run(PercastApplication.class, args);
    }

}
