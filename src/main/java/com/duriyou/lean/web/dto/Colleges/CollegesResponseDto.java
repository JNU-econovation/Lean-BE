package com.duriyou.lean.web.dto.Colleges;

import com.duriyou.lean.domain.colleges.Colleges;
import lombok.Getter;

@Getter
public class CollegesResponseDto {
    private final Long id;
    private final String name;

    public CollegesResponseDto(Colleges college) {
        this.id = college.getId();
        this.name = college.getName();
    }
}