package pl.szewczyk.database;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class DbConfig {


//    private DataSource dataSource;  //i to już jest załądowane z properties
//
//    @Autowired
//    public DbConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }



    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder =
                DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/umRepn4fGw");
        dataSourceBuilder.username("umRepn4fGw");
        dataSourceBuilder.password("ASIXIN2FBt");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return  dataSourceBuilder.build();
    }

/// To można przenieść do pliku konfiguracyjnego lub w application.properties, jeśli jest jedna baza to propperties jest ok
    @Bean
    public JdbcTemplate getJdbcTemplate(){
     //   return new JdbcTemplate(getDataSource());
        return new JdbcTemplate(getDataSource());
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE ttt(test_id int,title varchar(255), url varchar(255), PRIMARY KEY (test_id))";
//        getJdbcTemplate().update(sql);
//    }

}
