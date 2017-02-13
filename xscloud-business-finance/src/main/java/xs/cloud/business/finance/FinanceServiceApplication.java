package xs.cloud.business.finance;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hasee on 2017/1/21.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FinanceServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FinanceServiceApplication.class).web(true).run(args);
    }
}
