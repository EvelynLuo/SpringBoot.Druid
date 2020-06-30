package luoe.demo.dao;

import luoe.demo.entity.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/

@Mapper
public interface RecordMapper {
    List<Record> query(int id);
}
