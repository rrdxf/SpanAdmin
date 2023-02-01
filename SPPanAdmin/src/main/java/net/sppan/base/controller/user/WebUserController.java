package net.sppan.base.controller.user;

import com.alibaba.fastjson.JSON;
import net.sppan.base.common.JsonResult;
import net.sppan.base.entity.User;
import net.sppan.base.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import net.sppan.base.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class WebUserController extends BaseController {
    @Autowired
    IUserService userService;
    @RequestMapping("/login")
    public String login(){
        return "/user/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username , @RequestParam("password")String password, ModelMap map){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            return "user/index";
        }catch (AuthenticationException e){
            map.put("message",e.getMessage());
        }
        return "user/login";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "/user/form";
    }

    @RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(User user, ModelMap map){
        try {
            User my = (User) SecurityUtils.getSubject().getPrincipal();
            my.setUserName(user.getUserName());
            my.setNickName(user.getNickName());
            my.setSex(user.getSex());
            my.setBirthday(user.getBirthday());
            my.setTelephone(user.getTelephone());
            my.setEmail(user.getEmail());
            my.setAddress(user.getAddress());
            userService.saveOrUpdate(my);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value = { "/list1" })
    @ResponseBody
    public Page<User> list1(
            @RequestParam(value="searchText",required=false) String searchText
    ) {
//		SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
//		String searchText = request.getParameter("searchText");
//		if(StringUtils.isNotBlank(searchText)){
//			builder.add("nickName", Operator.likeAll.name(), searchText);
//		}

        Page<User> page = userService.findAllByLike(searchText, getPageRequest());
        String ss = JSON.toJSONString(page);
        //List<User> list = userService.findAll();
        for (User user : page){
            System.out.println(user);
        }
        return page;
    }
}
