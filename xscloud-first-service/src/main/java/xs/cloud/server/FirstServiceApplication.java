package xs.cloud.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hasee on 2017/1/21.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FirstServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstServiceApplication.class).web(true).run(args);
    }
}
