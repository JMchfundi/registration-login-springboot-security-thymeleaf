package techIn.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techIn.springboot.springsecurity.model.User;
import techIn.springboot.springsecurity.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping(value = "/viewusers")
    public  String viewusers (Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "viewusers";
    }
}
