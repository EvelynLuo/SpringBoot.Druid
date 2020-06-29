package luoe.demo.dao;

import luoe.demo.entity.Email;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;

class EmailMapperTest {
    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;

    @BeforeAll
    static void setUp() throws IOException {
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }



    @Test
    void save() {
        Email email = new Email();
        email.setReport_name("luoe");
        email.setTime("13:55:00");
        int result = sqlSession.insert("luoe.demo.dao.EmailMapper.save",email);
        sqlSession.commit();
        if (result > 0)
            System.out.println("存储成功");
        else System.out.println("存储失败");
    }

    @Test
    void query() {
    }

    @Test
    void queryAll() {
        JSONObject combine = new JSONObject();
        List<Email> list = sqlSession.selectList("luoe.demo.dao.EmailMapper.queryAll");
        sqlSession.commit();
        JSONObject jsonObject = new JSONObject();
        for(Email e :list){
            jsonObject = JSONObject.fromObject(e) ;
            combine.put(e.getId(),jsonObject);
            System.out.println(jsonObject.toString());
        }
        System.out.println(combine.toString());
    }
}