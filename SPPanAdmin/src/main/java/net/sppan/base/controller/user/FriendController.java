package net.sppan.base.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.dao.IApplyFriendDao;
import net.sppan.base.dao.IFriendDao;
import net.sppan.base.entity.ApplyFriend;
import net.sppan.base.entity.Friend;
import net.sppan.base.entity.User;
import net.sppan.base.service.IApplyFriendService;
import net.sppan.base.service.IFriendService;
import net.sppan.base.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/friend")
public class FriendController extends BaseController {
    @Autowired
    IFriendService friendService;
    @Autowired
    IApplyFriendService applyFriendService;
    @Autowired
    IUserService userService;
    /**
     * 请求好友首页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "/user/friend/index";
    }

    /**
     * 获取好友当前登录用户好友列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Friend> friends = friendService.findAllBymyid(user.getId());
        List<Result> results = new ArrayList<>();
        for(Friend friend: friends){
            Result r = new Result();
            r.friendid = friend.getFriendid();
            r.birthday = friend.getFriend().getBirthday();
            r.email = friend.getFriend().getEmail();
            r.sex = friend.getFriend().getSex();
            r.telephone = friend.getFriend().getTelephone();
            r.name = friend.getFriend().getUserName();
            results.add(r);
        }
        String ss = JSON.toJSONString(results);
        return ss;
    }

    /**
     * 删除好友
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id")Integer id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try {
            Integer friend = friendService.findByfriendidAndmyid(id,user.getId());
            friendService.delete(friend);
            friend =  friendService.findByfriendidAndmyid(user.getId(),id);
            friendService.delete(friend);
        }catch (Exception e){
            return JsonResult.success("操作失败");
        }
        return JsonResult.success("操作成功");
    }

    /**
     * 弹出搜索框
     * @return
     */
    @RequestMapping("/search")
    public String search(){
        return "user/friend/search";
    }

    /**
     * 添加好友
     * @param id 好友id
     * @return
     */
    @RequestMapping("/add/{id}")
    @ResponseBody
    public JsonResult add(@PathVariable("id")Integer id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (id == user.getId()) return JsonResult.success("不能添加自己为好友");
        Friend friend = friendService.findByfriendid(id);
        if (friend != null){
            return JsonResult.success("该用户已经是您好友");
        } else {
            ApplyFriend applyFriend = new ApplyFriend();
            applyFriend.setFriendid(user.getId());
            applyFriend.setMyid(id);
            try {
                applyFriendService.save(applyFriend);
            }catch (Exception e){
                return JsonResult.success("网络异常");
            }
            return JsonResult.success("好友申请已发送");
        }
    }

    /**
     *  拉取用户列表
     * @param searchText
     * @return
     */
    @RequestMapping(value = { "/userlist" })
    @ResponseBody
    public Page<User> list(
            @RequestParam(value="searchText",required=false) String searchText
    ) {
//		SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
//		String searchText = request.getParameter("searchText");
//		if(StringUtils.isNotBlank(searchText)){
//			builder.add("nickName", Operator.likeAll.name(), searchText);
//		}
        if (searchText == null)//保证进入初始页面，列表中没有用户
            searchText = "rqdasfasfasfasf";
        Page<User> page = userService.findAllByLike(searchText, getPageRequest());
        return page;
    }

    /**
     * 获取申请列表页面
     * @return
     */
    @RequestMapping("/applyindex")
    public String applyindex(){
        return "/user/friend/applyfriend";
    }

    @RequestMapping("/applylist")
    @ResponseBody
    public String applylist(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<ApplyFriend> friends = applyFriendService.findAllBymyid(user.getId());
        List<Result> results = new ArrayList<>();
        for(ApplyFriend friend: friends){
            Result r = new Result();
            r.friendid = friend.getFriendid();
            r.birthday = friend.getFriend().getBirthday();
            r.email = friend.getFriend().getEmail();
            r.sex = friend.getFriend().getSex();
            r.telephone = friend.getFriend().getTelephone();
            r.name = friend.getFriend().getUserName();
            results.add(r);
        }
        String ss = JSON.toJSONString(results);
        return ss;
    }

    /**
     * 同意好友申请
     * @param id
     * @return
     */
    @RequestMapping("/agree/{id}")
    @ResponseBody
    public JsonResult agree(@PathVariable("id") Integer id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try{
            Integer friend = applyFriendService.findByfriendidAndmyid(id,user.getId());
            applyFriendService.delete(friend);
            Friend my = new Friend();
            my.setFriendid(id);
            my.setMyid(user.getId());
            friendService.save(my);
            my = new Friend();
            my.setFriendid(user.getId());
            my.setMyid(id);
            friendService.save(my);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.success("请求错误");
        }
        return JsonResult.success("添加成功");
    }

    /**
     * 不同意好友申请
     * @param id
     * @return
     */
    @RequestMapping("/disagree/{id}")
    @ResponseBody
    public JsonResult disagree(@PathVariable("id") Integer id){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        try{
            Integer friend = applyFriendService.findByfriendidAndmyid(id,user.getId());
            applyFriendService.delete(friend);
        }catch (Exception e){
            return JsonResult.success("请求错误");
        }
        return JsonResult.success("已不同意该申请");
    }
    /**
     * 结果类
     */
    private class Result{
        Integer friendid;
        String name;
        @JSONField(format = "yyyy-MM-dd")
        Date birthday;
        String email;
        String telephone;
        Integer sex;

        public Integer getFriendid() {
            return friendid;
        }

        public void setFriendid(Integer friendid) {
            this.friendid = friendid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }
    }
}
