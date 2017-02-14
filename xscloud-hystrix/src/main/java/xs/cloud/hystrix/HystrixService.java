package xs.cloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasee on 2017/2/13.
 */
@Service
public class HystrixService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Map addService() {
        return restTemplate.getForEntity("http://FIRST-SERVICE/add?a=10&b=20", Map.class).getBody();
    }
    public Map addServiceFallback() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "error");
        return map;
    }
}
