package com.preeti.jdb.service;


import com.preeti.jdb.model.Shift;
import com.preeti.jdb.repository.IShiftDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository

public class ShiftDaoImpl implements IShiftDao {

    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());

    @Override
    public Shift createShift(Shift shift) {
        final String sql = "INSERT INTO shift (id, shift_type_id, name, date_start, date_end, time_start, time_end, created_at, updated_at, time_zone, tenant_id)" +
                " VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, shift.getId(), shift.getShiftTypeId(), shift.getName(),shift.getDateStart(),shift.getDateEnd()
        ,shift.getTimeStart(),shift.getTimeEnd(),shift.getCreatedAt(),shift.getUpdatedAt(),shift.getTenantId());
        return shift;
    }

    @Override
    public Shift selectShift(UUID id,UUID tenantId) {
        String sql = "SELECT * FROM shift WHERE id = ? AND tenant_id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id, tenantId}, (rs, rowNum) -> {
            Shift shift = new Shift();
            shift.setId(rs.getObject("id", UUID.class));
            shift.setShiftTypeId(rs.getObject("shift_type_id",UUID.class));
            shift.setName(rs.getString("name"));
            shift.setDateStart(rs.getObject("date_start",LocalDate.class));
            shift.setDateEnd(rs.getObject("date_end", LocalDate.class));
            shift.setTimeStart(rs.getObject("time_start",Time.class));
            shift.setTimeEnd(rs.getObject("time_end", Time.class));
            shift.setCreatedAt(rs.getObject("created_at",LocalDateTime.class));
            shift.setUpdatedAt(rs.getObject("updated_at", LocalDateTime.class));
            shift.setTimeZone(rs.getString("time_zone"));
            shift.setTenantId(rs.getObject("tenant_id", UUID.class));
            return shift;
        });
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
