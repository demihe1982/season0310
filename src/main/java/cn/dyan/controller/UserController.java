package cn.dyan.controller;

import cn.dyan.modal.UserInfoBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserInfo(@Valid UserInfoBean userInfoForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Object[] errmsg = bindingResult.getAllErrors().stream().map(o->o.getObjectName()+" "+o.getCode()+" "+o.getDefaultMessage()).toArray();
            return Arrays.toString(errmsg);
        }
        return "Success";
    }
}
