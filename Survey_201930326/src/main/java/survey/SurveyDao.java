package survey;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;
import java.util.List;

public class SurveyDao {
    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //RowMapper 인터페이스를 사용하면 원하는 형태의 결과값 반환이 가능.
    public class SurveyRowMapper implements RowMapper<Survey> {
        @Override
        public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
            //ResultSet 객체에 값을 담아와서 Survey 객체에 저장한다. 그리고 그것을 rowNum 만큼 반복한다.
            Survey survey = new Survey(
                    rs.getString("Q1"),
                    rs.getString("Q2"),
                    rs.getString("Q3"),
                    rs.getString("RespondentName"),
                    rs.getInt("RespondentAge"),
                    rs.getTimestamp("REGDATE").toLocalDateTime());
            survey.setId(rs.getInt("ID"));
            return survey;
        }
    }

    //전체 응답 리스트를 위함.
    public List<Survey> selectAll() {
        List<Survey> results = jdbcTemplate.query("select * from SURVEY",new SurveyRowMapper());
        return results;
    }

    //DB에 Survey를 insert 하기 위함.
    public void insert(Survey survey) {
        //ID값이 AUTO_INCREMENT일 경우 insert 실행 시 ID를 직접 value로 지정하지 않는다.
        //-> 어떤 엔티티를 테이블에 삽입하고 나서 그 엔티티에게 할당 된 아이디 값을 전달받고 싶은 경우 사용.
        //KeyHolder는 자동으로 생성된 키 값을 구할 수 있는 방법을 제공한다.
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 두 번째 파라미터는 자동 생성되는 키 컬럼 목록을 지정할 때 사용 (KeyHolder)
                PreparedStatement preparedStatement = con.prepareStatement(
                        "insert into SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) values (?,?,?,?,?,?)"
                        , new String[] {"ID"});
                preparedStatement.setString(1, survey.getQ1());
                preparedStatement.setString(2, survey.getQ2());
                preparedStatement.setString(3, survey.getQ3());
                preparedStatement.setString(4, survey.getRespondentName());
                preparedStatement.setInt(5, survey.getRespondentAge());
                preparedStatement.setTimestamp(6, Timestamp.valueOf(survey.getRegisterDateTime()));
                return preparedStatement;
            }
        });
    }


}
