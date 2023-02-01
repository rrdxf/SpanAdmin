package net.sppan.base.controller.admin.system;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Play;
import net.sppan.base.entity.User;
import net.sppan.base.service.IPlayService;
import net.sppan.base.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/play")
public class PlayController extends BaseController {
    @Autowired
    IPlayService playService;
    @Autowired
    IUserService userService;
    @RequestMapping("/index")
    public String index(){
        return "/admin/play/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Page<Play> list(
            @RequestParam(value="searchText",required=false) String searchText
    ){
        Page<Play> page = playService.findAllByLike(searchText,getPageRequest());
        return page;
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap map){
        Play play = playService.find(id);
        map.put("play",play);
        List<Play> list = playService.findAll();

        map.put("list",list);
        return "admin/play/form";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Play play, ModelMap map){
        try {
            User my = (User) SecurityUtils.getSubject().getPrincipal();
            play.setUserId(my.getId());
            play.setJoincount(0);
            playService.saveOrUpdate(play);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") Integer id,ModelMap map){
        try {
            playService.delete(id);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("/add")
    public String add(ModelMap map){
        List<Play> list = playService.findAll();
        map.put("list",list);
        return "admin/play/form";
    }
}
