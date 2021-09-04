package com.example.cruddemo.repository;

import com.example.cruddemo.domain.entity.StudentEntity;
import com.example.cruddemo.domain.mapper.StudentRowMapper;
import com.example.cruddemo.web.model.request.CreateStudentRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String INSERT_STUDENT_SQL = "insert into student(id, name, school_number) values(?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?";

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String insertStudent(CreateStudentRequest createStudentRequest) {
        String id = String.valueOf(UUID.randomUUID());
        int res = jdbcTemplate.update(INSERT_STUDENT_SQL,
                id,
                createStudentRequest.getName(),
                createStudentRequest.getSchoolNumber());
        return res == 1 ? id : "Error took when insert student!";
    }

    public List<StudentEntity> getStudentById(String id) {
        return jdbcTemplate.query(SELECT_STUDENT_BY_ID, new StudentRowMapper(), id);
    }
}
