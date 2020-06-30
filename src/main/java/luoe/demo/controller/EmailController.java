package luoe.demo.controller;

import luoe.demo.entity.Email;
import luoe.demo.service.EmailService;
import luoe.demo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    /*@RequestMapping("/query")
    public PageUtils query(HttpServletRequest req) {
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("size"));
        String report_name = req.getParameter("report_name");
    }
    @ResponseBody
    @RequestMapping("/queryAll")
    public List<Email> queryALL(){
        return  emailService.queryAll();
    }

    */

    @RequestMapping("/save")
    public int save(Email email){
        return emailService.save(email);
    }

    @RequestMapping("/queryAll")
    public String queryALL(){
        StringBuffer s = new StringBuffer();
        List<Email> list = emailService.queryAll();
        for(Email e:list){
            s.append(e.toString());
        }
        return s.toString() ;
    }


}
