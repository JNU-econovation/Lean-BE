package com.duriyou.lean.web.dto.Users;

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
    private String collegeName;
    private String department;
    private Boolean isStudentCouncil;
    private LocalDateTime createdAt;

    public UsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.studentNumber = entity.getStudentNumber();
        this.name = entity.getName();
        this.phoneNumber = entity.getPhoneNumber();
        this.collegeName = entity.getCollege().getName();
        this.department = entity.getDepartment();
        this.isStudentCouncil= entity.getIsStudentCouncil();
        this.createdAt = entity.getCreatedAt();
    }
}
