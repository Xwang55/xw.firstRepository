package com.xw.controller;

import com.xw.bean.User;
import com.xw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    //注入service层
    @Autowired
    UserService userService;
    //映射url
    @RequestMapping("\"queryUser/{idz}\"")
    //指定返回的为json数据
    @ResponseBody
    public String queryUser(@PathVariable("idz") int id){
        User user = userService.queryUserById(id);
        return user.toString();
    }
}
