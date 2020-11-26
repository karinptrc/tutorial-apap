package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(
            @ModelAttribute UserModel user,
            Model model
    ){
        if (userService.validate(user.getPassword())){
            userService.addUser(user);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("errorAdd", "Password setidaknya harus memiliki angka, huruf, dan minimal 8 karakter.");
        }
        return "home";
    }

    @RequestMapping(value = "/form-update-password")
    public String formUpdatePassword(){
        return "update-password";
    }

    @RequestMapping(value = "/update-password")
    public String updatePassword(
            HttpServletRequest request,
            Model model
    ){
        String[] password = request.getParameterValues("pass");
        if (userService.validate(password[1])) {
            userService.updatePass(request.getRemoteUser(), password);
        } else {
            model.addAttribute("errorUpdate", "Password setidaknya harus memiliki angka, huruf, dan minimal 8 karakter.");
        }
        return "update-password";
    }
}
