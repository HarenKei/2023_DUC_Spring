package survey;

import java.time.LocalDateTime;

public class Survey {
    private Long id; //primary key
    private String q1;
    private String q2;
    private String q3;
    private String respondentName;
    private int respondentAge;
    private LocalDateTime registerDateTime;

    public Survey(String q1, String q2, String q3, String respondentName, int respondentAge, LocalDateTime registerDateTime) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.respondentName = respondentName;
        this.respondentAge = respondentAge;
        this.registerDateTime = registerDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }
}
