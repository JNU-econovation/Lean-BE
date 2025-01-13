package com.duriyou.lean.web.dto.items;

import com.duriyou.lean.domain.items.ItemAmounts;
import lombok.Getter;

@Getter
public class ItemAmountsResponseDto {

    private final Integer itemAmount;

    public ItemAmountsResponseDto(ItemAmounts entity){
        this.itemAmount = entity.getAmount();
    }
}
