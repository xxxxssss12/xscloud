package xs.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by hasee on 2017/1/23.
 */
@FeignClient(value = "first-service", fallback = FeignClientHystrix.class)
public interface FeignApi {
    @RequestMapping(value = "/first/test")
    Map add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
