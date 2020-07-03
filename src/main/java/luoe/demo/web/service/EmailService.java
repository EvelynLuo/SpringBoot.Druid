package luoe.demo.web.service;


import luoe.demo.web.dao.EmailMapper;
import luoe.demo.web.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Data 2020/6/29 10:40
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class EmailService {

    @Autowired(required = false)
    private EmailMapper mapper;

    public List<Email> query(int id) {
        /*List<Email> query = mapper.query();
        for(Email e :query){
            if(e.getTime()!=null&&!"".equals(e.getTime().trim())){
                e.setTime(e.getTime()+":00");
            }
        }*/
        return mapper.query(id);
    }

    public int save(Email email) {

        return mapper.save(email);
    }

    public List<Email> queryAll() {
        return mapper.queryAll();
    }
}
