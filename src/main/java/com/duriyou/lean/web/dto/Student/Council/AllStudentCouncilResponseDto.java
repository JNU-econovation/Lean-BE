package com.duriyou.lean.web.dto.Student.Council;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.users.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AllStudentCouncilResponseDto {
    private Long id;
    private Long userId;
    private String name;
    private String address;
    private String college;

    public AllStudentCouncilResponseDto(StudentCouncil entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.college =entity.getUser().getCollege().getName();
    }
}
