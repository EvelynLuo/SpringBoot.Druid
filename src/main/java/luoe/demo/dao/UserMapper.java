package luoe.demo.dao;

import luoe.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> query(String name);//昵称查询
    List<User> queryAll();
    List<User> verify(String phone);//手机号验证
    int save(User user);
}
