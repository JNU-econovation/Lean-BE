package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.items.Items;
import lombok.Getter;

@Getter
public class ItemsNameResponseDto {
    private Long id;
    private String name;

    public ItemsNameResponseDto(Items entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
