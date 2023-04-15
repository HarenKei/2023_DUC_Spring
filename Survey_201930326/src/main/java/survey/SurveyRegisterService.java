package survey;

import controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class SurveyRegisterService {
    @Autowired
    private SurveyDao surveyDao;

    public SurveyRegisterService() {

    }

    public void register(SurveyCommand scmd) {
        // 이메일로 회원 데이터 조회
        Survey survey = new Survey(
                scmd.getQ1(),
                scmd.getQ2(),
                scmd.getQ3(),
                scmd.getRespondentName(),
                scmd.getRespondentAge(),
                scmd.getRegDate()
        );
        surveyDao.insert(survey);
    }
}
