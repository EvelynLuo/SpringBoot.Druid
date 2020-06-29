package luoe.demo.dao;

import luoe.demo.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface EmailMapper {
    List<Email> query();
    List<Email> queryAll();

    int save(Email email);

}
