package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
    @SentinelResource("hot")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/getReqHeader")
    public String getReqHeader(@RequestHeader("X-Request-red") String str){
        return str;
    }

    @GetMapping("/query")
    public String query(){
        return "query successful!";
    }

    @GetMapping("/update")
    public String update(){
        return "update successful!";
    }

    @GetMapping("/save")
    public String save(){
        orderService.testChain();
        System.out.println("save!!!");
        return "save successful!";
    }

    @GetMapping("/select")
    public String select(){
        orderService.testChain();
        System.out.println("select!!!");
        return "select successful!";
    }
}
