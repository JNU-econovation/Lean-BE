package com.duriyou.lean.web.dto.Users;

import com.duriyou.lean.domain.colleges.Colleges;
import com.duriyou.lean.domain.users.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UsersResponseDto {
    private Long id;
    private String studentNumber;
    private String name;
    private String phoneNumber;
    private Colleges college;
    private String department;
    private LocalDateTime createdAt;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.studentNumber = entity.getStudentNumber();
        this.name = entity.getName();
        this.phoneNumber = entity.getPhoneNumber();
        this.college = entity.getCollege();
        this.department = entity.getDepartment();
        this.createdAt = entity.getCreatedAt();
    }
}
