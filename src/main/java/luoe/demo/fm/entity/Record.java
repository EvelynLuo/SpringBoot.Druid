package luoe.demo.fm.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Data
@ToString
@Entity
@Table(name = "record")
public class Record {
    public String time;
    public int score;
    public String username;
    public int grade;
    public int id;


    @Override
    public String toString() {
        return "Record{" +
                "time='" + time + '\'' +
                ", score=" + score +
                ", username='" + username + '\'' +
                ", grade=" + grade +
                ", id=" + id +
                "}\r\n";
    }
}
