package com.wzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzy.entity.UserLoginRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLoginRecordMapper extends BaseMapper<UserLoginRecord> {

    /**
     * 查询用户登录记录通过用户id
     *
     * @param userId 用户id
     * @return 登录记录
     */
    List<UserLoginRecord> selectListByUserId(@Param("userId") Long userId);
}
