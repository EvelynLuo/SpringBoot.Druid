package luoe.demo.fm.service;

import luoe.demo.fm.dao.UserMapper;
import luoe.demo.fm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Data 2020/6/30 9:26
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class UserService {
    @Autowired(required=false)
     UserMapper mapper;

    public List<User> query(String name){return mapper.query(name);}//昵称查询
    public List<User> queryAll(){return mapper.queryAll();}

    public List<User> verify(String phone) {
        return mapper.verify(phone);
    }//手机号验证

    public void insert(User user) {
        mapper.insert(user);
    }
}
