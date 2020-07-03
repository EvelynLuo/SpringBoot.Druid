package luoe.demo.fm.service;

import luoe.demo.fm.dao.RecordMapper;
import luoe.demo.fm.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Service
public class RecordService {
    @Autowired(required = false)
    RecordMapper mapper;

    public List<Record> query(int id) {
        return mapper.query(id);
    }

    public void save(String time, int score, String name, int grade) {
        mapper.insert(time, score, name, grade);
    }
}
