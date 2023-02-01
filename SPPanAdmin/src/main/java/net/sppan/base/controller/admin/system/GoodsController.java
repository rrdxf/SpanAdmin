package net.sppan.base.controller.admin.system;

import com.alibaba.fastjson.JSON;
import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Goods;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.User;
import net.sppan.base.service.IGoodsService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController extends BaseController {

    @Autowired
    IGoodsService goodsService;

    @RequestMapping("/myindex")
    public String mygoodindex(){
        return "admin/goods/myindex";
    }
    @RequestMapping("/mylist")
    @ResponseBody
    public String mylist(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Page<Goods> page = goodsService.findAllByLike(null,getPageRequest());
        List<Goods> goodsList = new ArrayList<>();
        for (Goods goods : page){
            if (goods.getUser_id() == user.getId()){
                goodsList.add(goods);
            }
        }
        String ss = JSON.toJSONString(goodsList);
        return ss;
    }
    @RequestMapping("/ingooform")
    public String ingoodform(){
        return "/admin/goods/ingoodform";
    }

    @RequestMapping("/useradd")
    @ResponseBody
    public JsonResult useradd(Goods goods){

        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            goods.setUser_id(user.getId());
            goods.setIn_time(new Date());
            goodsService.saveOrUpdate(goods);
        }catch (Exception e){
            e.printStackTrace();
            return JsonResult.success("添加失败");
        }
        return JsonResult.success("添加成功");
    }
    @RequestMapping("/index")
    public String index(){
        return "admin/goods/index";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Page<Goods> list(
            @RequestParam(value="searchText",required=false) String searchText
    ){
        Page<Goods> page = goodsService.findAllByLike(searchText,getPageRequest());
        return page;
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap map){
        Goods goods = goodsService.find(id);
        map.put("goods",goods);
        List<Goods> list = goodsService.findAll();

        map.put("list",list);
        return "admin/goods/form";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(Goods goods, ModelMap map){
        try {
            goodsService.saveOrUpdate(goods);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") Integer id,ModelMap map){
        try {
            goodsService.delete(id);
        }catch (Exception e){
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }
    @RequestMapping("/add")
    public String add(ModelMap map){
        List<Goods> list = goodsService.findAll();
        map.put("list",list);
        return "admin/goods/form";
    }
}
