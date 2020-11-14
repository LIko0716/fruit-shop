package com.javapandeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.Car;
import com.javapandeng.po.CarDto;
import com.javapandeng.po.Item;
import com.javapandeng.po.User;
import com.javapandeng.service.CarService;
import com.javapandeng.service.ItemService;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/14 8:59
 */
@Controller
@RequestMapping("/car")
public class CarController extends BaseController {

    @Autowired
    private CarService carService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Car car, HttpServletRequest request){
        JSONObject js = new JSONObject();
        Object attribute = request.getSession().getAttribute(Const.USERID);
        if(attribute==null){
            js.put(Const.RES,0);
            return js.toJSONString();
        }
        //保存到购物车
        Integer userId = Integer.valueOf(attribute.toString());
        car.setUserId(userId);
        Item item = itemService.load(car.getItemId());
        String price = item.getPrice();
        Double valueOf = Double.valueOf(price);
        car.setPrice(valueOf);
        if(item.getZk()!=null){
            valueOf = valueOf*item.getZk()/10;
            BigDecimal bg = new BigDecimal(valueOf).setScale(2, RoundingMode.UP);
            car.setPrice(bg.doubleValue());
            valueOf = bg.doubleValue();
        }
        Integer num = car.getNum();
        Double t = valueOf*num;

        BigDecimal bg = new BigDecimal(t).setScale(2, RoundingMode.UP);
        double doubleValue = bg.doubleValue();
        car.setTotal(doubleValue+"");
        carService.insert(car);
        js.put(Const.RES,1);
        return js.toJSONString();
    }

    @RequestMapping("/findBySql")
    public String findBySql(Model model, HttpSession session){
       Object obj= session.getAttribute(Const.USERID);

       if (obj==null){
           return "login/uLogin";
       }
       Integer userId =Integer.valueOf(obj.toString());
        String sql ="select * from car where user_id = " + userId;
        List<Car> list = carService.listBySqlReturnEntity(sql);
        model.addAttribute("list",list);
        return "car/car";
    }


}
