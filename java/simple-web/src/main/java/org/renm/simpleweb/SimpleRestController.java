package org.renm.simpleweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class SimpleRestController {

    @RequestMapping("/rest/hello")
    public String helloWorld() {
        System.out.println("request /rest/hello ");
        return "hello world";
    }
}
