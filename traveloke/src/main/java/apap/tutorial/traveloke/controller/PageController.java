package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    private String home(
            Model model
    ){
        model.addAttribute("page", "Home");
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
