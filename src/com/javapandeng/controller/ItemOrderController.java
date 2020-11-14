package com.javapandeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.*;
import com.javapandeng.service.*;
import com.javapandeng.utils.Const;
import com.javapandeng.utils.Pager;
import org.apache.http.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/5 14:06
 */
@Controller
@RequestMapping("/itemOrder")
public class ItemOrderController extends BaseController {

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CarService carService;
    @RequestMapping("findBySql")
    public String findBySql(ItemOrder itemOrder, Model model){
        //查询所有订单
        String sql ="select * from item_order ";
        //code 订单号
        if (!isEmpty(itemOrder.getCode())){
             sql +="where code like '%"+itemOrder.getCode()+"%'";
        }
        sql += " Order by id desc";

        Pager<ItemOrder> pagers = itemOrderService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("itemOrder",itemOrder);

        return "itemOrder/itemOrder";
    }
    @RequestMapping("/my")
    public String my(Model model, HttpSession session){

        Object obj =session.getAttribute(Const.USERID);
        if (obj ==null){
            return "login/uLogin";
        }
        Integer useId = Integer.valueOf(obj.toString());
        //全部订单
        String sql ="select * from item_order where user_id ="+ useId+ " order by id desc";
        List<ItemOrder> all = itemOrderService.listBySqlReturnEntity(sql);
        //待发货
        String sql1 ="select * from item_order where user_id ="+ useId+ " and status =0 order by id desc";
        List<ItemOrder> dfh = itemOrderService.listBySqlReturnEntity(sql1);
        //已取消
        String sql2 ="select * from item_order where user_id ="+ useId+ " and status =1 order by id desc";
        List<ItemOrder> yqx = itemOrderService.listBySqlReturnEntity(sql2);
        //待收货
        String sql3 ="select * from item_order where user_id ="+ useId+ " and status =2 order by id desc";
        List<ItemOrder> dsh = itemOrderService.listBySqlReturnEntity(sql3);
        //已收货
        String sql4 ="select * from item_order where user_id ="+ useId+ " and status =3 order by id desc";
        List<ItemOrder> ysh = itemOrderService.listBySqlReturnEntity(sql4);
        String sql5 ="select * from item_order where user_id ="+ useId+ " and status =4 order by id desc";
        List<ItemOrder> yfh = itemOrderService.listBySqlReturnEntity(sql5);
        model.addAttribute("all",all);
        model.addAttribute("dfh",dfh);
        model.addAttribute("yqx",yqx);
        model.addAttribute("yfh",yfh);
        model.addAttribute("dsh",dsh);
        model.addAttribute("ysh",ysh);


        return "itemOrder/my";
    }

    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(@RequestBody List<CarDto> list, HttpSession session){
        JSONObject js = new JSONObject();
        Object obj = session.getAttribute(Const.USERID);

        if (obj==null){
            js.put(Const.RES,0);
            return js.toJSONString();
        }
        Integer userId= Integer.valueOf(obj.toString());
        User user = userService.load(userId);
        if (isEmpty(user.getAddress())){
            js.put(Const.RES,2);
            return js.toJSONString();
        }

        List<Integer> ids = new ArrayList<>();
        BigDecimal to = new BigDecimal(0);
        for(CarDto c:list){
            ids.add(c.getId());
            Car load = carService.load(c.getId());
            to = to.add(new BigDecimal(load.getPrice()).multiply(new BigDecimal(c.getNum())));
        }
        ItemOrder order = new ItemOrder();
        order.setStatus(0);
        order.setCode(getOrderNo());
        order.setIsDelete(0);
        order.setTotal(to.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        order.setUserId(userId);
        order.setAddTime(new Date());
        itemOrderService.insert(order);

        //订单详情放入orderDetail，删除购物车
        if(!CollectionUtils.isEmpty(ids)){
            for(CarDto c:list){
                Car load = carService.load(c.getId());
                OrderDetail de = new OrderDetail();
                de.setItemId(load.getItemId());
                de.setOrderId(order.getId());
                de.setStatus(0);
                de.setNum(c.getNum());
                de.setTotal(String.valueOf(c.getNum()*load.getPrice()));
                orderDetailService.insert(de);
                //修改成交数
                Item load2 = itemService.load(load.getItemId());
                load2.setGmNum(load2.getGmNum()+c.getNum());
                itemService.updateById(load2);
                //删除购物车
                carService.deleteById(c.getId());
            }
        }
        js.put(Const.RES,1);
        return js.toJSONString();
    }

    private static String date;
    private static long orderNum = 0L;
    public static synchronized String getOrderNo(){
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum = 0L;
        }
        orderNum++;
        long orderNO = Long.parseLong(date)*10000;
        orderNO += orderNum;
        return orderNO+"";
    }

    @RequestMapping("/qx")
    public String qx(Integer id){
        ItemOrder load = itemOrderService.load(id);
        load.setStatus(1);
        itemOrderService.updateById(load);

        return "redirect:/itemOrder/my";
    }

    @RequestMapping("fh")
    public String fh(Integer id){
        ItemOrder load = itemOrderService.load(id);
        load.setStatus(2);
        itemOrderService.updateById(load);

        return "redirect:/itemOrder/findBySql";
    }

    @RequestMapping("sh")
    public String sh(Integer id){
        ItemOrder load = itemOrderService.load(id);
        load.setStatus(3);
        itemOrderService.updateById(load);

        return "redirect:/itemOrder/findBySql";
    }

    @RequestMapping("pj")
    public String pj(Model model,Integer id){
        model.addAttribute("id",id);
        return "itemOrder/pj";
    }
}
