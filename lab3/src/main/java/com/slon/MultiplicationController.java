package com.slon;

import com.slon.math.MultiplicationOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MultiplicationController {

    private final MultiplicationOperation multiplicationOperation;

    public MultiplicationController(MultiplicationOperation multiplicationOperation) {
        this.multiplicationOperation = multiplicationOperation;
    }

    @PostMapping("/math-operation/multiplication")
    public String post(@ModelAttribute InputDto inputDto, ModelMap modelMap){
        final double result = multiplicationOperation.operate(inputDto.getLeftArg(), inputDto.getRightArg());
        modelMap.addAttribute("operationName", "multiplication");
        modelMap.addAttribute("result", result);
        return "/WEB-INF/view/operation-result.jsp";
    }
}
