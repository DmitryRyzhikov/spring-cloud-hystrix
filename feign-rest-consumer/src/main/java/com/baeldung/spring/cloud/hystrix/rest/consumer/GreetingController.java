package com.baeldung.spring.cloud.hystrix.rest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @Autowired
    private GreetingClient greetingClient;


    @RequestMapping("/get-greeting/{username}")
    public String getGreeting(Model model, @PathVariable("username") String username) {
        String greeting = greetingClient.greeting(username);

        model.addAttribute("greeting", greeting);
        return "greeting-view";
    }
}
