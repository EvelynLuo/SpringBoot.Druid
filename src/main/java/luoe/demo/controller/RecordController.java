package luoe.demo.controller;

import luoe.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService service;

    @GetMapping("/get/{id}")
    public String query(@PathVariable int id){
        return service.query(id).toString();
    }

}
