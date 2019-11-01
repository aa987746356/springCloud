package cn.mengpeng.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author meng
 * @create 2019/10/28
 */
@FeignClient(value = "EUREKA-CLIENT", fallback = FeignFallBack.class)
public interface FeignService {

    @GetMapping("/hi")
    String hi(@RequestParam(value = "name", defaultValue = "meng") String name);


}
