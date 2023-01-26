package com.preeti.jdb.service;

import com.preeti.jdb.entity.ShiftUser;
import com.preeti.jdb.repository.IShiftUserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.UUID;

@Repository
public class ShiftUserDaoImpl implements IShiftUserDao {

    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
    @Override
    public ShiftUser createShiftUser(ShiftUser shiftUser) {
        final String sql = "INSERT INTO shift_user (id, shift_id, tenant_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, shiftUser.getId(), shiftUser.getShiftId(), shiftUser.getTenantId());
        return shiftUser;
    }

    @Override
    public ShiftUser selectShiftUser(UUID id, UUID tenantId) {
        final String sql = "SELECT id, shift_id, tenant_id FROM shift_user WHERE id = ? AND tenant_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id, tenantId }, (rs, rowNum) -> {
            ShiftUser su = new ShiftUser();
            su.setId(rs.getObject("id", UUID.class));
            su.setShiftId(rs.getObject("shift_id", UUID.class));
            su.setTenantId(rs.getObject("tenant_id", UUID.class));
            return su;
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
