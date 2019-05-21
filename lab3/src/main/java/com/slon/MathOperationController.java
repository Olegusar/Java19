package com.slon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletRequest;
import java.util.Objects;

@Controller
public class MathOperationController {

    @PostMapping("/math-operation")
    public String post(@ModelAttribute InputDto inputDto, ServletRequest request){
        if (Objects.nonNull(request.getParameter("addition"))) {
            return "/math-operation/addition";
        }
        if (Objects.nonNull(request.getParameter("subtraction"))) {
            return "/math-operation/subtraction";
        }
        if (Objects.nonNull(request.getParameter("division"))) {
            return "/math-operation/division";
        }
        if (Objects.nonNull(request.getParameter("multiplication"))) {
            return "/math-operation/multiplication";
        }
        throw new RuntimeException();
    }
}
