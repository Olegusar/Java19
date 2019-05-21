package com.slon;

import com.slon.math.SubstrationOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubtractionController {

    private final SubstrationOperation substrationOperation;

    public SubtractionController(SubstrationOperation substrationOperation) {
        this.substrationOperation = substrationOperation;
    }
    
    @PostMapping("/math-operation/subtraction")
    public String post(@ModelAttribute InputDto inputDto, ModelMap modelMap){
        final double result = substrationOperation.operate(inputDto.getLeftArg(), inputDto.getRightArg());
        modelMap.addAttribute("operationName", "subtraction");
        modelMap.addAttribute("result", result);
        return "/WEB-INF/view/operation-result.jsp";
    }
}
