package Demo07;

import Demo01.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;

public class JDBCTemplateDemo {
    public static void main(String[] args) {
//设置数据库信息
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///spring");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");


//创建模板对象
        JdbcTemplate jdbcTemplate =new JdbcTemplate(driverManagerDataSource);
        //添加操作
//        String sql= "insert into user values(?,?,?)";
//        jdbcTemplate.update(sql,"1","mary" ,"123" );

        //修改操作
//        String sql1="update user set password =? where name = ?";
//        jdbcTemplate.update(sql1,"456","mary");

        //删除操作
//        String sql= "delete from user where name =?";
//        jdbcTemplate.update(sql,"mary");

        //查询操作
        //查询所有
//        String sql = "select count(*) from user";
//        int cout=jdbcTemplate.queryForObject(sql,Integer.class);
//        System.out.println(cout);

        //查询返回对象,自己做属性封装到RowMapperDemo实现接口RowMapper<User>
//        String sql="select * from user where name= ?";
//        User user=jdbcTemplate.queryForObject(sql,new RowMapperDemo(),"mary");
//        System.out.println(user);
//
        //查询返回list集合
        String sql="select * from user";
        List<User> list= jdbcTemplate.query(sql,new RowMapperDemo());
        System.out.println(list);
    }

    @Test
    public void jdbc() throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql:///spring","root","root");
            String sql="select count(*) from user where name= ?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"mary");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            resultSet.close();
            connection.close();
            preparedStatement.close();
        }
    }
}
class RowMapperDemo implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user=new User();
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}