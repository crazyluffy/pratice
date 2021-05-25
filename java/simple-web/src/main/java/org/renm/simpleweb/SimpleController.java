package org.renm.simpleweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    @RequestMapping("/hello")
    public String helloWorld() {
        System.out.println("request SimpController /hello ");
        return "hello";
    }
}
