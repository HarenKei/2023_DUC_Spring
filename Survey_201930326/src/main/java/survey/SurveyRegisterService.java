package survey;

import controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class SurveyRegisterService {

    //SurveyDao 의존성 주입 (Autowired)
    @Autowired
    private SurveyDao surveyDao;

    public SurveyRegisterService() {

    }

    public void regist(SurveyCommand cmd) {
        // 이메일로 회원 데이터 조회
        Survey survey = new Survey(cmd.getQ1(), cmd.getQ2(), cmd.getQ3(), cmd.getRespondentName(), cmd.getRespondentAge(), LocalDateTime.now());
        surveyDao.insert(survey);
    }

    public List<Survey> selectAll() {
        List<Survey> surveyList = surveyDao.selectAll();
        return surveyList;
    }
}
