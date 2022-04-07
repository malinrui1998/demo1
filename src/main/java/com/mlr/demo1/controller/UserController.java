package com.mlr.demo1.controller;

import com.mlr.demo1.pojo.ResponseResult;
import com.mlr.demo1.pojo.User;
import com.mlr.demo1.resolver.CurrentUserId;
import com.mlr.demo1.service.UserService;
import com.mlr.demo1.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author mlr
 * @version 1.0
 * @date 2022/3/31 18:25
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping
    public ResponseResult getUserList(@CurrentUserId String userId) throws Exception {
//      请求头中获取token
//        String token = request.getHeader("token");
//        if (StringUtils.hasText(token)) {
//            //解析token获取用户id
//            Claims claims = JwtUtil.parseJWT(token);
//            String userId = claims.getSubject();
//            System.out.println(userId);
//        }
        System.out.println(userId);
        //调用service查询数据，进行返回
        List<User> userList = userService.getUserList();
        return new ResponseResult(200, userList);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        Map<String, Object> map;
        User loginUser = userService.Login(user);
        if (loginUser != null) {
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getUserId()), null);
            map.put("token", token);
        } else {
            return new ResponseResult(300, "用户名或密码错误", null);
        }
        return new ResponseResult(200, "登录成功", map);
    }
}
