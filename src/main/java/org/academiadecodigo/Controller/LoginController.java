package org.academiadecodigo.Controller;

import org.academiadecodigo.Authenticator.Authenticator;
import org.academiadecodigo.Model.User;
import org.academiadecodigo.Service.MockUserService;
import org.academiadecodigo.Service.UserService;
import org.springframework.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by codecadet on 12/12/16.
 */

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String sayHello(Model model) {

        model.addAttribute("user", new User());
        return "index";
    }

   @RequestMapping(method = RequestMethod.POST, value = "/login")
   public String doLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

       if (user.getUserName() == null || user.getUserName().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
           return "index";
       }

       if (authenticator.authenticate(user.getUserName(), user.getPassword())) {
           model.addAttribute("greeting", "Welcome " + user.getUserName());
           model.addAttribute("userList", (userService.getUsersList()));
           return "main";

       } if(bindingResult.hasErrors()){
           return "index";
       }

       else {
           model.addAttribute("error", "Authentication Failure");
           return "index";
       }
   }

    @RequestMapping(method = RequestMethod.GET, value = "/user/logout")
    public String logOut(Model model, SessionStatus sessionStatus) {

        sessionStatus.setComplete();
        return "redirect:/login";
    }
}

