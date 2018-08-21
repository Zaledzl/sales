package com.sales.entity;

//这里的主要的任务就是 命名变量 ，变量的名称要和数据库中的名称保持一致，或是，利用驼峰命名转换的那个东西，在mybatis的配置文件里面
public class RegisterInfo {
    //变量一般都是String  不会是char（varchar）
    //主键  用户名
    private String username;
    //密码
    private String password;

    //可以自动添加setter和getter方法
    //小灯泡报错  alt+enter
    //让idea自动添加内容   alt+insert

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
