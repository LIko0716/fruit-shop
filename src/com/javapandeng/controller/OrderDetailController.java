package com.javapandeng.controller;

import com.javapandeng.po.ItemOrder;
import com.javapandeng.po.OrderDetail;
import com.javapandeng.service.OrderDetailService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hangzhi1063
 * @date 2020/11/5 15:31
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/ulist")
    public String ulist(Model model, OrderDetail orderDetail){
        String sql = "select * from order_detail where order_id ="+orderDetail.getOrderId();
        Pager<OrderDetail> pagers = orderDetailService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",orderDetail);
        return "orderDetail/ulist";
    }
}
