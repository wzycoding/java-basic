package com.wzy.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wzy
 */
@Slf4j
@Service
public class UserTask {

    @Scheduled(cron = "0/2 * * * * ?")
    public void loadUserCache() {
        log.info("load user cache");
    }
}
