package luoe.demo.fm.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Data 2020/6/30 9:26
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
@Data
@ToString
@Entity
@Table(name = "user")
public class User {
    private String name;
    private String password;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                "}\r\n";
    }
}
