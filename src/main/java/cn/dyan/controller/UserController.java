package cn.dyan.controller;

import cn.dyan.modal.UserInfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createUserInfo(String name,Integer age, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoBean user = new UserInfoBean();
        user.setAge(age);
        user.setName(name);
        request.getSession().setAttribute("userInfo",user);
        return "redirect:/distsession/listMyInfo";
    }
}
