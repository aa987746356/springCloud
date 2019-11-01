package cn.mengpeng.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author meng
 * @create 2019/10/28
 */
@RestController
public class HelloController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("访问来1了......");
        return "hello1";
    }

    @RequestMapping("/consumer")
    public String helloConsumer() {
        return feignService.hello();
    }

    @GetMapping("/hi")
    public String hi(String name) {
        return feignService.hi(name);
    }


    @RequestMapping("/consumer2")
    public String helloConsumer2() {
        String r1 = feignService.hello("hjc");
        String r2 = feignService.hello("hjc", 23).toString();
        String r3 = feignService.hello(new User("hjc", 23));
        return r1 + "-----" + r2 + "----" + r3;
    }


    @RequestMapping(value = "/hellol", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", defaultValue = "meng") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
