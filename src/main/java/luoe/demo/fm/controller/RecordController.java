package luoe.demo.fm.controller;

import luoe.demo.fm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/save/{time}&{score}&{username}&{grade}")
    public String save(@PathVariable String time, @PathVariable int score, @PathVariable String username, @PathVariable int grade) {
        service.save(time, score, username, grade);
        return "ok record save " + time;
    }

    @RequestMapping("/get/{id}")
    public String query(@PathVariable int id) {
        return service.query(id).toString();
    }

}
