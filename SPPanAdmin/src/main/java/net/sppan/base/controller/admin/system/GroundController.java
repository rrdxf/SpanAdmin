package net.sppan.base.controller.admin.system;

import com.alibaba.fastjson.JSON;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Resource;
import net.sppan.base.service.IGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/ground")
public class GroundController extends BaseController {

    @Autowired
    private IGroundService iGroundService;
    @RequestMapping("/index")
    public String index(){
        return "/admin/ground/index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Page<Ground> list(
            @RequestParam(value="searchText",required=false) String searchText
    ){
        Page<Ground> page = iGroundService.findAllByLike(searchText,getPageRequest());
        return page;
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap map){
        Ground ground = iGroundService.find(id);
        map.put("ground",ground);
        List<Ground> list = iGroundService.findAll();

        map.put("list",list);
        return "admin/ground/form";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Ground ground,ModelMap map){
        try {
            iGroundService.saveOrUpdate(ground);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") Integer id,ModelMap map){
        try {
            iGroundService.delete(id);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("/add")
    public String add(ModelMap map){
        List<Ground> list = iGroundService.findAll();
        map.put("list",list);
        return "admin/ground/form";
    }
}
