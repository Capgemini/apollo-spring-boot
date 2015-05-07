package com.capgemini.apollo.sample.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Value("${message.from}")
    private String from;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting() {
        return greeting("World");
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public Greeting greeting(@PathVariable(value="name") String name) {
        return new Greeting("Hello " + name, from);
    }

}
