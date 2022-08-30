package top.ysqorz.springcloud.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import top.ysqorz.springcloud.entities.CommonResult;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author passerbyYSQ
 * @create 2022-08-28 20:02
 */
public class BaseController {
    @Resource
    protected RestTemplate restTemplate;

    private <T> ParameterizedTypeReference<CommonResult<T>> getReference(Class<T> clazz) {
        ParameterizedTypeImpl type = ParameterizedTypeImpl.make(CommonResult.class, new Type[]{clazz}
                , CommonResult.class.getDeclaringClass());
        return ParameterizedTypeReference.forType(type);
    }

    public <T> CommonResult<T> post(String url, Object param, Class<T> clazz) {
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(param), getReference(clazz)).getBody();
    }

    public <T> CommonResult<T> post(String url, Class<T> clazz) {
        return post(url, new HashMap<>(), clazz);
    }

    public <T> CommonResult<T> get(String url, Object param, Class<T> clazz) {
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(param), getReference(clazz)).getBody();
    }

    public <T> CommonResult<T> get(String url, Class<T> clazz) {
        return get(url, new HashMap<>(), clazz);
    }
}
