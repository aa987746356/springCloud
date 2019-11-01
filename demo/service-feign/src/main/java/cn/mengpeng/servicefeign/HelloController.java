package cn.mengpeng.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author meng
 * @create 2019/10/28
 */
@RestController
public class HelloController {

    @Autowired
    FeignService feignService;

    @GetMapping("/hi")
    public String hi(String name) {
        return feignService.hi(name);
    }

}
