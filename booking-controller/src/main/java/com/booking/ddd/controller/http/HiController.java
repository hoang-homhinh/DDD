package com.booking.ddd.controller.http;

import com.booking.ddd.application.service.event.EventApplicationService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HiController {
    @Autowired
    private EventApplicationService eventApplicationService;

    @GetMapping("/hi")
    @RateLimiter(name= "backendA", fallbackMethod = "fallbackHello")
    public String sayHi() {
        return eventApplicationService.sayHi("hi");
    }

    public String fallbackHello(Throwable t) {
        return "Too many requests, please try again later";
    }

    @GetMapping("/hello")
    @RateLimiter(name="backendB", fallbackMethod = "fallbackHello")
    public String sayHello() {
        return eventApplicationService.sayHi("hello");
    }
}
