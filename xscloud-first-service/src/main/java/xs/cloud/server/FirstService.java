package xs.cloud.server;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasee on 2017/1/21.
 */
@RestController
@RequestMapping("/first")
public class FirstService {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/test")
    public Map<String, Object> test(Integer a, Integer b, HttpServletRequest req) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("message", "哈哈哈");
        map.put("data", r);
        logger.info("/test, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return map;
    }
}
