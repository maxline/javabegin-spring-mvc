package ru.javabegin.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javabegin.training.objects.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    //http://localhost:8081/javabegin/app/login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@RequestMapping("/main")
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "login";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
