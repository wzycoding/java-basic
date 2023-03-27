package com.wzy;

import com.alibaba.fastjson.JSON;
import com.wzy.entity.UserLoginRecord;
import com.wzy.enums.LoginType;
import com.wzy.mapper.UserLoginRecordMapper;
import com.wzy.table.IdTableNameHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DynamicTableNameTest {
    @Autowired
    private UserLoginRecordMapper userLoginRecordMapper;

    @Test
    public void testInsert() {
        IdTableNameHandler.initCurrentId(1L);
        UserLoginRecord userLoginRecord1 = new UserLoginRecord();
        userLoginRecord1.setUserId(1L);
        userLoginRecord1.setLoginType(LoginType.PHONE.getType());
        userLoginRecordMapper.insert(userLoginRecord1);

        IdTableNameHandler.initCurrentId(12L);
        UserLoginRecord userLoginRecord12 = new UserLoginRecord();

        userLoginRecord12.setUserId(12L);
        userLoginRecord12.setLoginType(LoginType.ONE_KEY.getType());
        userLoginRecordMapper.insert(userLoginRecord12);
    }

    @Test
    public void testSelectList() {
        IdTableNameHandler.initCurrentId(12L);
        List<UserLoginRecord> userLoginRecordList =
                userLoginRecordMapper.selectList(null);

        log.info(JSON.toJSONString(userLoginRecordList));

    }

    @Test
    public void testCustomSelectList() {
        IdTableNameHandler.initCurrentId(1L);
        List<UserLoginRecord> userLoginRecordList =
                userLoginRecordMapper.selectListByUserId(1L);

        log.info(JSON.toJSONString(userLoginRecordList));
    }
}
