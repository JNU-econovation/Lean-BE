package com.duriyou.lean.web.dto.Colleges;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CollegesUpdateRequestDto {
    private String name;

    @Builder
    CollegesUpdateRequestDto(String name) {
        this.name = name;
    }
}
