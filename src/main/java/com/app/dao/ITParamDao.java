package com.app.dao;

import com.app.entity.TParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ITParamDao {
    int deleteByPrimaryKey(Integer paramId);

    int insert(TParam record);

    int insertSelective(TParam record);

    TParam selectByPrimaryKey(Integer paramId);

    int updateByPrimaryKeySelective(TParam record);

    int updateByPrimaryKey(TParam record);
    @Insert("insert into T_PARAM (user_id,pub_key,pri_key) values(select user_id from T_USER where user_name = #{username},#{pub},#{pri})")
    int insertUserParam(String username, String pub, String pri);

    @Select("select pri_key from T_PARAM where user_id = (select user_id from T_USER where user_name = #{username})")
    String getPrivateKey(String username);
}