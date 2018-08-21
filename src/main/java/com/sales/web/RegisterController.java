package com.sales.web;

import com.sales.service.RegisterService;
import com.sales.entity.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//业务Controller方法的实现
// Controller，从字面上理解是控制器，所以它是负责业务调度的，所以在这一层应写一些业务的调度代码，而具体的业务处理应放在service中去写
@Controller
//@ResponseBody  @Controller
@RequestMapping("/superadmin")
//指定根路由
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    //用到了对应的service的接口

    /**
     * 获取整个列表
     *
     * @return
     */

      @GetMapping(value = "/listregister")
      public String listregister(Model model){
          List<RegisterInfo> registerInfoList = registerService.getRegisterInfo();
          model.addAttribute("list",registerInfoList);

          return "list" ;
      }

    @GetMapping(value="/initialregisterpage")
    public String initialregiserpage(Model model){
        return "initialregisterpage";
    }


    @GetMapping(value = "/querrypage")
    public String querrypage(Model model){

        return "querrypage";
    }

    @GetMapping(value="/addregisterpage")
    public String addregiserpage(Model model){
          return "addregisterpage";
    }

    @GetMapping(value="/updateregisterpage")
    public String updateregiserpage(Model model){
        return "updateregisterpage";
    }

    @GetMapping(value="/deleteregisterpage")
    public String deleteregiserpage(Model model){
        return "deleteregisterpage";
    }


    /**
     * 根据username获取单个实体类信息
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/getregisterbyusername", method = RequestMethod.GET)
    public String getRegisterByUserName(Model model,String username){
        RegisterInfo registerInfo = registerService.getRegisterInfoByUserName(username);
        System.out.println(registerInfo.getUsername());
        model.addAttribute("userinfo",registerInfo);

        return "userinfo" ;
    }


    /**
     * 添加注册信息
     *
     * @param
     * @return
     */
    @PostMapping(value = "/addregisterinfo")
    public String addRegister(Model model,String username,String password){
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername(username);
        registerInfo.setPassword(password);
        registerService.addRegisterInfo(registerInfo);
        List<RegisterInfo> registerInfoList = registerService.getRegisterInfo();
        model.addAttribute("list",registerInfoList);
        return "list";
    }

    /**
     * 修改注册信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updateregisterinfo", method = RequestMethod.POST)
    public String updateRegister(Model model,String username,String password){
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setUsername(username);
        registerInfo.setPassword(password);
        registerService.updateRegisterInfo(registerInfo);
        List<RegisterInfo> registerInfoList = registerService.getRegisterInfo();
        model.addAttribute("list",registerInfoList);
        return "list";
    }

    /**
     * 删除注册信息
     *
     * @param
     * @return
     */

    @RequestMapping(value = "/deleteregisterinfo", method = RequestMethod.GET)
    public String deleteRegister(Model model,String username){
        RegisterInfo registerInfo = new RegisterInfo();
        registerService.deleteRegisterInfo(username);
        List<RegisterInfo> registerInfoList = registerService.getRegisterInfo();
        model.addAttribute("list",registerInfoList);
        return "list";
    }

}


