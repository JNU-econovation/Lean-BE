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
    private String password;
    private String name;
    private String phoneNumber;
    private Long collegeId;
    private String department;

    @Builder
    public UsersSaveRequestDto(String studentNumber, String password, String name, String phoneNumber, Long collegeId, String department) {
        this.studentNumber = studentNumber;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.collegeId = collegeId;
        this.department = department;
    }

    public Users toEntity(Colleges college, String encodedPassword) {
        return Users.builder()
                .studentNumber(studentNumber)
                .password(encodedPassword)
                .name(name)
                .phoneNumber(phoneNumber)
                .college(college)
                .department(department)
                .build();
    }
}
