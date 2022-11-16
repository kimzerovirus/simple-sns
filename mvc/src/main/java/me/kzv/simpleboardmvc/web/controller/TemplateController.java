package me.kzv.simpleboardmvc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TemplateController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
