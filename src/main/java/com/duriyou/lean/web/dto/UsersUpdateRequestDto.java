package com.duriyou.lean.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String studentNumber;
    private String name;
    private String phoneNumber;
    private Colleges college;
    private String department;

    @Builder
    UsersUpdateRequestDto(String studentNumber, String name, String phoneNumber, Colleges college, String department) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.department = department;
    }
}
