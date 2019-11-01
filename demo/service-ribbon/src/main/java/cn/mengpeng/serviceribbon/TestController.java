package cn.mengpeng.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meng
 * @create 2019/10/25
 */
@RestController
public class TestController {

    @Autowired
    private TestService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "meng") String name) {
        return helloService.hiService(name);
    }

}
