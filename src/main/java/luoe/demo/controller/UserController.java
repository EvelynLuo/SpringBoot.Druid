package luoe.demo.controller;

import luoe.demo.entity.User;
import luoe.demo.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Data 2020/6/30 11:00
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("get/{name}")
    public String query(@PathVariable String name) {
        JSONObject object = new JSONObject();
        JSONObject combine = new JSONObject();
        //object = JSONObject.fromObject();
        //return object.toString();
        List<User> list = service.query(name);
        for(User e:list){
            object = JSONObject.fromObject(e);
            combine.put(e.getName(),object);
        }
        return combine.toString();
    }
}