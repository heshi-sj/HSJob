package com.lagou.mapper;

import com.lagou.pojo.User;
import tk.mybatis.mapper.common.Mapper;

public interface IMyUserMapper extends Mapper<User> {
    public void insertUser(User user);

    public User selectById(User user);

    public void updateById(User user);
}