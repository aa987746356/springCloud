package cn.mengpeng.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author meng
 * @create 2019/10/28
 */
@FeignClient(value = "EUREKA-CLIENT", fallback = FeignFallBack.class)
public interface FeignService {

    @GetMapping("/hi")
    String hi(@RequestParam(value = "name", defaultValue = "meng") String name);

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hellol", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name", defaultValue = "meng") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
