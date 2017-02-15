package xs.cloud.useconfig;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by xs on 2017/2/14.
 */
@SpringBootApplication
public class UseConfigApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UseConfigApplication.class).web(true).run(args);
    }
}
