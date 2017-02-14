package xs.cloud.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xs on 2017/2/14.
 */
@Component
public class FeignClientHystrix implements FeignApi{

    @Override
    public Map add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "haha");
        return map;
    }
}
