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
    private Long collegeId;
    private String department;

    @Builder
    public UsersSaveRequestDto(String studentNumber, String name, String phoneNumber, Long collegeId, String department) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.collegeId = collegeId;
        this.department = department;
    }

    public Users toEntity(Colleges college) {
        return Users.builder()
                .studentNumber(studentNumber)
                .name(name)
                .phoneNumber(phoneNumber)
                .college(college)
                .department(department)
                .build();
    }
}
