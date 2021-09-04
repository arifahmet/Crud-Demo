package com.example.cruddemo.domain.mapper;

import com.example.cruddemo.domain.entity.StudentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentEntity> {

    @Override
    public StudentEntity mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final StudentEntity employee = new StudentEntity();

        employee.setId(rs.getString("ID"));
        employee.setName(rs.getString("NAME"));
        employee.setSchoolNumber(rs.getString("SCHOOL_NUMBER"));

        return employee;
    }
}
