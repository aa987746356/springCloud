package cn.mengpeng.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @author meng
 * 降級處理，調用方法訪問失敗時，做處理
 * @create 2019/10/28
 */
@Component
public class FeignFallBack implements FeignService {

    @Override
    public String hi(String name) {
        return "error";
    }

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User();
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
