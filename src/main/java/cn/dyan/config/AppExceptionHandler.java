package cn.dyan.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleAll(Throwable t){
        if(t instanceof MaxUploadSizeExceededException){

        }
        return "";
    }
}
