package com.duriyou.lean.web.dto.Student.Council;

import com.duriyou.lean.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentCouncilUpdateRequestDto {
    private Long userId;
    private String name;
    private String address;

    @Builder
    StudentCouncilUpdateRequestDto(String name, Long userId, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }
}
