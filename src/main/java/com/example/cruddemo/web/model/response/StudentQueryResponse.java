package com.example.cruddemo.web.model.response;

import com.example.cruddemo.domain.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentQueryResponse {
    private String name;
    private String schoolNumber;
    public static StudentQueryResponse of(StudentEntity studentEntity) {
        return StudentQueryResponse.builder()
                .name(studentEntity.getName())
                .schoolNumber(studentEntity.getSchoolNumber()).build();
    }
}
