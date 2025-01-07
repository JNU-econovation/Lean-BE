package com.duriyou.lean.web.dto.Student.Council;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import com.duriyou.lean.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentCouncilSaveRequestDto {
    private Long userId;
    private String name;
    private String address;

    @Builder
    public StudentCouncilSaveRequestDto(Long userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public StudentCouncil toEntity(Users user) {
        return StudentCouncil.builder()
                .user(user)
                .name(name)
                .address(address)
                .build();
    }
}
