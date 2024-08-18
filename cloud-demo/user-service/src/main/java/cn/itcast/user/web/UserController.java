package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties pattern;

//    @GetMapping("/get/Setting1")
//    public String getSetting1(){
//        System.out.println("dateformat = " + dateformat);
//        return dateformat;
//    }

    @GetMapping("/get/Setting2")
    public String getSetting2(){
        System.out.println("dateformat = " + pattern.getDateformat());
        return pattern.getDateformat();
    }

    @GetMapping("/get/data")
    public String getData(){
        return pattern.getData();
    }

    @GetMapping("/get/props")
    public PatternProperties getProps(){
        return pattern;
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        if(id == 1){
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (id == 2) {
            throw new RuntimeException();
        }
        return userService.queryById(id);
    }
}
