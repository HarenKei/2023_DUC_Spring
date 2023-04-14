package controller;

import chapter10.DuplicationMemberException;
import chapter10.MemberRegisterService;
import chapter10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

//    @GetMapping("/step2")
//    public String handleStep2Get() {
//        return "redirect:/register/step1";
//        //이거 많이 쓴다고 함 - 육
//    }

    //RequestParam 어노테이션 이용
    //defaultValue는 기본값이겠지 당연히 ㅇㅇ
    //required = false : 이 값이 안들어와도 에러를 내지는 않겠다~
    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value="agree", defaultValue = "false") Boolean agree
            , Model model) {
        System.out.println("[POST] step2 >>>");
        System.out.println("step2::agree = "+ agree);
        if(!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest",new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handleStep2Get() {
        System.out.println("[GET] step2 >>>");
        return "redirect:/register/step1";
    }

//    @PostMapping("/step2")
//    public String handleStep2(HttpServletRequest request) {
//        String agree = request.getParameter("agree");
//        System.out.println("agree : " + agree);
//        if(agree == null || !agree.equals("true")) {
//            return "register/step1";
//        }
//        return "register/step2";
//    }

//    @PostMapping("/register/step3")
//    public String handleStep3(RegisterRequest registerRequest) {
//        System.out.println("[POST] step3 >>>");
//        try {
//            memberRegisterService.regist(registerRequest);
//            return "register/step3";
//        } catch (DuplicationMemberException ex) {
//            return "register/step2";
//        }
//    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest registerRequest, Errors errors) {
        System.out.println("[POST] step3 >>>");
        new RegisterRequestValidator().validate(registerRequest, errors);
        if(errors.hasErrors()) {
            return "register/step2";
        }
        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (DuplicationMemberException ex) {
            errors.rejectValue("email", "duplicate");
            return "register/step2";
        }
    }

//    @PostMapping("/step3")
//    public String handleStep3(@ModelAttribute("formData") RegisterRequest req) {
//        //스프링이 알아서 커맨드 객체의 세터들을 찾음
//        //킹갓이요
////        String email = request.getParameter("email");
////        String name = request.getParameter("name");
////        String password = request.getParameter("password");
////        String confirmPassword = request.getParameter("confirmPassword");
////
////        RegisterRequest req = new RegisterRequest();
////        req.setEmail(email);
////        req.setName(name);
////        req.setPassword(password);
////        req.setConfirmPassword(confirmPassword);
//
//        try{
//            memberRegisterService.regist(req);
//            return "register/step3";
//        } catch (DuplicationMemberException ex) {
//            return "register/step2";
//        }
//    }
//    @PostMapping("/step3")
//    public String handleStep3(HttpServletRequest request) {
////        String email = request.getParameter("email");
////        String name = request.getParameter("name");
////        String password = request.getParameter("password");
////        String confirmPassword = request.getParameter("confirmPassword");
////
////        RegisterRequest req = new RegisterRequest();
////        req.setEmail(email);
////        req.setName(name);
////        req.setPassword(password);
////        req.setConfirmPassword(confirmPassword);
//
//        try{
//            memberRegisterService.regist(req);
//            return "register/step3";
//        } catch (DuplicationMemberException ex) {
//            return "register/step2";
//        }
//    }




}
