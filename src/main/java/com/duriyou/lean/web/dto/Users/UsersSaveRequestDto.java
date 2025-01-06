package com.duriyou.lean.web.dto.Users;


import com.duriyou.lean.domain.colleges.Colleges;
import com.duriyou.lean.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String studentNumber;
    private String name;
    private String phoneNumber;
    private Colleges college;
    private String department;

    @Builder
    public UsersSaveRequestDto(String studentNumber, String name, String phoneNumber, Colleges college, String department) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.college = college;
        this.department = department;
    }

    public Users toEntity() {
        return Users.builder()
                .studentNumber(studentNumber)
                .name(name)
                .phoneNumber(phoneNumber)
                .college(college)
                .department(department)
                .build();
    }
}
