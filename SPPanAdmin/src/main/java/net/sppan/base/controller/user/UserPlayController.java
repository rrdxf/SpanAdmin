package net.sppan.base.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Join;
import net.sppan.base.entity.Play;
import net.sppan.base.entity.User;
import net.sppan.base.service.IGroundService;
import net.sppan.base.service.IJoinSevice;
import net.sppan.base.service.IPlayService;
import net.sppan.base.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/play")
public class UserPlayController extends BaseController {
    @Autowired
    IUserService userService;
    @Autowired
    IPlayService playService;
    @Autowired
    IJoinSevice joinSevice;
    @Autowired
    IGroundService groundService;
    @RequestMapping("/list")
    @ResponseBody
    public Page<Play> list(){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        Page<Play> plays = playService.findAllByUserId(user.getId(),getPageRequest());
        //playService.
        return plays;
    }

    @RequestMapping("/commit")
    @ResponseBody
    public JsonResult commit(Integer id,String role){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user.getMoney() >= 20){
            user.setMoney(user.getMoney() - 20);
            userService.saveOrUpdate(user);

            Join join = new Join();
            join.setUserid(user.getId());
            join.setPlayid(id);
            join.setRole(role);
            join.setStatus(0);
            joinSevice.save(join);

            Play play = playService.find(id);
            play.setJoincount(play.getJoincount() + 1);
            playService.saveOrUpdate(play);
            return JsonResult.success("操作成功");
        }else {
            return JsonResult.success("余额不足");
        }
    }

    @RequestMapping("/getcommit/{id}")
    public String getcommit(@PathVariable("id") Integer id,ModelMap map){
        Play play = playService.find(id);
        map.put("play",play);
        return "/admin/play/commit";
    }
    @RequestMapping("/index")
    public String index(){return "/user/play/index";}

    private Integer MYID = null;
    @RequestMapping(value = "/usercheck/{id}")
    public String check(@PathVariable("id")Integer id, ModelMap map){
        MYID = id;
        //Page<Join> page = joinSevice.findAllByPlayId(id,getPageRequest());

        return "/user/play/check";
    }

    @RequestMapping(value = "/usercheck/list")
    @ResponseBody
    public String list1(){
        List<Join> list = null;
        List<Result> results = new ArrayList<>();
        if (MYID != null){
            list = joinSevice.findAllByPlayId(MYID);
            for (Join join:list){
                Result result = new Result();
                result.id = join.getId();
                result.birthday = join.getJoinuser().getBirthday();
                result.email = join.getJoinuser().getEmail();
                result.telephone = join.getJoinuser().getTelephone();
                result.username = join.getJoinuser().getUserName();
                result.role = join.getRole();
                result.playid = join.getPlayid();
                Integer status = join.getStatus();
                if (status == 0){
                    result.status = "未审核";
                }else  if (status == 1){
                    result.status = "审核通过";
                }else {
                    result.status = "审核不通过";
                }
                results.add(result);
            }
        }

        String ss = JSON.toJSONString(results);
        return ss;
    }

    @RequestMapping("/hasindex")
    public String hasindex(){
        return "user/play/hasindex";
    }
    @RequestMapping(value = "/haslist")
    @ResponseBody
    public String haslist(){
        List<Join> list = null;
        List<Result> results = new ArrayList<>();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        list = joinSevice.findAllByUserId(user.getId());
        for (Join join:list){
            Result result = new Result();
            result.id = join.getId();
            result.birthday = join.getJoinuser().getBirthday();
            result.email = join.getJoinuser().getEmail();
            result.telephone = join.getJoinuser().getTelephone();
            result.username = join.getJoinuser().getUserName();
            result.role = join.getRole();
            result.playid = join.getPlayid();
            result.playname = join.getPlay().getName();
            result.endtime = join.getPlay().getEndtime();
            result.starttime = join.getPlay().getStarttime();
            result.joincount = join.getPlay().getJoincount();
            Integer status = join.getStatus();
            if (status == 0){
                result.status = "未审核";
            }else  if (status == 1){
                result.status = "审核通过";
            }else {
                result.status = "审核不通过";
            }
            results.add(result);
        }

        String ss = JSON.toJSONString(results);
        return ss;
    }
    @RequestMapping(value = "/cancel/{id}")
    @ResponseBody
    public JsonResult cancel(@PathVariable("id")Integer id){
        try {
            joinSevice.delete(id);
            Play play = playService.find(id);
            play.setJoincount(play.getJoincount() - 1);
            playService.saveOrUpdate(play);

            User myuser = (User) SecurityUtils.getSubject().getPrincipal();
            User user = userService.find(myuser.getId());
            user.setMoney(user.getMoney() + 20);
            userService.saveOrUpdate(user);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping("/delete/{id}/{playid}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id")Integer id,@PathVariable("playid")Integer playid,ModelMap map){
        try {
            Join join = joinSevice.find(id);
            join.setStatus(2);
            Play play = playService.find(playid);
            play.setJoincount(play.getJoincount()-1);
            playService.saveOrUpdate(play);

            User user = userService.find(id);
            user.setMoney(user.getMoney() + 20);
            userService.saveOrUpdate(user);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("/go/{id}")
    @ResponseBody
    public JsonResult go(@PathVariable("id")Integer id){
        try {
            Join join = joinSevice.find(id);
            join.setStatus(1);
            joinSevice.update(join);

            Ground ground = groundService.find(join.getPlay().getId());
            ground.setMoney(ground.getMoney() + 20);

            User user = userService.find(1);
            user.setMoney(user.getMoney() + 20);
        }catch (Exception e){
            return JsonResult.success("操作失败");
        }
        return JsonResult.success("操作成功");
    }
    private class Result {
        Integer id;
        String username;
        String role;
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date birthday;
        String telephone;
        String email;
        Integer playid;
        String status;
        String playname;
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date starttime;
        @JSONField(format = "yyyy-MM-dd HH:mm:ss")
        Date endtime;
        Integer joincount;

        public String getPlayname() {
            return playname;
        }

        public void setPlayname(String playname) {
            this.playname = playname;
        }

        public Date getStarttime() {
            return starttime;
        }

        public void setStarttime(Date starttime) {
            this.starttime = starttime;
        }

        public Date getEndtime() {
            return endtime;
        }

        public void setEndtime(Date endtime) {
            this.endtime = endtime;
        }

        public Integer getJoincount() {
            return joincount;
        }

        public void setJoincount(Integer joincount) {
            this.joincount = joincount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getPlayid() {
            return playid;
        }

        public void setPlayid(Integer playid) {
            this.playid = playid;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


}
