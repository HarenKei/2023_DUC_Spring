package config;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import survey.SurveyDao;
import survey.SurveyRegisterService;

@Configuration
@EnableTransactionManagement
public class SurveyConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://13.239.60.239:3306/daelim?characterEncoding=utf8");
        ds.setUsername("spring");
        ds.setPassword("daelimspring");
        ds.setInitialSize(2);
        ds.setMinEvictableIdleTimeMillis(-1);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

    @Bean
    public SurveyDao surveyDao() {
        return new SurveyDao(dataSource());
    }

    @Bean
    public SurveyRegisterService surveyRegisterService() {
        return new SurveyRegisterService();
    }

}