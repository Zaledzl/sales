package com.sales.service.Impel;

//定义接口的实现
//service层接口的实现，这里，下面的方法可以自动生成

import com.sales.dao.RegisterDao;
import com.sales.service.RegisterService;
import com.sales.entity.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;
    //因为用到了DAO层的接口

    @Override
    public List<RegisterInfo> getRegisterInfo() {
        return registerDao.queryRegisterInfo();
    }

    @Override
    public RegisterInfo getRegisterInfoByUserName(String username) {
        System.out.println("成功进入了获取实体类的函数");
        System.out.println("service层成功接收到了来自controller层的参数");
        System.out.println("接收到的参数是： "+username);
        RegisterInfo registerInfo = registerDao.querryRegisterInfoByUserName(username);
        System.out.println("service层是否真正返回了正确的结果");
        System.out.println("registerInfo里面的信息是" + registerInfo.getUsername());
        return registerDao.querryRegisterInfoByUserName(username);
    }

    @Transactional
    //增删改查涉及到步骤复杂一点的，就写上 @Transactional ，加入事务的控制
    //@Transactional 不是接收到任何异常都会回滚，其默认是接收到RuntimeException之后，回滚
    //这里的参数可以修改   @Transactional(rollbackFor = Exception.class)   后面对应的要修改
    @Override
    public boolean addRegisterInfo(RegisterInfo registerInfo) {

        // 空值判断，主要是判断username不为空
        //判断其不为空，或是不传入空值   后面的意思就是判断从前台传过来的参数不为空  前面的意思就是调用的这个函数的返回值不为空，是之前的entity的事情了，这一般不会出问题
        //if (area.getAreaName() != null && !"".equals(area.getAreaName()))
        if (registerInfo.getUsername() != null) {
            //对传入的实体类进行非空的判断，并给其设置上了默认的值
            //在这里的增删改查，因为新增加的变量都是由外界传入的，所以需要要设定默认值，这里直接什么都不写就好
            try {
                //进行数据库的插入操作
                int effectedNum = registerDao.insertRegisterInfo(registerInfo);
                //往数据库里面插入RegisterInfo的实体类   上面等式的右边的意思就是已经调用了这个函数
                //使用effectedNum来接受insertRegisterInfo方法返回的结果

                //Map map = new HashMap();
                //     map.put("id",1);
                //     map.put("name",zhangsan);
                //     Good good = goodService.selectGood(map);

                //新建图，将获取的数值放到图里面，图的string对应mybatis.mapper里面的变量，再把整个map作为函数的参数传过去


                if (effectedNum > 0) {
                    return true;     //插入成功
                } else {
                    throw new RuntimeException("添加注册信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加注册信息失败:" + e.getMessage());
                //e.getMessage() 的意思是直接输出错误信息
                //e.toString()获取的信息包括异常类型和异常详细消息，而e.getMessage()只是获取了异常的详细消息字符串。
            }
        } else {
            throw new RuntimeException("注册信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateRegisterInfo(RegisterInfo registerInfo) {
        // 空值判断，主要是姓名不为空
        if (registerInfo.getUsername() != null) {
            //这里的条件判断可以根据真实的需求进行个性化判断
            //设置默认值

            try {
                // 更新区域信息
                int effectedNum = registerDao.updateRegisterInfo(registerInfo);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteRegisterInfo(String username) {

        try {
            // 删除用户信息
            int effectedNum = registerDao.deleteRegisterInfo(username);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除用户信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除用户信息失败:" + e.toString());
        }
    }
}