package controller;

import org.hibernate.validator.constraints.NotEmpty;
import java.time.LocalDateTime;

//@NotBlank : null이 아니여야 하며, 하나 이상의 공백이 아닌 문자 포함 필요
//@NotEmpty : null이거나 비어있으면 안됨.

public class SurveyCommand {
    //q1 : 필수항목
    //q2 : 필수항목
    //q3 : 공백을 허용하지 않는 필수항목
    //응답자이름 : 공백을 허용하지 않는 필수항목
    //응답자 나이 : 1보다 같거나 커야함.

    @NotEmpty
    private String q1;

    @NotEmpty
    private String q2;

    @NotEmpty
    private String q3;

    @NotEmpty
    private String respondentName;

    private int respondentAge;

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public void setRespondentAge(int respondentAge) {
        this.respondentAge = respondentAge;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ3() {
        return q3;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public int getRespondentAge() {
        return respondentAge;
    }
}
