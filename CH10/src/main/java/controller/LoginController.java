package controller;

import chapter10.MemberNotFoundException;
import chapter10.WrongPasswordException;
import chapter11.AuthInfo;
import chapter11.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String form(LoginCommand loginCommand, @CookieValue(value="REMEBER", required=false)Cookie cookie) {
        if(cookie != null) {
            loginCommand.setEmail(cookie.getValue());
            loginCommand.setRememberEmail(true);

        }
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
        if(errors.hasErrors()) {
            return "login/loginForm";
        }

        try{
            AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
            //세션에 로그인 정보 저장
            session.setAttribute("authInfo", authInfo);

            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
            rememberCookie.setPath("/");
            if(loginCommand.isRememberEmail()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 30);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);


            return "login/loginSuccess";
        }catch (WrongPasswordException ex){
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        } catch(MemberNotFoundException ex1) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";

        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}


