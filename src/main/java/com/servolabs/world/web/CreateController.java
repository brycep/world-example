package com.servolabs.world.web;

import com.servolabs.world.domain.User;
import com.servolabs.world.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("create")
public class CreateController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    void getInitialMessage() {
        // do nothing
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ModelAttribute("message")
    String create(User user) {
        try {
            userDao.createUser(user);
            return "A new user with id "+user.getId()+" has been created successfully";
        } catch (Exception e) {
            return "An error has occured while creating the user (see log for details)";
        }
    }
}
