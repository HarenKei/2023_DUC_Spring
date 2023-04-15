package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//컨트롤러에 대한 Config임을 알리는 어노테이션 선언.
@Configuration
public class ControllerConfig {
    @Autowired
    private AuthService authService;

    //SurveyController 빈 객체 생성
    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }

}