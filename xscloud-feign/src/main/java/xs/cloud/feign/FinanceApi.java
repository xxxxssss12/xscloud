package xs.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hasee on 2017/1/23.
 */
@FeignClient("finance-service")
@RequestMapping("/finance")
public interface FinanceApi {
    @RequestMapping(value = "/test")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
