
package com.springdoctor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String index (){
        return "Good evening Aviators, this is your captain speaking!";
    }
        @GetMapping("/SaySomething")
    public String saySomething (){
        return "Say Something im given up on you";
    }
    
    
    
}
