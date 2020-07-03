package luoe.demo.web.controller;

import luoe.demo.web.entity.Email;
import luoe.demo.web.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Data 2020/6/29 14:19
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;


    @RequestMapping("/get/{id}")
    public String query(@PathVariable int id) {
        return emailService.query(id).toString();
    }

    @RequestMapping("/add/{report_name}")
    public int save(@PathVariable String report_name) {
        Email email = new Email();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String nowStr = now.format(format);
        email.setTime(nowStr);
        email.setReport_name(report_name);
        return emailService.save(email);
    }

    @RequestMapping("/queryAll")
    public String queryALL() {
        StringBuffer s = new StringBuffer();
        List<Email> list = emailService.queryAll();
        for (Email e : list) {
            s.append(e.toString());
            s.append("\r\n");
        }
        return s.toString() ;
    }


}
