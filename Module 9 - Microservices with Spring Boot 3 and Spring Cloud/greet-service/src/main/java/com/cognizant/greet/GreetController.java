// Exercise: Create Spring Cloud API Gateway and call microservice thru gateway
package com.cognizant.greet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public String sayHello() {
        return "Hello World!!";
    }
}
