package xs.cloud.ribbon;

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
    RestTemplate restTemplate;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map add() {
        return restTemplate.getForEntity("http://FIRST-SERVICE/first/test?a=10&b=20", Map.class).getBody();
    }
}
