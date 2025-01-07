package com.duriyou.lean.web.dto.Colleges;

import com.duriyou.lean.domain.colleges.Colleges;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AllCollegesResponseDto {
    private final List<CollegesResponseDto> colleges;

    public AllCollegesResponseDto(List<Colleges> colleges) {
        this.colleges = colleges.stream()
                .map(CollegesResponseDto::new)
                .collect(Collectors.toList());
    }
}
