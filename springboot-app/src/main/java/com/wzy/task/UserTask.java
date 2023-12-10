package com.wzy.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wzy
 */
@Slf4j
@Service
public class UserTask {

    /**
     * 每天凌晨两点发放用户积分
     */
    @XxlJob(value = "grantUserCreditsTask")
    public ReturnT<String> grantUserCreditsTask(String param) {
        log.info("======grant user credits======");
        return ReturnT.SUCCESS;
    }
}
