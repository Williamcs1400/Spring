package com.william.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHallo(){
        return "Hello World Time on server is: " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run 5km now!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

}
