package com.sales.service;

//定义接口
//编写service方法不一定和DAO层一一对应，这里纯属巧合
//有时候，service一个方法里会囊括几个不同的DAO层里的各类方法

//service不单纯是对于dao的增删改查的调用，service是业务层，所以应该更切近于具体业务功能要求，
// 所以在这一层，一个方法所体现的是一个可以对外提供的功能，比如购物商城中的生成订单方法，
// 这里面就不简单是增加个订单记录那么简单，我们需要查询库存，核对商品等一系列实际业务逻辑的处理.

import com.sales.entity.RegisterInfo;

import java.util.List;

public interface RegisterService {
    /**
     * 获取注册列表
     *
     * @return
     */
    List<RegisterInfo> getRegisterInfo();

    /**
     * 通过username获取注册信息
     *
     * @param username
     * @return
     */
    RegisterInfo getRegisterInfoByUserName(String username);

    /**
     * 增加注册信息
     *
     * @param registerInfo
     * @return
     */
    boolean addRegisterInfo(RegisterInfo registerInfo);

    /**
     * 修改注册信息
     *
     * @param registerInfo
     * @return
     */
    boolean updateRegisterInfo(RegisterInfo registerInfo);


    /**
     * 删除注册信息
     *
     * @param username
     * @return
     */
    boolean deleteRegisterInfo(String username);
}
