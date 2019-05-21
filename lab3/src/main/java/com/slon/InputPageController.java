package com.slon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InputPageController {

    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("inputDto", new InputDto());
        return "WEB-INF/view/index.jsp";
    }
}
