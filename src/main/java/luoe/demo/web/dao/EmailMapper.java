package luoe.demo.web.dao;

import luoe.demo.web.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmailMapper {

    List<Email> query(@Param("id") int id);

    List<Email> queryAll();

    int save(Email email);

}
