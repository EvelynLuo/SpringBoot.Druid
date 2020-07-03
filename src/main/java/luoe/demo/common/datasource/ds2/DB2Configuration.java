package luoe.demo.common.datasource.ds2;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
//只从com.stu.test2dao包下读取dao文件，并且该报下的dao使用本datasource
@MapperScan(basePackages = "luoe.demo.fm.dao", sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class DB2Configuration {
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource setDataSource(DB2Config dbc) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(dbc.getUrl());
        ds.setUsername(dbc.getUsername());
        ds.setPassword(dbc.getPassword());
        ds.setDriverClassName(dbc.getDriverClassName());
      /*  HikariDataSource hds = new HikariDataSource();
        hds.setJdbcUrl(dbc.getUrl());
        hds.setUsername(dbc.getUsername());
        hds.setPassword(dbc.getPassword());
        hds.setDriverClassName(dbc.getDriverClassName());*/
        return ds;
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:luoe/demo/fm/dao/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "slaveSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
