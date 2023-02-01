package net.sppan.base.controller.admin;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;

import net.sppan.base.entity.User;
import net.sppan.base.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController extends BaseController {
	@Autowired
	IUserService userService;
	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,ModelMap model
			) {
		try {
			 Subject subject = SecurityUtils.getSubject();
			 UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			return redirect("/admin/index");
		} catch (AuthenticationException e) {
			model.put("message", e.getMessage());
		}
		return "admin/login";
	}
	@RequestMapping("/admin/registe")
	public  String registe(){
		return "/admin/form";
	}
	@RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return redirect("admin/login");
	}
	@RequestMapping(value= {"user/addd"})
	@ResponseBody
	public JsonResult edit(User user, ModelMap map){
		try {
			user.setMoney(0.0);
			user.getRoles();
			userService.saveOrUpdate(user);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
}
