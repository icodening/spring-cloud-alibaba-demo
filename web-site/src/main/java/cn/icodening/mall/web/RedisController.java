package cn.icodening.mall.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author icodening
 * @date 2021.03.28
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private Map<String, String> redisMap;

    @Autowired(required = false)
    public void setRedisMap(Map<String, String> redisMap) {
        this.redisMap = redisMap;
    }

    @GetMapping("/{key}")
    public Object get(@PathVariable String key) {
        return redisMap.get(key);
    }

    @PostMapping
    public Object post(String key, String value) {
        redisMap.put(key, value);
        return "success";
    }

    @DeleteMapping
    public String delete(String key) {
        redisMap.remove(key);
        return "success";
    }
}
