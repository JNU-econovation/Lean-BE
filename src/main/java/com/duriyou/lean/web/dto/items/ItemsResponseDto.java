package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.items.Items;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemsResponseDto {
    private Long id;
    private String name;
    private String studentCouncilName;
    private String studentCouncilAddress;

    public ItemsResponseDto(Items entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.studentCouncilName = entity.getStudentCouncil().getName();
        this.studentCouncilAddress = entity.getStudentCouncil().getAddress();
    }
}