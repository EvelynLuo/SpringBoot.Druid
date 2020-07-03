package luoe.demo.fm.dao;

import luoe.demo.fm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    List<User> query(@Param("name") String name);//昵称查询

    List<User> queryAll();

    List<User> verify(@Param("phone") String phone);//手机号验证

}
