package xs.cloud.config;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by xs on 2017/6/25.
 */
public class SimplePropertySourceLoader implements PropertySourceLoader {
    public String[] getFileExtensions() {
        return new String[]{"properties"};
    }

    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        Properties prop = FundamentalConfigProvider.getProp();
//        new PropertySource<Properties>(prop);
        return null;
    }
}
