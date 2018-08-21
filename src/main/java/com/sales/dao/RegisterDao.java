package com.sales.dao;

//这里主要定义对应的增删改查的接口
//具体的实现在mapper文件里面
//这里要有 @Mapper

import com.sales.entity.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterDao {
    //定义增删改查的方法\

    /**
     * 列出注册信息表
     *
     * @return
     */
    List<RegisterInfo> queryRegisterInfo();

    /**
     * 根据username列出具体区域
     *
     * @param username
     * @return
     */
    RegisterInfo querryRegisterInfoByUserName(String username);

    /**
     * 插入注册信息
     *
     * @param registerInfo
     * @return
     */
    int insertRegisterInfo(RegisterInfo registerInfo);

    /**
     * 更新注册信息
     *
     * @param registerInfo
     * @return
     */
    int updateRegisterInfo(RegisterInfo registerInfo);

    /**
     * 删除注册信息
     *
     * @param username
     * @return
     */
    int deleteRegisterInfo(String username);
}
