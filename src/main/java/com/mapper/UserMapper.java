package com.mapper;

import com.model.User;
import com.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.annotation.RegisterMapper;


public interface UserMapper extends MyMapper<User> {
}
