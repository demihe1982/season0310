package cn.dyan.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SessionController {

    @RequestMapping("/getSession")
    public void getSession(HttpServletRequest request){
        request.getSession().setAttribute("apptime",new Date());
    }
}
