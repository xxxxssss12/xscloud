package xs.cloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by hasee on 2017/1/23.
 */
@RestController
public class ConsumeController {
    @Autowired
    private FeignApi feignApi;
    @RequestMapping("/add")
    public Map add() {
        return feignApi.add(10, 20);
    }
}
