package luoe.demo.entity;

/**
 * @Data 2020/6/30 13:55
 * @Author ruary
 * @Version 1.0
 * @Describe
 **/
public class Record {
    public String time;
    public int score;
    public String username;
    public int grade;
    public int id;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "time='" + time + '\'' +
                ", score=" + score +
                ", username='" + username + '\'' +
                ", grade=" + grade +
                ", id=" + id +
                '}';
    }
}
