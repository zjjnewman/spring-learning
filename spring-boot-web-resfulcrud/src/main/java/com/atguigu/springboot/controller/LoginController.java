package com.atguigu.springboot.controller;

import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    /**
     * // 这是非restful风格的注解
     * // @RequestMapping(value = "/user/login", method = RequestMethod.POST)
     * // 下面是restAPI形式的注解
     * 所有以 4** 开头的错误码 都是客户端的错误 如 错误码 400
     */
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> errorMsg,
                        HttpSession session){// 这个参数用于添加错误消息
        if(StringUtils.isEmpty(username) && "123".equals(password)){

            // 方便拦截器进行登录检查
            session.setAttribute("loginUser", username);
            // 登录成功为防止表单重复提交（浏览器刷新，会有这个bug，使用重定向功能解决）重定向到主页
            return "redirect:main.html";
        }
        errorMsg.put("msg", "密码错误");
        return "login";
    }
}
