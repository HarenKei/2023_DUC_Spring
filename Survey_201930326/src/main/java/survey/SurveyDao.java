package survey;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class SurveyDao {
    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public class SurveyRowMapper implements RowMapper<Survey> {
        @Override
        public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
            Survey survey = new Survey(
                    rs.getString("Q1"),
                    rs.getString("Q2"),
                    rs.getString("Q3"),
                    rs.getString("RespondentName"),
                    rs.getInt("RespondentAge"),
                    rs.getTimestamp("REGDATE").toLocalDateTime());
            survey.setId(rs.getLong("ID"));
            return survey;
        }
    }

    public List<Survey> selectAll() {
        List<Survey> results = jdbcTemplate.query("select * from SURVEY",new SurveyRowMapper());

        return results;
    }

    public void insert(Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 두 번째 파라미터는 자동 생성되는 키 컬럼 목록을 지정할 때 사용
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
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        survey.setId(keyValue.longValue());
    }
}
