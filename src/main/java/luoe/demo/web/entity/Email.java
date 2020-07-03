package luoe.demo.web.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Data 2020/6/29 10:16
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Data
@ToString
@Entity
@Table(name = "email")
public class Email {
    @Id
    @Column(name = "id")
    private Integer id;
    private String report_name;
    private String time;
    private Date create_time;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", report_name='" + report_name + '\'' +
                ", time='" + time + '\'' +
                ", create_time=" + create_time +
                "}\r\n";
    }
}
