package com.booking.ddd.application.service.event.impl;

import com.booking.ddd.application.service.event.EventApplicationService;
import org.springframework.stereotype.Service;

@Service
public class EventApplicationServiceImpl implements EventApplicationService {
    @Override
    public String sayHi(String who) {
        return "Hi application " + who;
    }
}
