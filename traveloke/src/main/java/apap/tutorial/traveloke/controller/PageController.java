package apap.tutorial.traveloke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/")
    private String home(
            Model model
    ){
        model.addAttribute("page", "Home");
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
