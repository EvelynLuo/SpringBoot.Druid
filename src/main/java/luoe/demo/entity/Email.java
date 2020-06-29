package luoe.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Data 2020/6/29 10:16
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class Email  {
    private Integer id;
    private String report_name;
    private String time;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReport_name() {
        return report_name;
    }

    public void setReport_name(String report_name) {
        this.report_name = report_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
