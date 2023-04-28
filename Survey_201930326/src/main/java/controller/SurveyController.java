package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import survey.Survey;
import survey.SurveyRegisterService;

import javax.validation.Valid;
import java.util.List;

//컨트롤러는 클라이언트의 요청을 처리한 뒤 결과를 리턴
//컨트롤러임을 어노테이션을 통해 명시
@Controller
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyRegisterService surveyRegisterService;


    @GetMapping("/surveyForm")
    public String surveyForm(Model model) {
        //매핑을 할때 컨트롤러에서 주소랑 똑같이 함수를 만들라고 함
        model.addAttribute("surveyCommand", new SurveyCommand());
        //모델 객체가 정확히 뭔지는 육도 모름
        //모델 객체에 valid도 보낸대요
        return "survey/surveyForm";
    }

    @PostMapping("/surveyComplete")
    public String surveyComplete(@Valid SurveyCommand req, Errors errors) {
        if(errors.hasErrors()) {
            return "survey/surveyForm";
        }
            try{
                surveyRegisterService.regist(req);
                return "survey/surveyComplete";
            } catch(Exception ex){
                System.out.println("오류났따" + ex);
                return "survey/surveyForm";
            }

    }

    @GetMapping("/surveyList")
    public String surveyList(Model model) {
        try{
            List<Survey> surveyList = surveyRegisterService.selectAll();
            model.addAttribute("list", surveyList);
        }catch (Exception ex){
            System.out.println("오류났다" + ex);
        }
        return "survey/surveyList";
    }


}


