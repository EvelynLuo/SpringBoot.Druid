package luoe.demo.fm.dao;

import luoe.demo.fm.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/

@Mapper
public interface RecordMapper {
    void insert(@Param("time") String time, @Param("score") int score, @Param("username") String username, @Param("grade") int grade);

    List<Record> query(@Param("id") int id);
}

