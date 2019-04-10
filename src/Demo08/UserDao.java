package Demo08;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    public void add(){
//        String sql= "insert into user values(?,?,?)";
//        jdbcTemplate.update(sql,"1","mary" ,"123" );
//    }

    public void lessMoney(){
        String sql="update user set salary = salary-? where name= ?";
        jdbcTemplate.update(sql,"1000","小王");
    }
    public void moreMoney(){
        String sql="update user set salary = salary+? where name= ?";
        jdbcTemplate.update(sql,"1000","小马");
    }
}
