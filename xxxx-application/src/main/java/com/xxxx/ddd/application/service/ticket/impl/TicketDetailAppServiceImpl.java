package com.xxxx.ddd.application.service.ticket.impl;

import com.xxxx.ddd.application.service.ticket.TicketDetailAppService;
import com.xxxx.ddd.application.service.ticket.cache.TicketDetailCacheService;
import com.xxxx.ddd.domain.model.entity.TicketDetail;
import com.xxxx.ddd.domain.service.TicketDetailDomainService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketDetailAppServiceImpl implements TicketDetailAppService {

    private static final Logger log = LoggerFactory.getLogger(TicketDetailAppServiceImpl.class);
    // CALL Service Domain Module
    @Autowired
    private TicketDetailDomainService ticketDetailDomainService;

    // CALL CACHE
    @Autowired
    private TicketDetailCacheService ticketDetailCacheService;

    @Override
    public TicketDetail getTicketDetailById(Long ticketId) {
        log.info("Implement Application : {}", ticketId);
//        return ticketDetailDomainService.getTicketDetailById(ticketId);
//        return ticketDetailCacheService.getTicketDefaultCacheNormal(ticketId, System.currentTimeMillis());
        return ticketDetailCacheService.getTicketDefaultLocalCache(ticketId, System.currentTimeMillis());
    }
}
