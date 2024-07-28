package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.sax.TemplatesHandler;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/getReqHeader")
    public String getReqHeader(@RequestHeader("X-Request-red") String str){
        return str;
    }
}
