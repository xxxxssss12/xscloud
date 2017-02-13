package xs.cloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by hasee on 2017/1/21.
 */
@RestController
public class TestController {
    @Autowired
    HystrixService hystrixService;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map add() {
        return hystrixService.addService();
    }
}
