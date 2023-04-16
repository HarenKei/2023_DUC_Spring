package config;

import controller.SurveyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//컨트롤러에 대한 Config임을 알리는 어노테이션 선언.
@Configuration
public class ControllerConfig {
    //SurveyController 빈 객체 생성
    @Bean
    public SurveyController surveyController() {
        SurveyController surveyController = new SurveyController();
        return surveyController;
    }
}