package com.booking.ddd.controller.resource;

import com.booking.ddd.application.service.event.EventApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {
    @Autowired
    private EventApplicationService eventApplicationService;

    @GetMapping("/application")
    public String sayHi(@PathVariable String who) {

        return eventApplicationService.sayHi(who);
    }
}
