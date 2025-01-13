package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.student.council.StudentCouncil;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemsResponseDto {

    private String studentCouncilName;
    private String studentCouncilAddress;
    private List<ItemsNameResponseDto> items;

    public ItemsResponseDto(StudentCouncil entity, List<ItemsNameResponseDto> items) {
        this.studentCouncilName = entity.getName();
        this.studentCouncilAddress = entity.getAddress();
        this.items = items;
    }
}