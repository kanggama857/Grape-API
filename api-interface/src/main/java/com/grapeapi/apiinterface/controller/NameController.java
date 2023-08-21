package com.grapeapi.apiinterface.controller;

import com.grapeapi.apiclientsdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author grape
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @PostMapping("/user")
    public String getName(@RequestBody User user){
        return "你的名字是"+user.getUsername();
    }
//    @GetMapping("/get")
//    public String getNameByGet(String name, HttpServletRequest request) {
//        System.out.println(request.getHeader("openapi"));
//        return "GET 你的名字是" + name;
//    }
//
//    @PostMapping("/post")
//    public String getNameByPost(@RequestParam String name) {
//        return "POST 你的名字是" + name;
//    }
//
//    @PostMapping("/user")
//    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
//        String result = "POST 用户名字是" + user.getUsername();
//        return result;
//    }
}
