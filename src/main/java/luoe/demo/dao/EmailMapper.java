package luoe.demo.dao;

import luoe.demo.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmailMapper {
    List<Email> query();
    List<Email> queryAll();

    int save(Email email);

}
