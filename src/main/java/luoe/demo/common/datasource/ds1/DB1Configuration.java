package luoe.demo.common.datasource.ds1;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
//只从com.stu.dao包下读取dao文件，并且该报下的dao使用本datasource
@MapperScan(basePackages = "luoe.demo.web.dao", sqlSessionTemplateRef = "baseSqlSessionTemplate")
public class DB1Configuration {
    @Bean(name = "baseDataSource")
    //对于多数据源，必须制定primary，否则报错有2个datasource，并且，只能制定一个primary
    @Primary
    //从DB1Config从获取配置信息 hikari
    public DataSource setDataSource(DB1Config dbc) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(dbc.getUrl());
        ds.setUsername(dbc.getUsername());
        ds.setPassword(dbc.getPassword());
        ds.setDriverClassName(dbc.getDriverClassName());
        /*
        HikariDataSource hds = new HikariDataSource();
        hds.setJdbcUrl(dbc.getUrl());
        hds.setUsername(dbc.getUsername());
        hds.setPassword(dbc.getPassword());
        hds.setDriverClassName(dbc.getDriverClassName());*/
        return ds;
    }

    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //指定mapper.xml文件存放位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:luoe/demo/web/dao/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
