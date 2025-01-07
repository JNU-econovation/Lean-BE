package com.duriyou.lean.web.dto.Users;

import com.duriyou.lean.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SigninRequestDto {
    private String studentNumber;
    private String password;
}
