package xs.cloud.server;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasee on 2017/1/21.
 */
@RestController
@RequestMapping("/second")
public class SecondService {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/multi")
    public Map<String, Object> test(String a, String b, HttpServletRequest req) {
        System.out.println(JSON.toJSONString(req.getParameter("a")));
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = new BigDecimal(a).multiply(new BigDecimal(b)).intValue() ;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("message", "哈哈哈");
        map.put("data", r);
        logger.info("/multi, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return map;
    }
}
