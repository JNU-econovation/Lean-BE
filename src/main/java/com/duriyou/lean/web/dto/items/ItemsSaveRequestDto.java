package com.duriyou.lean.web.dto.items;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {
    private String name;
    private ItemAmountsSaveRequestDto itemAmounts;

    @Builder
    public ItemsSaveRequestDto(String name, ItemAmountsSaveRequestDto itemAmounts){
        this.name = name;
        this.itemAmounts = itemAmounts;
    }
}
