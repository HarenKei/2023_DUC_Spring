package config;

import chapter07.*;
import jdk.jfr.DataAmount;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"db","chapter07"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://13.239.60.239:3306/daelim?characterEncoding=utf8");
        ds.setUsername("spring");
        ds.setPassword("daelimspring");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

//    @Bean
//    public MemberRegisterService memberRegisterService() {
//        return new MemberRegisterService();
//    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        return changePasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

//    @Bean
//    public MemberListPrinter memberListPrinter() {
//        return new MemberListPrinter();
//    }

//    @Bean
//    public MemberInfoPrinter memberInfoPrinter() {
//        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//        return memberInfoPrinter;
//    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(2);
        versionPrinter.setMajorVersion(1);
        return versionPrinter;
    }

}