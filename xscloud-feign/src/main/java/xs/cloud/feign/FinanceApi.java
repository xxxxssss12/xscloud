package xs.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by hasee on 2017/1/23.
 */
@FeignClient("first-service")
@RequestMapping("/first")
public interface FinanceApi {
    @RequestMapping(value = "/test")
    Map add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
