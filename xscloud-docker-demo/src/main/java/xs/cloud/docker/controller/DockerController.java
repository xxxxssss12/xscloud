package xs.cloud.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xs on 2019/6/2.
 */
@RestController
@RequestMapping("/docker")
public class DockerController {
    @RequestMapping("/index")
    public String index() {

        return "hello docker!123";
    }
}
