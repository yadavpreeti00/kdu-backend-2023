package com.preeti.jdb.service;

import com.preeti.jdb.entity.User;
import com.preeti.jdb.repository.IUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.UUID;

@Slf4j
@Repository
public class UserDaoImpl implements IUserDao {


   private final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());

    @Override
    public void insert(User user)
    {
        String sql="INSERT INTO users VALUES (?,?,?,?,?)";
        Object[] arg={user.getId(),user.getUsername(),user.getLoggedin(),user.getTimeZone(),user.getTenantId()};
        int row_inserted=jdbcTemplate.update(sql,arg);
        log.info("row inserted "  + row_inserted);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username = ?, loggedin = ?, time_zone = ? WHERE id = ? AND tenant_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getLoggedin(), user.getTimeZone(), user.getId(), user.getTenantId());
    }

    @Override
    public User select(UUID id, UUID tenantId) {
        String sql = "SELECT * FROM users WHERE id = ? AND tenantId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id, tenantId}, (rs, rowNum) -> {
            User user = User.builder()
                    .id(rs.getObject("id", UUID.class))
                    .username(rs.getString("username"))
                    .loggedin(rs.getShort("loggedin"))
                    .timeZone(rs.getString("timeZone"))
                    .tenantId(rs.getObject("tenantId", UUID.class))
                    .build();
            return user;
        });
    }


    @Override
    public void delete(UUID id, UUID tenantId) {
        String sql = "DELETE FROM users WHERE id = ? AND tenant_id = ?";
        jdbcTemplate.update(sql, id, tenantId);
    }


    public DataSource dataSource()
    {
        String URL = "jdbc:mysql://127.0.0.1:3306/exercise5";
        String PASSWORD = "1234";
        String USERNAME = "root";
        DataSource dataSource=new DriverManagerDataSource(URL,USERNAME,PASSWORD);
        return dataSource;
    }
}

//    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
//    @Override
//    public void insert(Student student) {
//
//        String sql="INSERT INTO Student VALUES (?,?,?)";
//        Object[] arg={student.getRoll_no(),student.getStudent_name(),student.getStudent_address()};
//        int row_inserted=jdbcTemplate.update(sql,arg);
//
//        System.out.println("DAta inserted "  + row_inserted);
//    }
//
//    public DataSource dataSource()
//    {
//        String URL = "jdbc:mysql://127.0.0.1:3306/School";
//        String PASSWORD = "1234";
//        String USERNAME = "root";
//        DataSource dataSource=new DriverManagerDataSource(URL,USERNAME,PASSWORD);
//        return dataSource;
//    }