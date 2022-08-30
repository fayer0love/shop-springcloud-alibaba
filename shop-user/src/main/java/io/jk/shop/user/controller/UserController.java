package io.jk.shop.user.controller;

import com.alibaba.fastjson.JSONObject;
import io.jk.shop.bean.User;
import io.jk.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description User Controller
 *  用户微服务的接口层主要对外提供用户微服务的接口
 *  在UserController上标注了@RestController注解，
 *  表明UserController能够提供Restful风格的接口，同
 *  时在UserController类中使用@Autowired注解注入了UserService对象，
 *  在getUser()方法中调用 UserService对象的getUserById()方法获取用户的信息，
 *  并返回用户的信息，同时在getUserById()方法
 *  上标注了@GetMapping注解表示这个接口采用HTTP GET方式访问，并定义了这个接口的访问路径。
 *  用户调用订单微服务的提交订单接口下单时，订单微服务会调用用户微服务的接口获取用户的基本信
 *  息。
 */

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{uid}")
    public User getUser(@PathVariable("uid") Long uid) {
        User user = userService.getUserById(uid);
        log.info("Got User information: {}", JSONObject.toJSONString(user));
        return user;
    }
}
