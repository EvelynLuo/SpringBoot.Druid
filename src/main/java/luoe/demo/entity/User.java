package luoe.demo.entity;

/**
 * @Data 2020/6/30 9:26
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class User {
    private String name;
    private String password;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
