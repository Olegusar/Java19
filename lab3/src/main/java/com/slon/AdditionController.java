package com.slon;

import com.slon.math.AdditionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdditionController {

    private final AdditionOperation additionOperation;

    @Autowired
    public AdditionController(AdditionOperation additionOperation) {
        this.additionOperation = additionOperation;
    }

    @PostMapping("/math-operation/addition")
    public String post(@ModelAttribute InputDto inputDto, ModelMap modelMap){
        final double result = additionOperation.operate(inputDto.getLeftArg(), inputDto.getRightArg());
        modelMap.addAttribute("operationName", "addition");
        modelMap.addAttribute("result", result);
        return "/WEB-INF/view/operation-result.jsp";
    }
}
