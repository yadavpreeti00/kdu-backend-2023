package com.preeti.jdb.service;

import com.preeti.jdb.model.ShiftType;
import com.preeti.jdb.repository.IShiftTypeDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.ZonedDateTime;
import java.util.UUID;

@Repository
public class ShiftTypeDaoImpl implements IShiftTypeDao {

    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());

    @Override
    public ShiftType getShiftType(UUID id, UUID tenantId) {

            String sql = "SELECT * FROM shift_types WHERE id = ? AND tenant_id = ?";

            return jdbcTemplate.queryForObject(sql, new Object[]{id, tenantId}, (rs, rowNum) ->
                    ShiftType.builder()
                            .id(rs.getObject("id", UUID.class))
                            .uqName(rs.getString("uq_name"))
                            .description(rs.getString("description"))
                            .active(rs.getBoolean("active"))
                            .createdAt(ZonedDateTime.from(rs.getTimestamp("created_at").toInstant()))
                            .updatedAt(ZonedDateTime.from(rs.getTimestamp("updated_at").toInstant()))
                            .timeZone(rs.getString("time_zone"))
                            .tenantId(rs.getObject("tenant_id", UUID.class))
                            .build());
    }

    @Override
    public ShiftType createShiftType(ShiftType shiftType) {
        String sql = "INSERT INTO shift_type (id, uq_name, description, active, created_at, updated_at, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, shiftType.getId(), shiftType.getUqName(), shiftType.getDescription(), shiftType.isActive(),
                shiftType.getCreatedAt(), shiftType.getUpdatedAt(), shiftType.getTimeZone(), shiftType.getTenantId());

        return shiftType;
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
