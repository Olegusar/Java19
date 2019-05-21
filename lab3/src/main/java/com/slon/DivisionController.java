package com.slon;

import com.slon.math.AdditionOperation;
import com.slon.math.DivisionOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DivisionController {

    private final DivisionOperation divisionOperation;

    @Autowired
    public DivisionController(DivisionOperation divisionOperation) {
        this.divisionOperation = divisionOperation;
    }

    @PostMapping("/math-operation/division")
    public String post(@ModelAttribute InputDto inputDto, ModelMap modelMap){
        final double result = divisionOperation.operate(inputDto.getLeftArg(), inputDto.getRightArg());
        modelMap.addAttribute("operationName", "division");
        modelMap.addAttribute("result", result);
        return "/WEB-INF/view/operation-result.jsp";
    }
}
