package cn.dyan.controller;

import cn.dyan.modal.UserInfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
public class SessionController {

    @RequestMapping("/distsession")
    public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserInfoBean userInfoBean = Optional.ofNullable((UserInfoBean)request.getSession().getAttribute("userInfo")).orElse(null);
        if(userInfoBean !=null){
            request.getRequestDispatcher("/distsession/listMyInfo").forward(request,response);
        }
        request.getRequestDispatcher("/user.html").forward(request,response);
    }

    @RequestMapping("/distsession/listMyInfo")
    public void disSession(HttpServletRequest request,HttpServletResponse response) throws IOException {
        UserInfoBean userInfoBean = Optional.ofNullable((UserInfoBean)request.getSession().getAttribute("userInfo")).orElse(null);
        response.setContentType("text/html");
        PrintWriter  writer = response.getWriter();
        writer.write("<html><body>");
        writer.write("name : "+userInfoBean.getName() + " age: "+userInfoBean.getAge());
        writer.write("</body></html>");
        writer.close();
    }
}
