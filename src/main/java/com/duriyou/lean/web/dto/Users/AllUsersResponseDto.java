package com.duriyou.lean.web.dto.Users;

import com.duriyou.lean.domain.users.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AllUsersResponseDto {
    private Long id;
    private String studentNumber;
    private String name;

    public AllUsersResponseDto(Users entity) {
        this.id = entity.getId();
        this.studentNumber = entity.getStudentNumber();
        this.name = entity.getName();
    }
}
