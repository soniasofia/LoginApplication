package org.academiadecodigo.Controller;

import org.academiadecodigo.Model.User;
import org.academiadecodigo.Service.UserService;
import org.springframework.asm.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by codecadet on 14/12/16.
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String listUsers(Model model) {

        User user = (User)model.asMap().get("user");

        if(user == null){
            return "redirect:/login";
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("userList", (userService.getUsersList()));
            return "main";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {

        userService.addUser(user);
        redirectAttributes.addFlashAttribute("addedUser","Added user " + user.getUserName() + " successfully!");
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/remove/{userName}")
    public String removeUser(Model model, @PathVariable("userName") String userName, RedirectAttributes redirectAttributes) {

        userService.remove(userName);
        redirectAttributes.addFlashAttribute("removedUser","Removed user " + userName + " successfully!");
        return "redirect:/users";
    }

    //Todo acrescentar botão edit

    @RequestMapping(method = RequestMethod.GET, value = "/user/edit/{userName}")
    public String editUser(Model model) {

        model.addAttribute("user", new User());
        return "editUser";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/edit/{userName}")
    public String submitUser(Model model, @PathVariable("userName") String userName) {

        User user = userService.findByName(userName);
        String newName = user.getUserName();
        user.setUserName(newName);
        return "redirect:/users";
    }
}
