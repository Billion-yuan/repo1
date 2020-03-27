package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Items;
import com.itheima.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName ItemsController
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2020/3/23 11:36
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;


    // 查询所有
    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Items> list = itemsService.list();
        model.addAttribute("items",list);
        return "items"; // 视图解析器：/WEB-INF/pages/items.jsp
    }

    // 新增
    @RequestMapping(value = "/save")
    public String save(Items items) {
        int rows = itemsService.save(items);
        System.out.println("rows："+rows);
        return "redirect:/items/list";  // 需求：新增完成之后，定向到查询列表的页面（将新增的数据也查询出来）
    }
}
