package com.duriyou.lean.web.dto.Student.Council;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.users.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class StudentCouncilResponseDto {
    private Long id;
    private Long userId;
    private String name;
    private String address;

    public StudentCouncilResponseDto(StudentCouncil entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
    }
}
