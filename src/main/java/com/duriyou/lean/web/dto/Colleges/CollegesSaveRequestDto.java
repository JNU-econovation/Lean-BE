package com.duriyou.lean.web.dto.Colleges;

import com.duriyou.lean.domain.colleges.Colleges;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CollegesSaveRequestDto {
    private String name;

    @Builder
    public CollegesSaveRequestDto(String name) {
        this.name = name;
    }

    public Colleges toEntity() {
        return Colleges.builder()
                .name(name)
                .build();
    }
}
