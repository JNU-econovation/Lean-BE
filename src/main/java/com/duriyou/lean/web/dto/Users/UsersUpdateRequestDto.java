package com.duriyou.lean.web.dto.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String studentNumber;
    private String name;
    private String phoneNumber;
    private Long collegeId;
    private String department;

    @Builder
    UsersUpdateRequestDto(String studentNumber, String name, String phoneNumber, Long collegeId, String department) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.collegeId = collegeId;
        this.department = department;
    }
}
